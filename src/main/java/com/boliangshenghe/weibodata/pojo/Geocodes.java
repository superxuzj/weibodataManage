/**
  * Copyright 2017 bejson.com 
  */
package com.boliangshenghe.weibodata.pojo;
import java.util.List;

/**
 * Auto-generated: 2017-10-15 19:32:53
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Geocodes {

    private String formatted_address;
    private String province;
    private String citycode;
    private String city;
    private String district;
    private List<String> township;
    private Neighborhood neighborhood;
    private Building building;
    private String adcode;
    private List<String> street;
    private List<String> number;
    private String location;
    private String level;
    public void setFormatted_address(String formatted_address) {
         this.formatted_address = formatted_address;
     }
     public String getFormatted_address() {
         return formatted_address;
     }

    public void setProvince(String province) {
         this.province = province;
     }
     public String getProvince() {
         return province;
     }

    public void setCitycode(String citycode) {
         this.citycode = citycode;
     }
     public String getCitycode() {
         return citycode;
     }

    public void setCity(String city) {
         this.city = city;
     }
     public String getCity() {
         return city;
     }

    public void setDistrict(String district) {
         this.district = district;
     }
     public String getDistrict() {
         return district;
     }

    public void setTownship(List<String> township) {
         this.township = township;
     }
     public List<String> getTownship() {
         return township;
     }

    public void setNeighborhood(Neighborhood neighborhood) {
         this.neighborhood = neighborhood;
     }
     public Neighborhood getNeighborhood() {
         return neighborhood;
     }

    public void setBuilding(Building building) {
         this.building = building;
     }
     public Building getBuilding() {
         return building;
     }

    public void setAdcode(String adcode) {
         this.adcode = adcode;
     }
     public String getAdcode() {
         return adcode;
     }

    public void setStreet(List<String> street) {
         this.street = street;
     }
     public List<String> getStreet() {
         return street;
     }

    public void setNumber(List<String> number) {
         this.number = number;
     }
     public List<String> getNumber() {
         return number;
     }

    public void setLocation(String location) {
         this.location = location;
     }
     public String getLocation() {
         return location;
     }

    public void setLevel(String level) {
         this.level = level;
     }
     public String getLevel() {
         return level;
     }

}