package com.aem.geeks.core.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class})

public class Navigation {

    @ValueMapValue
    @Default(values = "/content/aemgeeks/us/en")
    String  pageRoot;//this is varible, This pageroot refer to (content/aemgeeks/us/en")This path

    public Map<String, String> getchildPageMap() {
        return childPageMap;
    }

    @ScriptVariable
    PageManager pageManager;
    
    Map<String, String> childPageMap; //this is refarence only, listchildren is simple object

    @PostConstruct
    public void init(){

        childPageMap = new HashMap<String,String>();

        Page object = pageManager.getPage(pageRoot);//From this object read all The child pages
        Iterator<Page> listChildren = object.listChildren();//listchildren is the method. it will return all the childpages of by using listchildren method
        while (listChildren.hasNext()) {
            Page page = (Page) listChildren.next();

            childPageMap.put(page.getPath(), page.getTitle());
            
            
        }
        
    }
    
}
