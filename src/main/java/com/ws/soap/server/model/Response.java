package com.ws.soap.server.model;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@Getter
@Setter
public class Response {
    @XmlElement(name = "code")
    private String code;
    @XmlElement(name = "message")
    private String message;
    @XmlElement(name = "sessionId")
    private String sessionId;
}
