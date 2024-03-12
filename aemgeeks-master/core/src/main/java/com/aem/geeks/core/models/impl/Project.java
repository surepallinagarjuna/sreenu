package com.aem.geeks.core.models.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables =Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Project {

    @ValueMapValue
    private String pagetitle;

    @ValueMapValue
    private String pagename;

   
    @ChildResource
    Resource naga;

    public String getPageTitle() {
        return pagetitle;
    }

    public String getPageName() {
        return pagename;
    }

   

    public List<Map<String,String>> getMultifield()
    {
        List<Map<String,String>>  mainMap = new ArrayList<>();

        try{

        if (naga!=null) 
        {
            Map<String,String> childMap = new HashMap<>();
            for(Resource chilResource:naga.getChildren())
            {
               
                childMap.put("pagename",chilResource.getValueMap().get("pagename",String.class));
                childMap.put("pagetitle",chilResource.getValueMap().get("pagetitle",String.class));
                mainMap.add(childMap);

            }
            
        }
    }catch(Exception e)
    {
        e.printStackTrace();

    }
    return mainMap;

    }

  
    
}
