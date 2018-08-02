package io.github.hartungstenio.spring.opensearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.hartungstenio.spring.opensearch.model.OpenSearchDescription;

@RestController
public class OpenSearchController {
    
    private final OpenSearchDescription openSearchDescription;
    
    @Autowired
    public OpenSearchController(final OpenSearchDescription openSearchDescription) {
        this.openSearchDescription = openSearchDescription;
    }
    
    @RequestMapping(value = "/content-search.xml", method = RequestMethod.GET, produces = "application/opensearchdescription+xml")
    public OpenSearchDescription getOpenSearchDescriptionDocument() {
        return this.openSearchDescription;
    }
}
