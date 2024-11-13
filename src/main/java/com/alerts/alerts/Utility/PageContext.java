package com.alerts.alerts.Utility;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

// Implements the interface autoclose so that a close function is implemented
//  This close function will be used within the try-with-resources to automatically close the browser
public class PageContext implements AutoCloseable {

  private final BrowserContext context;
  private final Page page;

  public PageContext(BrowserContext context, Page page) {
    this.context = context;
    this.page = page;
  }

  public Page getPage() {
    return page;
  }

  @Override
  public void close() {
    // Closes the BrowserContext, which also closes the Page
    context.close();
  }
}
