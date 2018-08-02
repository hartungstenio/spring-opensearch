package io.github.hartungstenio.spring.opensearch.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OpenSearchUrl {
    
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
    
    public OpenSearchUrl(final String template, final String type, final String rel, final Integer indexOffset, final Integer pageOffset) {
        this.template = template;
        this.type = type;
        this.rel = rel;
        this.indexOffset = indexOffset;
        this.pageOffset = pageOffset;
    }

    @XmlElement(name = "template", required = true)
    public String getTemplate() {
        return this.template;
    }
    
    @XmlElement(name = "type", required = true)
    public String getType() {
        return this.type;
    }
    
    @XmlElement(name = "rel")
    public String getRel() {
        return this.rel;
    }
    
    @XmlElement(name = "indexOffset")
    public Integer getIndexOffset() {
        return this.indexOffset;
    }
    
    @XmlElement(name = "pageOffset")
    public Integer getPageOffset() {
        return this.pageOffset;
    }
}
