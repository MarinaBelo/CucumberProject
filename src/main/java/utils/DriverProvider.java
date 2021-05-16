package utils;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static utils.Constants.FILE_NAME_WITH_PROPERTIES;

public class DriverProvider {

    public static final DriverProvider INSTANCE = new DriverProvider();
    private ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();

    private DriverProvider() {
    }

    public static Properties loadProperties () {
        String current = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String resoursesFolder = "src" + separator + "main" + separator + "resourсes";
        Path file = Paths.get(current + separator + resoursesFolder + separator + FILE_NAME_WITH_PROPERTIES);
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("No such properties file");
        }
        return properties;
    }

    public WebDriver getDriver() {
        if (DRIVER.get() == null) {
            String browserType = loadProperties().getProperty("browserType");
            DRIVER.set(DriverFactory.createInstance(BrowserType.valueOf(browserType)));
        }
        return DRIVER.get();
    }

    public void removeDriver() {
        DRIVER.get().quit();
        DRIVER.remove();
    }
}
