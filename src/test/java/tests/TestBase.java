package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeALL() {
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
//        Configuration.timeout = Long.parseLong("5000"); // default 4000
        Configuration.timeout = 10000;
    }
}
