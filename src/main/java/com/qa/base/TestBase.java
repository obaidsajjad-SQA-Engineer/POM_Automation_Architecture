package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {
    public AndroidDriver mobileDriver;
    public String appiumServer = "127.0.0.1";
    public int appiumPort = 4723;
    public String apkLocation= "D:\\Eclipse Projects\\com.qa.project_pom_architecture\\applications\\com.llamalab.automate_1.31.1-191_minAPI14(arm64-v8a,armeabi-v7a,x86,x86_64)(nodpi)_apkmirror.com.apk";
    protected Properties prop;

    public TestBase() {
        try (FileInputStream ip = new FileInputStream(
                Paths.get(System.getProperty("user.dir"), "src", "main", "java", "com", "qa", "config", "OR.properties").toString())) {
            prop = new Properties();
            prop.load(ip);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }

    public AndroidDriver initializeDriver() {
        try {
            URL appiumURL = URI.create("http://" + appiumServer + ":" + appiumPort + "/wd/hub").toURL();
            DesiredCapabilities capabilities = setAppCapabilitiesAndroid();
            mobileDriver = new AndroidDriver(appiumURL, capabilities);
        } catch (IOException e) {
            System.err.println("Error initializing AndroidDriver: " + e.getMessage());
        }
        return mobileDriver;
    }

    public DesiredCapabilities setAppCapabilitiesAndroid() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "uiAutomator2");
        desiredCapabilities.setCapability("app", apkLocation);
        desiredCapabilities.setCapability("platformVersion", "8.0");
        return desiredCapabilities;
    }

    public String takeScreenshot(String testCaseName, AndroidDriver mobileDriver) throws IOException {
        TakesScreenshot takeScreenshot = (TakesScreenshot) mobileDriver;
        File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}
