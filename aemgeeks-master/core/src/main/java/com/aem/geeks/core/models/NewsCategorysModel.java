package com.aem.geeks.core.models;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class})
public class NewsCategorysModel {


    @ValueMapValue
    private String title;

    @ValueMapValue
    @Default(values = "newsportal:categories")
    private String categoryTag;//based on this category Tag  we have to creat Tag object. by using the tag API we have to creat tagobj,from the
    //  tag object we have create all childtags.from the childtag to read all title and Number of reference 
    //To create Tagobj it requerd TAGManager

    @SlingObject
    ResourceResolver resolver;//By using @SlingObject we can inject ResourceResolvers, from the resolverObject we can create TAGManager
    
    Map<String, Long> categorychilsTags;
    
    @PostConstruct
    public void init(){

         TagManager tagobj = resolver.adaptTo(TagManager.class);//adaptTo is the object
         Tag tag = tagobj.resolve(categoryTag);    //resolver is method To this resolve to pass the categorytag varible,from this tag object we can read all childtags from this categories 
         Iterator<Tag> listChildren = tag.listChildren();
         while (listChildren.hasNext()) {
            Tag Tags = listChildren.next();
            categorychilsTags.put(Tags.getTitle(),Tags.getCount() );
            
         }
    }

    public String getTitle() {
        return title;
    }

    public Map<String, Long> getCategorychilsTags() {
        return categorychilsTags;
    }
    
}
