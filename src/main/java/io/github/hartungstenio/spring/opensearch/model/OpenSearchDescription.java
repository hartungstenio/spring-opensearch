package io.github.hartungstenio.spring.opensearch.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OpenSearchDescription", namespace="http://a9.com/-/spec/opensearch/1.1/")
public final class OpenSearchDescription {
    
    private final String shortName;
    private final String description;
    private final List<OpenSearchUrl> url;
    private final String contact;
    private final String tags;
    private final String longName;
    private final List<OpenSearchImage> image;
    // TODO query
    private final String developer;
    private final String attribution;
    private final SyndicationRights syndicationRight;
    private final Boolean adultContent;
    private final List<String> language;
    private final List<String> inputEncoding;
    private final List<String> outputEncoding;
    
    public OpenSearchDescription(final String shortName, final String description, final List<OpenSearchUrl> url,
            final String contact, final String tags, final String longName, final List<OpenSearchImage> image,
            final String developer, final String attribution, final SyndicationRights syndicationRight,
            final Boolean adultContent, final List<String> language, final List<String> inputEncoding,
            final List<String> outputEncoding) {
        this.shortName = shortName;
        this.description = description;
        this.url = url;
        this.contact = contact;
        this.tags = tags;
        this.longName = longName;
        this.image = image;
        this.developer = developer;
        this.attribution = attribution;
        this.syndicationRight = syndicationRight;
        this.adultContent = adultContent;
        this.language = language;
        this.inputEncoding = inputEncoding;
        this.outputEncoding = outputEncoding;
    }

    @XmlElement(name = "ShortName", required = true)
    public String getShortName() {
        return this.shortName;
    }
    
    @XmlElement(name = "Description", required = true)
    public String getDescription() {
        return this.description;
    }
    
    @XmlElement(name = "Url", required = true)
    public List<OpenSearchUrl> getUrl() {
        return this.url;
    }
    
    @XmlElement(name = "Contact")
    public String getContact() {
        return this.contact;
    }
    
    @XmlElement(name = "Tags")
    public String getTags() {
        return this.tags;
    }
    
    @XmlElement(name = "LongName")
    public String getLongName() {
        return this.longName;
    }
    
    @XmlElement(name = "Image")
    public List<OpenSearchImage> getImage() {
        return this.image;
    }
    
    @XmlElement(name = "Developer")
    public String getDeveloper() {
        return this.developer;
    }
    
    @XmlElement(name = "Attribution")
    public String getAttribution() {
        return this.attribution;
    }
    
    @XmlElement(name = "SyndicationRight")
    public SyndicationRights getSyndicationRight() {
        return this.syndicationRight;
    }
    
    @XmlElement(name = "AdultContent")
    public Boolean getAdultContent() {
        return this.adultContent;
    }
    
    @XmlElement(name = "Language")
    public List<String> getLanguage() {
        return this.language;
    }
    
    @XmlElement(name = "InputEncoding")
    public List<String> getInputEncoding() {
        return this.inputEncoding;
    }
    
    @XmlElement(name = "OutputEncoding")
    public List<String> getOutputEncoding() {
        return this.outputEncoding;
    }
}