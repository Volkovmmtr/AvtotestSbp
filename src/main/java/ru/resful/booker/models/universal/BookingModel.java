package ru.resful.booker.models.universal;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;

@Accessors(chain = true)
@Setter
@Getter
@XmlRootElement(name = "booking")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingModel {

    //по умолчанию имя в json должно быть = имени переменной
    private String firstname;

    private String lastname;

    private Integer totalprice;

    private Boolean depositpaid;

    private String additionalneeds;

    private Bookingdates bookingdates;


    //если желательно переименовать
    //bookingid - имя в json
    //@SerializedName("bookingid")

    @Getter
    @Setter
    @XmlRootElement(name = "bookingdates")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Bookingdates{
        private String checkin;
        private String checkout;
    }

}
