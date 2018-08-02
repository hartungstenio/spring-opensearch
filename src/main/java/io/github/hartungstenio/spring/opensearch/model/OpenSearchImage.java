package io.github.hartungstenio.spring.opensearch.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class OpenSearchImage {
    
    private final Integer height;
    private final Integer width;
    private final String type;
    private final String url;
    
    public OpenSearchImage(final String url) {
        this(null, null, null, url);
    }
    
    public OpenSearchImage(final Integer height, final Integer width, final String type, final String url) {
        this.height = height;
        this.width = width;
        this.type = type;
        this.url = url;
    }

    @XmlAttribute(name = "height")
    public Integer getHeight() {
        return this.height;
    }
    
    @XmlAttribute(name = "width")
    public Integer getWidth() {
        return this.width;
    }
    
    @XmlAttribute(name = "type")
    public String getType() {
        return this.type;
    }
    
    @XmlValue
    public String getUrl() {
        return this.url;
    }
}
