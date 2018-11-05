package com.github.ankurpathak;


import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "object")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapObject {

    @XmlPath(".")
    @XmlJavaTypeAdapter(MapAdapter.class)
    private Map<String, Object> map = new HashMap<>();
    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
