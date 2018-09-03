package io.github.hartungstenio.spring.opensearch.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

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
    private final List<OpenSearchQuery> query;
    private final String developer;
    private final String attribution;
    private final SyndicationRights syndicationRight;
    private final Boolean adultContent;
    
    private final List<String> language;
    private final List<String> inputEncoding;
    private final List<String> outputEncoding;
    
    private OpenSearchDescription(Builder builder) {
        this.shortName = builder.shortName;
        this.description = builder.description;
        this.url = builder.urls;
        this.contact = builder.contact;
        this.tags = builder.tags.toString();
        this.longName = builder.longName;
        this.image = builder.images;
        this.query = builder.query;
        this.developer = builder.developer;
        this.attribution = builder.attribution;
        this.syndicationRight = builder.syndicationRight;
        this.adultContent = builder.adultContent;
        this.language = builder.language;
        this.inputEncoding = builder.inputEncodings;
        this.outputEncoding = builder.outputEncodings;
    }
    
    private OpenSearchDescription() {
        // Workaround for JAXB
        this(new Builder(null, null));
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
    
    @XmlElement(name = "Query")
    public List<OpenSearchQuery> getQuery() {
        return this.query;
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
        private List<OpenSearchUrl> urls = new ArrayList<>();
        private String contact;
        private StringJoiner tags = new StringJoiner(" ");
        private String longName;
        private List<OpenSearchImage> images = new ArrayList<>();
        private List<OpenSearchQuery> query = new ArrayList<>();
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
        
        public Builder url(final String template, final String type) {
            return url(new OpenSearchUrl.Builder(template, type).build());
        }
        
        public Builder url(final OpenSearchUrl url) {
            this.urls.add(url);
            return this;
        }
        
        public Builder contact(String contact) {
            this.contact = clear(contact);
            return this;
        }
        
        public Builder tag(final String tag) {
            String cleared = clear(tag);
            
            if(cleared != null) {
                this.tags.add(cleared);
            }
            
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
            if(value == null) return null;
            if("".equals(value.trim())) return null;
            return value;
        }
        
        public OpenSearchDescription build() {
            return new OpenSearchDescription(this);
        }
    }
}