package ru.resful.booker.modelGenerators;

import org.apache.commons.lang3.RandomStringUtils;
import ru.resful.booker.models.BookingModel;
import ru.resful.booker.utils.DateGenerator;

import java.util.HashMap;
import java.util.Random;

public class BookingGenerator {

    public static BookingModel getNewBook(){
        return new BookingModel()
                .setFirstname(RandomStringUtils.random(14,true,false))
                .setLastname(RandomStringUtils.random(14,true,false))
                .setTotalprice(new Random().nextInt())
                .setDepositpaid(true)
                .setBookingdates(
                        new HashMap<String, String>() {{
                            put("checkin", DateGenerator.getDate());
                            put("checkout", DateGenerator.getDateWithShift(14));
                        }}
                )
                .setAdditionalneeds(RandomStringUtils.random(14,true,false));
    }
}
