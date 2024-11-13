package com.alerts.alerts.service;

import com.alerts.alerts.Utility.PageContext;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// potentially use @lazy so that spring boot does not instatiate the class when its not needed
@Service
public class ScrapperService {

  private final Browser browser;

  // Inject the playwright browser bean from the config file
  @Autowired
  public ScrapperService(Browser browser) {
    this.browser = browser;
  }

  public PageContext getNewPage(String url) {
    // Create a new isolated BrowserContext
    BrowserContext context = browser.newContext();
    Page page = context.newPage();
    page.navigate(url);

    return new PageContext(context, page);
  }

  public PageContext getNewPage(String url, List<String> exclusions) {
    BrowserContext context = browser.newContext();
    Page page = context.newPage();

    // call adblocks here
    this.adBlock(exclusions, page);
    page.navigate(url);
    return new PageContext(context, page);
  }

  // this function takes in a list of host and we watch the pages network request to block certain http request that contain certain substrings within the host url of the request. If there is a match then we abourt the api call
  private void adBlock(List<String> exclusions, Page page) {
    page.route("**/*", route -> {
      if (
        exclusions
          .stream()
          .anyMatch(substr ->
            route.request().headers().get("host").contains(substr)
          )
      ) {
        route.resume();
        return;
      }
      if (route.request().resourceType().equals("image")) {
        route.abort();
        return;
      }
      route.abort();
      return;
    });
  }
}
