package com.github.ankurpathak;

import com.github.ankurpathak.c.Customer;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        System.out.println(jc.getClass());

        Customer customer = new Customer();
        customer.setFirstName("Ankur");
        customer.setLastName("Pathak");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/xml");
        marshaller.marshal(customer, System.out);
    }

}

//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();


//    File xml = new File(classLoader.getResource("input.xml").getFile());

//        System.out.println("File Found : " + xml.exists());