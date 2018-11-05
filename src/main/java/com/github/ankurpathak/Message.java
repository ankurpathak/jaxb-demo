package com.github.ankurpathak;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement
public class Message {
    private String value;



    public Message(String value) {
        this.value = value;
    }

    protected Message() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @XmlRootElement
    public static class Messages{


        private List<Message> messages;

        @XmlElement(name = "message")
        public List<Message> getMessages() {
            return messages;
        }

        public void setMessages(List<Message> messages) {
            this.messages = messages;
        }

        public Messages(List<Message> messages) {
            this.messages = messages;
        }

        protected Messages() {
        }
    }
}
