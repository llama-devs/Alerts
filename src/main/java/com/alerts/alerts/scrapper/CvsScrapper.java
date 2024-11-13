package com.alerts.alerts.scrapper;

import com.alerts.alerts.Pojo.Cvs;
import com.alerts.alerts.service.CvsService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CvsScrapper {

  private final CvsService cvsService;
  private final String Url =
    "https://jobs.cvshealth.com/us/en/search-results?keywords=";

  @Autowired
  public CvsScrapper(CvsService cvsService) {
    this.cvsService = cvsService;
  }

  public List<Cvs> getLatestJobs(String keyword) {
    return Arrays.asList(null);
  }
}
