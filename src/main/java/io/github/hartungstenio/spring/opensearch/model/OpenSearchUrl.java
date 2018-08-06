package io.github.hartungstenio.spring.opensearch.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class OpenSearchUrl {
    
    private final String template;
    private final String type;
    private final String rel;
    private final Integer indexOffset;
    private final Integer pageOffset;
    
    public OpenSearchUrl(final String template, final String type) {
        this(template, type, null);
    }
    
    public OpenSearchUrl(final String template, final String type, final String rel) {
        this(template, type, rel, null, null);
    }
    
    @SuppressWarnings("unused")
    private OpenSearchUrl() {
        // Workaround for JAXB
        this(null, null);
    }
    
    public OpenSearchUrl(final String template, final String type, final String rel, final Integer indexOffset, final Integer pageOffset) {
        this.template = template;
        this.type = type;
        this.rel = rel;
        this.indexOffset = indexOffset;
        this.pageOffset = pageOffset;
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
        
        private final OpenSearchDescription.Builder openSearchDescription;
        
        public Builder(final String template, final String type, final OpenSearchDescription.Builder openSearchDescription) {
            this.template = template;
            this.type = type;
            this.openSearchDescription = openSearchDescription;
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
            return new OpenSearchUrl(template, type, rel, indexOffset, pageOffset);
        }
        
        public OpenSearchDescription.Builder and() {
            return openSearchDescription;
        }
    }
}
