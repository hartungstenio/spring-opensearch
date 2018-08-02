package io.github.hartungstenio.spring.opensearch.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OpenSearchDescriptionDocumentBuilder {
    
    private String shortName;
    private String description;
    private List<OpenSearchUrl> url = new ArrayList<>();
    private String contact;
    private List<String> tags = new ArrayList<>();
    private String longName;
    private List<OpenSearchImage> image;
    // TODO query
    private String developer;
    private String attribution;
    private SyndicationRights syndicationRight;
    private Boolean adultContent;
    private List<String> language = new ArrayList<>();
    private List<String> inputEncoding = new ArrayList<>();
    private List<String> outputEncoding = new ArrayList<>();
    
    public OpenSearchDescriptionDocumentBuilder(final String shortName, final String description) {
        this.shortName = shortName;
        this.description = description;
    }
    
    public OpenSearchDescriptionDocumentBuilder setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setUrl(Collection<OpenSearchUrl> url) {
        this.url.clear();
        this.url.addAll(url);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder withUrl(OpenSearchUrl url) {
        this.url.add(url);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder withUrl(String template, String type) {
        return withUrl(new OpenSearchUrl(template, type));
    }
    
    public OpenSearchDescriptionDocumentBuilder withUrl(String template, String type, String rel) {
        return withUrl(new OpenSearchUrl(template, type, rel));
    }
    
    public OpenSearchDescriptionDocumentBuilder withUrl(String template, String type, String rel, Integer indexOffset, Integer pageOffset) {
        return withUrl(new OpenSearchUrl(template, type, rel, indexOffset, pageOffset));
    }
    
    public OpenSearchDescriptionDocumentBuilder setContact(String contact) {
        this.contact = contact;
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setTags(Collection<String> tags) {
        this.tags.clear();
        this.tags.addAll(tags);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setTags(String... tags) {
        return setTags(Arrays.asList(tags));
    }
    
    public OpenSearchDescriptionDocumentBuilder withTag(String tag) {
        this.tags.add(tag);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder withTags(String... tags) {
        this.tags.addAll(Arrays.asList(tags));
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setLongName(String longName) {
        this.longName = longName;
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setImage(Collection<OpenSearchImage> image) {
        this.image.clear();
        this.image.addAll(image);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder withImage(OpenSearchImage image) {
        this.image.add(image);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder withImage(String url) {
        return withImage(new OpenSearchImage(url));
    }
    
    public OpenSearchDescriptionDocumentBuilder withImage(Integer height, Integer width, String type, String url) {
        return withImage(new OpenSearchImage(height, width, type, url));
    }
    
    public OpenSearchDescriptionDocumentBuilder setDeveloper(String developer) {
        this.developer = developer;
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setAttribution(String attribution) {
        this.attribution = attribution;
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setSyndicationRight(SyndicationRights syndicationRight) {
        this.syndicationRight = syndicationRight;
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setAdultContent(Boolean adultContent) {
        this.adultContent = adultContent;
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setLanguage(Collection<String> language) {
        this.language.clear();
        this.language.addAll(language);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder withLanguage(String language) {
        this.language.add(language);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setInputEncoding(Collection<String> inputEncoding) {
        this.inputEncoding.clear();
        this.inputEncoding.addAll(inputEncoding);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder withInputEncoding(String inputEncoding) {
        this.inputEncoding.add(inputEncoding);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder setOutputEncoding(Collection<String> outputEncoding) {
        this.outputEncoding.clear();
        this.outputEncoding.addAll(outputEncoding);
        return this;
    }
    
    public OpenSearchDescriptionDocumentBuilder withOutputEncoding(String outputEncoding) {
        this.outputEncoding.add(outputEncoding);
        return this;
    }
    
    public OpenSearchDescription build() {
        String tagsStr = this.tags.stream().collect(Collectors.joining(" "));
        
        return new OpenSearchDescription(shortName, description, url, contact, tagsStr, longName, image, developer,
                attribution, syndicationRight, adultContent, language, inputEncoding, outputEncoding);
    }
}
