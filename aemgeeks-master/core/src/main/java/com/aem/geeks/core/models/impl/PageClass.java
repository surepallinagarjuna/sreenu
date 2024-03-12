package com.aem.geeks.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.models.Task;

@Model(adaptables = SlingHttpServletRequest.class,adapters = Task.class,defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class PageClass implements Task {

    @ValueMapValue
   private String contact;


   @ValueMapValue
   private String favorites;
   
   @ValueMapValue
   private String name;

   @ValueMapValue
   private String text;

   @ValueMapValue
   private String title;

   public String getContact(){
    return contact;
   }
   public String getFavorites(){
    return favorites;
   } 

   
   public String getName(){
    return name;
   }

   public String getText(){
    return text;
   }

   public String getTitle(){
    return title;
   }

    
}
