package ru.resful.booker.xmlAdaptors;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

class MapElements
{
    @XmlElement
    public String  key;
    @XmlElement public String value;

    private MapElements() {} //Required by JAXB

    public MapElements(String key, String value)
    {
        this.key   = key;
        this.value = value;
    }
}