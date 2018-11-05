package com.github.ankurpathak;


import java.util.*;
import java.util.Map.Entry;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.eclipse.persistence.oxm.annotations.XmlVariableNode;


public class MapAdapter extends XmlAdapter<MapAdapter.AdaptedMap, Map<String, Integer>> {


    @Override
    public AdaptedMap marshal(Map<String, Integer> map) throws Exception {
        AdaptedMap adaptedMap = new AdaptedMap();
        for (Entry<String, Integer> entry : map.entrySet()) {
            AdaptedEntry adaptedEntry = new AdaptedEntry();
            adaptedEntry.key = entry.getKey();
            adaptedEntry.value = entry.getValue();
            adaptedMap.entries.add(adaptedEntry);
        }
        return adaptedMap;
    }

    @Override


    public Map<String, Integer> unmarshal(AdaptedMap adaptedMap) throws Exception {
        List<AdaptedEntry> adaptedEntries = adaptedMap.entries;
        Map<String, Integer> map = new HashMap<String, Integer>(adaptedEntries.size());
        for (AdaptedEntry adaptedEntry : adaptedEntries) {
            map.put(adaptedEntry.key, adaptedEntry.value);
        }
        return map;
    }

    public static class AdaptedMap {


        private List<AdaptedEntry> entries = new ArrayList<>();

        @XmlVariableNode("key")
        public List<AdaptedEntry> getEntries() {
            return entries;
        }

        public void setEntries(List<AdaptedEntry> entries) {
            this.entries = entries;
        }
    }

    public static class AdaptedEntry {



        private String key;



        private  Integer value;

        @XmlTransient
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @XmlValue
        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

}