package com.aem.geeks.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class,
adapters = Studentex.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Student implements Studentex
{

     
    @ValueMapValue
    private String fname;

    @ValueMapValue
    private String lname;

    @ValueMapValue
    private String professor;

   
    @ValueMapValue
    private String id;

    
   @ValueMapValue
    private String fvcolor;    

   
    @ValueMapValue
    private String clgname;


    @ValueMapValue
    private String text;

    @ValueMapValue
    private String pathbrowser;

    public String getFirstName(){
        return fname;
    }

     public String getLastName(){
        return lname;
    }

    public String getProfessor(){
        return professor;
    }


    public String getID(){
        return id;
    }

    public String getFvColor(){
        return fvcolor;
    }

    public String getClgName(){
        return clgname;
    }

    public String getText(){
        return text;
    }

    public String getPathbrowser(){
        return  pathbrowser;
    }



    
}
