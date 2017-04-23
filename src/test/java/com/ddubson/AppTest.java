package com.ddubson;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest extends FluentTest {
    @LocalServerPort
    int serverPort;

    @Override
    public String getBaseUrl() {
        return "http://localhost:"+serverPort;
    }

    @Page
    HomePage homePage;

    @Override
    public WebDriver newWebDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "node_modules/phantomjs-prebuilt/bin/phantomjs");
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] { "--webdriver-loglevel=WARN", "--webdriver-logfile=logs/phantomjs.log" });
        PhantomJSDriverService service = PhantomJSDriverService.createDefaultService(capabilities);
        return new PhantomJSDriver(service, capabilities);
    }

    @Test
    public void testHomePage() {
        homePage.go();
        assertTrue(homePage.find("html").present());
    }
}
