package com.napier.devops;


public class Country {

  private String code;
  private String name;
  private String continent;
  private String region;
  private double surfaceArea;
  private long indepYear;
  private long population;
  private double lifeExpectancy;
  private double gnp;
  private double gnpOld;
  private String localName;
  private String governmentForm;
  private String headOfState;
  private long capital;
  private String code2;


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }


  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }


  public double getSurfaceArea() {
    return surfaceArea;
  }

  public void setSurfaceArea(double surfaceArea) {
    this.surfaceArea = surfaceArea;
  }


  public long getIndepYear() {
    return indepYear;
  }

  public void setIndepYear(long indepYear) {
    this.indepYear = indepYear;
  }


  public long getPopulation() {
    return population;
  }

  public void setPopulation(long population) {
    this.population = population;
  }


  public double getLifeExpectancy() {
    return lifeExpectancy;
  }

  public void setLifeExpectancy(double lifeExpectancy) {
    this.lifeExpectancy = lifeExpectancy;
  }


  public double getGnp() {
    return gnp;
  }

  public void setGnp(double gnp) {
    this.gnp = gnp;
  }


  public double getGnpOld() {
    return gnpOld;
  }

  public void setGnpOld(double gnpOld) {
    this.gnpOld = gnpOld;
  }


  public String getLocalName() {
    return localName;
  }

  public void setLocalName(String localName) {
    this.localName = localName;
  }


  public String getGovernmentForm() {
    return governmentForm;
  }

  public void setGovernmentForm(String governmentForm) {
    this.governmentForm = governmentForm;
  }


  public String getHeadOfState() {
    return headOfState;
  }

  public void setHeadOfState(String headOfState) {
    this.headOfState = headOfState;
  }


  public long getCapital() {
    return capital;
  }

  public void setCapital(long capital) {
    this.capital = capital;
  }


  public String getCode2() {
    return code2;
  }

  public void setCode2(String code2) {
    this.code2 = code2;
  }

  @Override
  public String toString() {
    return "Country{" + "code='" + code + '\'' + ", name='" + name + '\'' + ", continent='" + continent + '\''
            + ", region='" + region + '\'' + ", surfaceArea=" + surfaceArea + ", indepYear=" + indepYear
            + ", population=" + population + ", lifeExpectancy=" + lifeExpectancy + ", gnp=" + gnp + ", gnpOld="
            + gnpOld + ", localName='" + localName + '\'' + ", governmentForm='" + governmentForm + '\''
            + ", headOfState='" + headOfState + '\'' + ", capital=" + capital + ", code2='" + code2 + '\'' + '}';
  }
}
