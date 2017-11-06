package com.ddubson.acceptance;

import com.ddubson.App;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.fluentlenium.core.filter.FilterConstructor.withText;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.phantomjs.PhantomJSDriverService.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationAcceptanceTest extends FluentTest {
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
        capabilities.setCapability(PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "node_modules/phantomjs-prebuilt/bin/phantomjs");
        capabilities.setPlatform(Platform.ANY);
        capabilities.setCapability(PHANTOMJS_CLI_ARGS,
                new String[] { "--webdriver-loglevel=WARN",
                        "--webdriver-logfile=logs/phantomjs.log" });
        PhantomJSDriverService service = createDefaultService(capabilities);
        return new PhantomJSDriver(service, capabilities);
    }

    @Test
    public void homePageShouldDisplayHelloWorld() {
        homePage.go();
        assertTrue(homePage.find("div[data-test='welcome']", withText().contains("Hello World")).present());
    }
}
