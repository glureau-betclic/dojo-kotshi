package com.glureau.kotshidemo.dto;

import java.util.List;

public class BreweryJava {
    int id;
    String name;
    String brewery_type;
    String street;
    String city;
    String state;
    String postal_code;
    String country;
    String longitude;
    String latitude;
    String phone;
    String website_url;
    String updated_at;
    List<String> tag_list;

    @Override
    public String toString() {
        return "BreweryJava{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brewery_type='" + brewery_type + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", phone='" + phone + '\'' +
                ", website_url='" + website_url + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", tag_list=" + tag_list +
                '}';
    }
}
