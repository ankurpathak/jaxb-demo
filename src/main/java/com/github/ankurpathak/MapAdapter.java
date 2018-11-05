package com.github.ankurpathak;


import java.util.*;
import java.util.Map.Entry;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.eclipse.persistence.oxm.annotations.XmlVariableNode;


public class MapAdapter extends XmlAdapter<MapAdapter.AdaptedMap, Map<String, Object>> {


    @Override
    public AdaptedMap marshal(Map<String, Object> map) throws Exception {
        AdaptedMap adaptedMap = new AdaptedMap();
        for (Entry<String, Object> entry : map.entrySet()) {
            AdaptedEntry adaptedEntry = new AdaptedEntry();
            adaptedEntry.key = entry.getKey();
            adaptedEntry.value = entry.getValue();
            adaptedMap.entries.add(adaptedEntry);
        }
        return adaptedMap;
    }

    @Override


    public Map<String, Object> unmarshal(AdaptedMap adaptedMap) throws Exception {
        List<AdaptedEntry> adaptedEntries = adaptedMap.entries;
        Map<String, Object> map = new HashMap<>(adaptedEntries.size());
        for (AdaptedEntry adaptedEntry : adaptedEntries) {
            map.put(adaptedEntry.key, adaptedEntry.value);
        }
        return map;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class AdaptedMap {

        @XmlVariableNode("key")
        private List<AdaptedEntry> entries = new ArrayList<>();


        public List<AdaptedEntry> getEntries() {
            return entries;
        }

        public void setEntries(List<AdaptedEntry> entries) {
            this.entries = entries;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class AdaptedEntry {
        @XmlTransient
        private String key;
        @XmlValue
        private  Object value;


        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

}