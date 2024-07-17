package com.aem.geeks.core.models;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
public class CarouselMultifieldModelTest {

    AemContext aemContext = new AemContext();

    CarouselMultifieldModel carouselMultifieldModel;

    CarouselModel carouselModel;

    @BeforeEach
    public void setup() throws Exception {
        aemContext.addModelsForClasses(CarouselMultifieldModel.class, CarouselModel.class, CarouselNestedMultModel.class);

        Map<String, Object> properties = new HashMap<>();
        properties.put("jcr:primaryType", "nt:unstructured");

        Resource articleResource = aemContext.create().resource("/content/Carousel_Model", properties);

        // Create a single multifield item
        Map<String, Object> item1 = new HashMap<>();
        item1.put("name", "naga");
        item1.put("profile", "ntr");

        aemContext.create().resource("/content/Carousel_Model/carousel/item1", item1);

        carouselMultifieldModel = articleResource.adaptTo(CarouselMultifieldModel.class);

        // Create a single multifield item
        Map<String, Object> item2 = new HashMap<>();
        item2.put("place", "hyd");

        aemContext.create().resource("/content/Carousel_Model/nestedmultifield/item2", item2);

        carouselModel = articleResource.adaptTo(CarouselModel.class);

    }

    @Test
    public void test() {
        // Test multifield

        assertEquals(1, carouselMultifieldModel.getCarousel().size());

        CarouselModel item1 = carouselMultifieldModel.getCarousel().get(0);
        assertEquals("naga", item1.getName());
        assertEquals("ntr", item1.getProfile());


        assertEquals(1, carouselModel.getNestedmultifield().size());

        CarouselNestedMultModel item2 = carouselModel.getNestedmultifield().get(0);
        assertEquals("hyd", item2.getPlace());

       }
}