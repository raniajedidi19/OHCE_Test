package org.ohce.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public base () {

        PageFactory.initElements(driver,this);

        try {
            File file = new File("src/main/java/org/ohce/envProperties/dev.properties");
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lunchBrowser() {

        if (prop.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (prop.getProperty("BROWSER").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
    }

    public static void closeBrowser() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.close();
        driver.quit();
    }


    }
