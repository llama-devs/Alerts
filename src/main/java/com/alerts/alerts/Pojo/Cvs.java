package com.alerts.alerts.Pojo;

import java.util.Date;
import java.util.Objects;

public class Cvs {

  private String link;
  private String jobTitle;
  private Date timeScrapped;

  public Cvs() {}

  public Cvs(String link, String jobTitle, Date timeScrapped) {
    this.link = link;
    this.jobTitle = jobTitle;
    this.timeScrapped = timeScrapped;
  }

  public String getLink() {
    return this.link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getJobTitle() {
    return this.jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public Date getTimeScrapped() {
    return this.timeScrapped;
  }

  public void setTimeScrapped(Date timeScrapped) {
    this.timeScrapped = timeScrapped;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Cvs)) {
      return false;
    }
    Cvs cvs = (Cvs) o;
    return (
      Objects.equals(link, cvs.link) &&
      Objects.equals(jobTitle, cvs.jobTitle) &&
      Objects.equals(timeScrapped, cvs.timeScrapped)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(link, jobTitle, timeScrapped);
  }

  @Override
  public String toString() {
    return (
      "{" +
      " link='" +
      getLink() +
      "'" +
      ", jobTitle='" +
      getJobTitle() +
      "'" +
      ", timeScrapped='" +
      getTimeScrapped() +
      "'" +
      "}"
    );
  }
}
