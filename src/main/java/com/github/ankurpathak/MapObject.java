package com.github.ankurpathak;


import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class MapObject {


    private Map<String, Integer> map = new HashMap<String, Integer>();


    @XmlPath(".")
    @XmlJavaTypeAdapter(MapAdapter.class)
    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
