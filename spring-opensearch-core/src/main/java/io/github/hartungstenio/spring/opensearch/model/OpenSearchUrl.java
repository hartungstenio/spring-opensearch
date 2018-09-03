package io.github.hartungstenio.spring.opensearch.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class OpenSearchUrl {
    
    public static final String RESULTS = "results";
    public static final String SUGGESTIONS = "suggestions";
    public static final String SELF = "self";
    public static final String COLLECTION = "collection";
    
    private final String template;
    private final String type;
    private final String rel;
    private final Integer indexOffset;
    private final Integer pageOffset;
    
    private OpenSearchUrl(Builder builder) {
        this.template = builder.template;
        this.type = builder.type;
        this.rel = builder.rel;
        this.indexOffset = builder.indexOffset;
        this.pageOffset = builder.pageOffset;
    }
    
    private OpenSearchUrl() {
        // Workaround for JAXB
        this(new Builder(null, null));
    }
    
    @XmlAttribute(name = "template", required = true)
    public String getTemplate() {
        return this.template;
    }
    
    @XmlAttribute(name = "type", required = true)
    public String getType() {
        return this.type;
    }
    
    @XmlAttribute(name = "rel")
    public String getRel() {
        return this.rel;
    }
    
    @XmlAttribute(name = "indexOffset")
    public Integer getIndexOffset() {
        return this.indexOffset;
    }
    
    @XmlAttribute(name = "pageOffset")
    public Integer getPageOffset() {
        return this.pageOffset;
    }
    
    public static final class Builder {
        private final String template;
        private final String type;
        
        private String rel;
        private Integer indexOffset;
        private Integer pageOffset;
        
        public Builder(final String template, final String type) {
            this.template = template;
            this.type = type;
        }
        
        public Builder rel(final String rel) {
            this.rel = rel;
            return this;
        }
        
        public Builder indexOffset(final Integer indexOffset) {
            this.indexOffset = indexOffset;
            return this;
        }
        
        public Builder pageOffset(final Integer pageOffset) {
            this.pageOffset = pageOffset;
            return this;
        }
        
        public OpenSearchUrl build() {
            return new OpenSearchUrl(this);
        }
    }
}
