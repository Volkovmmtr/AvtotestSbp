package ru.resful.booker.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

@Accessors(chain = true)
@Setter
@Getter
public class BookingModel {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private String additionalneeds;
    private Map<String,String> bookingdates;
    private String id;

}
