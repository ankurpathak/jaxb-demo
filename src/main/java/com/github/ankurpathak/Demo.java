package com.github.ankurpathak;

import java.io.File;
import java.util.Map;
import javax.xml.bind.*;

import org.eclipse.persistence.internal.oxm.Root;
import org.eclipse.persistence.jaxb.MarshallerProperties;

public class Demo {

    public static void main(String[] args) throws Exception {


        JAXBContext jc = JAXBContext.newInstance(MapObject.class);
        System.out.println(jc.getClass());

        MapObject root = new MapObject();
        root.setMap(Map.of("a", 1, "b", 2));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/xml");
        marshaller.marshal(root, System.out);
    }

}

/*

ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        File xml = new File(classLoader.getResource("input.xml").getFile());

        System.out.println("File Found : " + xml.exists());
 */