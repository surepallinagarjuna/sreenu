package com.aem.geeks.core.services.impl;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.aem.geeks.core.services.Osg;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;


@Component(service = Osg.class,immediate = true)

public class Osgimpl implements Osg{

    @Reference
    ResourceResolverFactory resourceResolver;



    @Activate
    public void activate(ComponentContext componentContext){
        
    }

    @Deactivate
    public void deactivate(ComponentContext componentContext){
    }

    @Modified
    public void modified(ComponentContext componentContext){
    
}

    @Override
    public Iterator<Page> getlistChildren(SlingHttpServletRequest req) {
         ResourceResolver resourceResolver = req.getResourceResolver();
        String parameter = req.getParameter("parameter");
        try{
            PageManager pageManager=resourceResolver.adaptTo(PageManager.class);
            Page page=pageManager.getPage(parameter);
            Iterator<Page> pages=page.listChildren();
            return pages;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Iterator<Page> getpages() {
        try {
            HashMap<String, Object> obj = new HashMap<String,Object>();
        obj.put(ResourceResolverFactory.SUBSERVICE, "mynewsrevice");
                //fetches the admin service resolver using user

        ResourceResolver serviceResourceResolver = resourceResolver.getServiceResourceResolver(obj);
        PageManager laptop = serviceResourceResolver.adaptTo(PageManager.class);
        Page page=laptop.getPage("/content/aemgeeks/us");
        Iterator<Page> pages=page.listChildren();
        return pages;
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }


    }
       
    