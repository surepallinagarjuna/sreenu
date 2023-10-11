package com.aem.geeks.core.models;



import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class,
adapters = Surge.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Surge {


    @ValueMapValue
    private String fname;

    @ValueMapValue
    private String lname;

    @ValueMapValue
    private String datepic;

   

    public String getFirstName(){
        return fname;
    }

     public String getLastName(){
        return lname;
    }


    public String getDatepic(){
        return  datepic;
    }
   
    
}
