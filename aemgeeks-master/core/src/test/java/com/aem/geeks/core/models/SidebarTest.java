package com.aem.geeks.core.models;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
public class SidebarTest {

    private final AemContext context = new AemContext();
    private Sidebar sidebar;

    @BeforeEach
    public void setUp() {
        context.addModelsForClasses(Sidebar.class, one.class, two.class, three.class);
        // Create the main sidebar resource with its properties
        context.create().resource("/content/sidebar",
                "path", "/content/example",
                "imageRef", "/content/dam/image.jpg",
                "image", "image.jpg",
                "link", "/content/link",
                "button", "Read More",
                "country", "USA");

        // Create the child resource 'one' under 'sidebar'
        context.create().resource("/content/sidebar/one/item1",
                "name", "Item 1",
                "image", "image1.jpg");

        // Create the child resource 'two' under 'sidebar'
        context.create().resource("/content/sidebar/two/item1",
                "mobile", "mobile.jpg",
                "desktop", "desktop.jpg");

        // Create the child resource 'three' under 'two'
        context.create().resource("/content/sidebar/two/item1/three/item1",
                "url", "http://example.com");

        // Adapt the resource to the Sidebar model
        sidebar = context.resourceResolver().getResource("/content/sidebar").adaptTo(Sidebar.class);
    }

    @Test
    public void testGetPath() {
        assertNotNull(sidebar);
        assertEquals("/content/example", sidebar.getPath());
    }

    @Test
    public void testGetImageRef() {
        assertNotNull(sidebar);
        assertEquals("/content/dam/image.jpg", sidebar.getImageRef());
    }

//    @Test
//    public void testGetImage() {
//        assertNotNull(sidebar);
//        assertEquals("image.jpg", sidebar.getImage());
//    }

    @Test
    public void testGetLink() {
        assertNotNull(sidebar);
        assertEquals("/content/link", sidebar.getLink());
    }

    @Test
    public void testGetButton() {
        assertNotNull(sidebar);
        assertEquals("Read More", sidebar.getButton());
    }

    @Test
    public void testGetCountry() {
        assertNotNull(sidebar);
        assertEquals("USA", sidebar.getCountry());
    }

    @Test
    public void testGetOne() {
        List<one> oneList = sidebar.getOne();
        assertNotNull(oneList);
        assertEquals(1, oneList.size());
        assertEquals("Item 1", oneList.get(0).getName());
        assertEquals("image1.jpg", oneList.get(0).getImage());
    }

    @Test
    public void testGetTwo() {
        List<two> twoList = sidebar.getTwo();
        assertNotNull(twoList);
        assertEquals(1, twoList.size());
        assertEquals("mobile.jpg", twoList.get(0).getMobile());
        assertEquals("desktop.jpg", twoList.get(0).getDesktop());

        List<three> threeList = twoList.get(0).getThree();
        assertNotNull(threeList);
        assertEquals(1, threeList.size());
        assertEquals("http://example.com", threeList.get(0).getUrl());
     }
}