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
public class JsonGaodeBean {

    private String status;
    private String info;
    private String infocode;
    private String count;
    private List<Geocodes> geocodes;
    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setInfo(String info) {
         this.info = info;
     }
     public String getInfo() {
         return info;
     }

    public void setInfocode(String infocode) {
         this.infocode = infocode;
     }
     public String getInfocode() {
         return infocode;
     }

    public void setCount(String count) {
         this.count = count;
     }
     public String getCount() {
         return count;
     }

    public void setGeocodes(List<Geocodes> geocodes) {
         this.geocodes = geocodes;
     }
     public List<Geocodes> getGeocodes() {
         return geocodes;
     }

}