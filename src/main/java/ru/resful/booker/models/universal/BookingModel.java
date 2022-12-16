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
    @XmlElement
    private String firstname;

    @XmlElement
    private String lastname;

    @XmlElement
    private Integer totalprice;

    @XmlElement
    private Boolean depositpaid;

    @XmlElement
    private String additionalneeds;

    @XmlElement
    private Bookingdates bookingdates;


    //если желательно переименовать
    //bookingid - имя в json
    //@SerializedName("bookingid")
    @XmlElement
    private String bookingid;


    @Getter
    @Setter
    @XmlRootElement(name = "bookingdates")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Bookingdates{
        private String checkin;
        private String checkout;
    }

}
