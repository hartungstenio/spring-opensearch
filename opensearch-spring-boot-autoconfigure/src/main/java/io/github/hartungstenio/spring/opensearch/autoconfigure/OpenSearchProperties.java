package io.github.hartungstenio.spring.opensearch.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import io.github.hartungstenio.spring.opensearch.model.SyndicationRights;

@ConfigurationProperties(prefix = "opensearch")
public class OpenSearchProperties {
    
    private String shortName;
    private String description;
    private String contact;
    private String tags;
    private String longName;
    private String developer;
    private String attribution;
    private SyndicationRights syndicationRight;
    private boolean adultContent;
    private String[] language = {};
    private String[] inputEncoding = {};
    private String[] outputEncoding = {};
    
    public String getShortName() {
        return this.shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getContact() {
        return this.contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getTags() {
        return this.tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getLongName() {
        return this.longName;
    }
    public void setLongName(String longName) {
        this.longName = longName;
    }
    public String getDeveloper() {
        return this.developer;
    }
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    public String getAttribution() {
        return this.attribution;
    }
    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }
    public SyndicationRights getSyndicationRight() {
        return this.syndicationRight;
    }
    public void setSyndicationRight(SyndicationRights syndicationRight) {
        this.syndicationRight = syndicationRight;
    }
    public boolean isAdultContent() {
        return this.adultContent;
    }
    public void setAdultContent(boolean adultContent) {
        this.adultContent = adultContent;
    }
    public String[] getLanguage() {
        return this.language;
    }
    public void setLanguage(String[] language) {
        this.language = language;
    }
    public String[] getInputEncoding() {
        return this.inputEncoding;
    }
    public void setInputEncoding(String[] inputEncoding) {
        this.inputEncoding = inputEncoding;
    }
    public String[] getOutputEncoding() {
        return this.outputEncoding;
    }
    public void setOutputEncoding(String[] outputEncoding) {
        this.outputEncoding = outputEncoding;
    }
    
}
