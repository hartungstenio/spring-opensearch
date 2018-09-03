package io.github.hartungstenio.spring.opensearch.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public final class OpenSearchImage {
    
    private final String url;
    private final Integer height;
    private final Integer width;
    private final String type;
    
    private OpenSearchImage(Builder builder) {
        this.url = builder.url;
        this.height = builder.height;
        this.width = builder.width;
        this.type = builder.type;
    }
    
    private OpenSearchImage() {
        // Workaround for JAXB
        this(new Builder(null));
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
    
    public static final class Builder {
        private final String url;
        
        private Integer height;
        private Integer width;
        private String type;
        
        public Builder(final String url) {
            this.url = url;
        }
        
        public Builder height(Integer height) {
            this.height = height;
            return this;
        }
        
        public Builder width(Integer width) {
            this.width = width;
            return this;
        }
        
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        
        public OpenSearchImage build() {
            return new OpenSearchImage(this);
        }
    }
}
