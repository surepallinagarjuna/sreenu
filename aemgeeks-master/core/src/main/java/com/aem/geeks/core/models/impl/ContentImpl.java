package com.aem.geeks.core.models.impl;


import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = SlingHttpServletRequest.class,
                   resourceType = ContentImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ContentImpl {
    public static final String RESOURCE_TYPE="capstone/components/excontent";
    @Self
    SlingHttpServletRequest request;

    @SlingObject
    Resource currentResource;

    private String Name;
    private String Address;
    private String Number;
    private String Names;
    private String cfPath;

    @Inject
    private ResourceResolver resolver;

    @PostConstruct
    public void inti(){
        ResourceResolver resource = request.getResourceResolver();
        PageManager pageManager = resolver.adaptTo(PageManager.class);
        Page page = pageManager.getContainingPage(currentResource.getPath());
        if (page!=null) {
            ValueMap value = page.getProperties();
            this.cfPath = value.get("cfPath",String.class);
            
        }
         Resource resource2 = resolver.getResource(cfPath + "/jcr:content/data/master");
        if (null != resource2) {

            Name = resource2.getValueMap().get("Name", String.class);
            Address = resource2.getValueMap().get("Address", String.class);
            Number = resource2.getValueMap().get("Number", String.class);
            Names = resource2.getValueMap().get("Names", String.class);
        }      
       

    }

    public static String getResourceType() {
        return RESOURCE_TYPE;
    }

    public Resource getCurrentResource() {
        return currentResource;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getNumber() {
        return Number;
    }

    public String getNames() {
        return Names;
    }

    public ResourceResolver getResolver() {
        return resolver;
    }
    
}
