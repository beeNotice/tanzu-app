package com.tanzu.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Config {

  @Id
  private String name;

  private String val;

  public String getName() {
    return name;
  }

  public String getVal() {
    return val;
  }

}
