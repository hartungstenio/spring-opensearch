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
    
    public OpenSearchImage(final String url) {
        this(null, null, null, url);
    }
    
    public OpenSearchImage(final String url, final Integer height, final Integer width, final String type) {
        this.url = url;
        this.height = height;
        this.width = width;
        this.type = type;
    }
    
    @SuppressWarnings("unused")
    private OpenSearchImage() {
        // Workaround for JAXB
        this(null);
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
        
        private final OpenSearchDescription.Builder openSearchDescription;
        
        public Builder(final String url, final OpenSearchDescription.Builder openSearchDescription) {
            this.url = url;
            this.openSearchDescription = openSearchDescription;
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
            return new OpenSearchImage(url, height, width, type);
        }
        
        public OpenSearchDescription.Builder and() {
            return openSearchDescription;
        }
    }
}
