package ru.resful.booker.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

@Accessors(chain = true)
@Setter
@Getter
public class BookingModel {

    //по умолчанию имя в json должно быть = имени переменной
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private String additionalneeds;
    private Map<String,String> bookingdates;

    //если желательно переименовать
    //bookingid - имя в json
    @SerializedName("bookingid")
    private String id;

}
