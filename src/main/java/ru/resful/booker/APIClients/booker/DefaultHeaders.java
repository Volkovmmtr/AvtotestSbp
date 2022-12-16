package ru.resful.booker.APIClients.booker;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public class DefaultHeaders {

    public static final Map<String,String> JSON_HEADER = new HashMap<String,String>(){{
        put("Accept","application/json");
        put("Content-Type","application/json");
    }};

    public static final Map<String,String> XML_HEADER = new HashMap<String,String>(){{
        put("Accept","application/xml");
        put("Content-Type","text/xml");
    }};
}
