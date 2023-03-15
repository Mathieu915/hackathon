package model;

import lombok.Data;

import java.util.Date;

@Data
public class Weather {

    private long idWeather;
    private String phenomenaType;
    private String city;
    private Date date;

}
