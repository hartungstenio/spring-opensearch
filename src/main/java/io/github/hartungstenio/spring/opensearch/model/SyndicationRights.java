package io.github.hartungstenio.spring.opensearch.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum SyndicationRights {
    @XmlEnumValue("open")
    OPEN,
    
    @XmlEnumValue("limited")
    LIMITED,
    
    @XmlEnumValue("private")
    PRIVATE,
    
    @XmlEnumValue("closed")
    CLOSED
}
