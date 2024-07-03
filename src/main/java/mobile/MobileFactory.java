package mobile;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileFactory {
    public static AndroidDriver getAndroidDriver() {
        try {
            var url = new URL("http://127.0.0.1:4723/wd/hub");
            return new AndroidDriver(url, MobileCapabilities.getAndroidCapabilities());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}