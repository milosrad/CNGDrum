package cubes.cngdrum.data.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by markodragonjic on 6/27/16.
 */
public class DataItem implements Serializable{

    public String id;
    public String title;
    public String address;
    public String phoneNumber;
    public String image;
    public String accessTime;
    public String longitude;
    public String latitude;
    public String distance;
    public String features;
    public String region;
    public String web;
    public String city;
    public ArrayList<String> tags;
    public boolean isPay;

    public ArrayList<String> galerryimages;

    public String getTags(){
        return tags.toString();
    }
}
