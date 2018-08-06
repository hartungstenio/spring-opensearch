package io.github.hartungstenio.spring.opensearch.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OpenSearchDescription")
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
    
    public OpenSearchDescription(final String shortName, final String description, final OpenSearchUrl... url) {
        this(shortName, description, Arrays.asList(url), null, null, null, null, null, null, null, null, null, null, null);
    }
    
    public OpenSearchDescription(final String shortName, final String description, final List<OpenSearchUrl> url) {
        this(shortName, description, url, null, null, null, null, null, null, null, null, null, null, null);
    }
    
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
    
    @SuppressWarnings("unused")
    private OpenSearchDescription() {
        // Workaround for JAXB
        this(null, null, null, null);
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
    
    public static final class Builder {
        
        private String shortName;
        private String description;
        private List<OpenSearchUrl.Builder> urls = new ArrayList<>();
        private String contact;
        private StringJoiner tags = new StringJoiner(" ");
        private String longName;
        private List<OpenSearchImage.Builder> images = new ArrayList<>();
        // TODO query
        private String developer;
        private String attribution;
        private SyndicationRights syndicationRight;
        private Boolean adultContent;
        private List<String> language = new ArrayList<>();
        private List<String> inputEncodings = new ArrayList<>();
        private List<String> outputEncodings = new ArrayList<>();
        
        public Builder(final String shortName, final String description) {
            this.shortName = shortName;
            this.description = description;
        }
        
        public OpenSearchUrl.Builder url(final String template, final String type) {
            OpenSearchUrl.Builder urlBuilder = new OpenSearchUrl.Builder(template, type, this);
            this.urls.add(urlBuilder);
            return urlBuilder;
        }
        
        public Builder contact(String contact) {
            this.contact = clear(contact);
            return this;
        }
        
        public Builder tag(final String tag) {
            this.tags.add(tag);
            return this;
        }
        
        public Builder tags(Collection<String> tags) {
            for(String tag : tags) {
                tag(tag);
            }
            
            return this;
        }
        
        public Builder tags(String... tags) {
            return tags(Arrays.asList(tags));
        }
        
        public Builder longName(String longName) {
            this.longName = clear(longName);
            return this;
        }
        
        public OpenSearchImage.Builder url(final String url) {
            OpenSearchImage.Builder imageBuilder = new OpenSearchImage.Builder(url, this);
            this.images.add(imageBuilder);
            return imageBuilder;
        }
        
        public Builder developer(String developer) {
            this.developer = clear(developer);
            return this;
        }
        
        public Builder attribution(String attribution) {
            this.attribution = clear(attribution);
            return this;
        }
        
        public Builder syndicationRight(SyndicationRights syndicationRight) {
            this.syndicationRight = syndicationRight;
            return this;
        }
        
        public Builder adultContent(Boolean adultContent) {
            this.adultContent = adultContent;
            return this;
        }
        
        public Builder language(String language) {
            this.language.add(language);
            return this;
        }
        
        public Builder languages(Collection<String> languages) {
            for(String language : languages) {
                language(language);
            }
            
            return this;
        }
        
        public Builder languages(String... languages) {
            return languages(Arrays.asList(languages));
        }
        
        public Builder inputEncoding(String inputEncoding) {
            this.inputEncodings.add(inputEncoding);
            return this;
        }
        
        public Builder inputEncodings(Collection<String> inputEncodings) {
            for(String inputEncoding : inputEncodings) {
                inputEncoding(inputEncoding);
            }
            
            return this;
        }
        
        public Builder inputEncodings(String... inputEncodings) {
            return inputEncodings(Arrays.asList(inputEncodings));
        }
        
        public Builder outputEncoding(String outputEncoding) {
            this.outputEncodings.add(outputEncoding);
            return this;
        }
        
        public Builder outputEncodings(Collection<String> outputEncodings) {
            for(String outputEncoding : outputEncodings) {
                outputEncoding(outputEncoding);
            }
            
            return this;
        }
        
        public Builder outputEncodings(String... outputEncodings) {
            return outputEncodings(Arrays.asList(outputEncodings));
        }
        
        private String clear(final String value) {
            if("".equals(value)) return null;
            return value;
        }
        
        public OpenSearchDescription build() {
            // Build the objects
            List<OpenSearchUrl> urls = this.urls.stream()
                                            .map(OpenSearchUrl.Builder::build)
                                            .collect(Collectors.toList());
            
            List<OpenSearchImage> images = this.images.stream()
                                                .map(OpenSearchImage.Builder::build)
                                                .collect(Collectors.toList());
            
            String tags = clear(this.tags.toString());
            
            return new OpenSearchDescription(shortName, description, urls, contact, tags, longName, images, developer,
                    attribution, syndicationRight, adultContent, language, inputEncodings, outputEncodings);
        }
    }
}