package io.github.hartungstenio.spring.opensearch.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class OpenSearchQuery {
    
    public static final String REQUEST = "request";
    public static final String EXAMPLE = "example";
    public static final String RELATED = "related";
    public static final String CORRECTION = "correction";
    public static final String SUBSET = "subset";
    public static final String SUPERSET = "superset";
    
    private final String role;
    private final String title;
    private final Integer totalResults;
    private final String searchTerms;
    private final Integer count;
    private final Integer startIndex;
    private final Integer startPage;
    private final String language;
    private final String inputEncoding;
    private final String outputEncoding;
    
    private OpenSearchQuery(Builder builder) {
        this.role = builder.role;
        this.title = builder.title;
        this.totalResults = builder.totalResults;
        this.searchTerms = builder.searchTerms;
        this.count = builder.count;
        this.startIndex = builder.startIndex;
        this.startPage = builder.startPage;
        this.language = builder.language;
        this.inputEncoding = builder.inputEncoding;
        this.outputEncoding = builder.outputEncoding;
    }
    
    private OpenSearchQuery() {
        // Workaround for JAXB
        this(new Builder(null));
    }
    
    @XmlAttribute
    public String getRole() {
        return this.role;
    }
    
    @XmlAttribute
    public String getTitle() {
        return this.title;
    }
    
    @XmlAttribute
    public Integer getTotalResults() {
        return this.totalResults;
    }
    
    @XmlAttribute
    public String getSearchTerms() {
        return this.searchTerms;
    }
    
    @XmlAttribute
    public Integer getCount() {
        return this.count;
    }
    
    @XmlAttribute
    public Integer getStartIndex() {
        return this.startIndex;
    }
    
    @XmlAttribute
    public Integer getStartPage() {
        return this.startPage;
    }
    
    @XmlAttribute
    public String getLanguage() {
        return this.language;
    }
    
    @XmlAttribute
    public String getInputEncoding() {
        return this.inputEncoding;
    }
    
    @XmlAttribute
    public String getOutputEncoding() {
        return this.outputEncoding;
    }

    public static final class Builder {
        
        private final String role;
        
        private String title;
        private Integer totalResults;
        private String searchTerms;
        private Integer count;
        private Integer startIndex;
        private Integer startPage;
        private String language;
        private String inputEncoding;
        private String outputEncoding;
        
        public Builder(final String role) {
            this.role = role;
        }
        
        public Builder title(final String title) {
            this.title = title;
            return this;
        }
        
        public Builder totalResults(final Integer totalResults) {
            this.totalResults = totalResults;
            return this;
        }
        
        public Builder searchTerms(final String searchTerms) {
            this.searchTerms = searchTerms;
            return this;
        }
        
        public Builder count(final Integer count) {
            this.count = count;
            return this;
        }
        
        public Builder startIndex(final Integer startIndex) {
            this.startIndex = startIndex;
            return this;
        }
        
        public Builder startPage(final Integer startPage) {
            this.startPage = startPage;
            return this;
        }
        
        public Builder language(final String language) {
            this.language = language;
            return this;
        }
        
        public Builder inputEncoding(final String inputEncoding) {
            this.inputEncoding = inputEncoding;
            return this;
        }
        
        public Builder outputEncoding(final String outputEncoding) {
            this.outputEncoding = outputEncoding;
            return this;
        }
        
        public OpenSearchQuery build() {
            return new OpenSearchQuery(this);
        }
    }
}
