package ru.resful.booker.models.universal;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.resful.booker.xmlAdaptors.MapAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;
import java.util.Map;

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

    @XmlJavaTypeAdapter(value = MapAdapter.class)
    private Map<String, String> bookingdates = new HashMap<String, String>();


    //если желательно переименовать
    //bookingid - имя в json
    //@SerializedName("bookingid")


}
