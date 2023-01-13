package com.example.restservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Cutoff {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String iso;

  private String country;

  /*
   * YYYY-MM-DD represents the day (today, tomorrow, ...)
   * HH:MM represents the cutoff time
   * 00:00:00 represents 'Never possible'
   * 23:59:59 represents 'Always possible'
   */
  private Date date;

  public Cutoff() {}
  public Cutoff(String iso, String country, Date date) {
    this.iso = iso;
    this.country = country;
    this.date = date;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getIso() {
    return iso;
  }

  public void setIso(String iso) {
    this.iso = iso;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;;
  }

  public boolean isNeverPossible() {
    return this.date.getHours() == 0 && this.date.getMinutes() == 0 && this.date.getSeconds() == 0;
  }

  public boolean isAlwaysPossible() {
    return this.date.getHours() == 23 && this.date.getMinutes() == 59 && this.date.getSeconds() == 59;
  }
}