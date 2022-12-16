package ru.resful.booker.models.responce;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.resful.booker.models.universal.BookingModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Accessors(chain = true)
@Setter
@Getter
@XmlRootElement(name = "created-booking")
@XmlAccessorType(XmlAccessType.FIELD)
public class WrappedBookingModel {

    @XmlElement
    private String bookingid;

    @XmlElement
    private BookingModel booking;
}
