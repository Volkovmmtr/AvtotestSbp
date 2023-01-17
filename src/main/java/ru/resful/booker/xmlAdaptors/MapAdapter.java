package ru.resful.booker.xmlAdaptors;

import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.HashMap;

//https://stackoverflow.com/questions/3941479/jaxb-how-to-marshall-map-into-keyvalue-key/32483762#32483762?newreg=2ffd994d771148a7850b278bb43618e4

public class MapAdapter extends XmlAdapter<MapWrapper, Map<String, Object>> {
    @Override
    public MapWrapper marshal(Map<String, Object> m) throws Exception {
        MapWrapper wrapper = new MapWrapper();
        List elements = new ArrayList();
        for (Map.Entry<String, Object> property : m.entrySet()) {

            if (property.getValue() instanceof Map)
                elements.add(new JAXBElement<MapWrapper>(new QName(getCleanLabel(property.getKey())),
                        MapWrapper.class, marshal((Map) property.getValue())));
            else
                elements.add(new JAXBElement<String>(new QName(getCleanLabel(property.getKey())),
                        String.class, property.getValue().toString()));
        }
        wrapper.elements = elements;
        return wrapper;
    }

    @Override
    public Map<String, Object> unmarshal(MapWrapper v) throws Exception {
        HashMap<String, Object> returnval = new HashMap();
        for (Object o : v.elements) {
            Element e = (Element) o;
            if (e.getChildNodes().getLength() > 1) {
                MapWrapper mw = new MapWrapper();
                mw.elements = new ArrayList();
                for (int count = 0; count < e.getChildNodes().getLength(); count++) {
                    if (e.getChildNodes().item(count) instanceof Element) {
                        mw.elements.add(e.getChildNodes().item(count));
                    }
                }
                returnval.put(e.getTagName(), unmarshal(mw));
            } else {
                returnval.put(e.getTagName(), e.getTextContent());
            }
        }
        return returnval;
    }


    // Return a XML-safe attribute.  Might want to add camel case support
    private String getCleanLabel(String attributeLabel) {
        attributeLabel = attributeLabel.replaceAll("[()]", "").replaceAll("[^\\w\\s]", "_").replaceAll(" ", "_");
        return attributeLabel;
    }
}
class MapWrapper {
    @XmlAnyElement
    List elements;
}