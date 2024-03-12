package com.aem.geeks.core.models.impl;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.models.Friendex;

@Model(adaptables = SlingHttpServletRequest.class,adapters = Friendex.class,defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class Friend implements Friendex{

    @ ValueMapValue
    private List<String> friend;

    @ValueMapValue
    private List<String> text;
   
    public void setText(List<String> text) {
        this.text = text;
    }

    public List<String> getFriend() {
        return friend;
    }
   
    
   
}
