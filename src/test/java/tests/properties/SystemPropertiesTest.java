package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    @Test
    @Tag("properties")
    void simplePropertyTes4() {
        String browserName = System.getProperty("browser_name", "firefox");
        String browserVersion = System.getProperty("browser_version", "101");
        String browserSize = System.getProperty("browser_size", "1920x1080");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);

        /*
        From IDEA
                firefox
                101
                1920x1080
        gradle clean properties_test
                firefox
                101
                1920x1080
        gradle clean properties_test -Dbrowser_name=safari
                safari
                101
                1920x1080
        gradle clean properties_test -Dbrowser_name=safari -Dbrowser_version=99.0 -Dbrowser_size=300x300
                safari
                99.0
                300x300
         */
    }
}
