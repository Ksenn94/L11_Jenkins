package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import helpers.Attach;

public class TestBase {
    public static final String LOGIN = "user1";
    public static final String PASSWORD = "1234";
    public static final String envURl = System.getProperty("env_url");
    public static final String browserName = System.getProperty("browser_name", "chrome");
    public static final String browserVersion = System.getProperty("browser_version");
    public static final String browserSize = System.getProperty("browser_size", "1920x1080");

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());


        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browser = browserName;
        Configuration.browserSize = browserSize;

        if (envURl == null || envURl.equals("")) {
            // запуск локально
        } else {
            // запуск удалённо
            Configuration.remote = "https://"+LOGIN+":"+PASSWORD+"@" + envURl;
        }

        if (browserVersion != null) {
            Configuration.browserVersion = browserVersion;
        }
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
