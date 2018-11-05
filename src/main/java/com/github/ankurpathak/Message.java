package com.github.ankurpathak;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Messages{

        @XmlElement(name = "message")
        private List<Message> messages;

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
