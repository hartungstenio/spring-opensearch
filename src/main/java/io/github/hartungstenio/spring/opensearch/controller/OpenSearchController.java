package io.github.hartungstenio.spring.opensearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.hartungstenio.spring.opensearch.model.OpenSearchDescription;

@RestController
public class OpenSearchController {
    
    // I don't like this syntax, but constructor injection causes a cyclic reference 
    @Autowired
    private OpenSearchDescription openSearchDescription;
    
    @RequestMapping(value = "/content-search.xml", method = RequestMethod.GET, produces = "application/opensearchdescription+xml")
    public OpenSearchDescription getOpenSearchDescriptionDocument() {
        return this.openSearchDescription;
    }
}
