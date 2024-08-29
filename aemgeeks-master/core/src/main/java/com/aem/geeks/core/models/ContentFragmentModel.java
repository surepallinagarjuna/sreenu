package com.aem.geeks.core.models;



import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.cq.dam.cfm.ContentElement;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class ContentFragmentModel {

    @ChildResource(name = "primaryFragment")
    private Resource primaryFragmentResource;

    @ValueMapValue(name = "referenceFieldName")
    private String referencePath;

    public String getName() {
        ContentFragment primaryFragment = primaryFragmentResource.adaptTo(ContentFragment.class);
        if (primaryFragment != null) {
            ContentElement nameElement = primaryFragment.getElement("Name");
            if (nameElement != null) {
                return nameElement.getContent();
            }
        }
        return null;
    }

    public String getNumber() {
        ContentFragment primaryFragment = primaryFragmentResource.adaptTo(ContentFragment.class);
        if (primaryFragment != null) {
            ContentElement numberElement = primaryFragment.getElement("Number");
            if (numberElement != null) {
                return numberElement.getContent();
            }
        }
        return null;
    }

    public String getReferencedFragmentContent(ResourceResolver resourceResolver) {
        // Get the referenced content fragment resource
        Resource referencedFragmentResource = resourceResolver.getResource(referencePath);
        if (referencedFragmentResource != null) {
            ContentFragment referencedFragment = referencedFragmentResource.adaptTo(ContentFragment.class);
            if (referencedFragment != null) {
                ContentElement titleElement = referencedFragment.getElement("Title");
                ContentElement descriptionElement = referencedFragment.getElement("Description");

                // Fetch and return the content from the referenced fragment
                return (titleElement != null ? titleElement.getContent() : "") + ": " +
                       (descriptionElement != null ? descriptionElement.getContent() : "");
            }
        }
        return "Referenced fragment not found.";
    }
}

