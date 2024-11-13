package com.alerts.alerts.configuration;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaywrightConfig {

  // Reads value from application properties
  @Value("${playwright.browser.headless:true}")
  private boolean headless;

  @Bean
  // Creates an instance of playwright managed by spring lifecycle
  public Playwright playwright() {
    return Playwright.create();
  }

  @Bean
  public Browser browser(Playwright playwright) {
    // Launch a single browser instance that will be shared across sessions and uses the managed playwright instance that was created above
    return playwright
      .firefox()
      .launch(new BrowserType.LaunchOptions().setHeadless(headless));
  }
}
