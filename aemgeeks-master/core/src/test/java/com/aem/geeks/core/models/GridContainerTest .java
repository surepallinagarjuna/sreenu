package com.aem.geeks.core.models;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ContainerExporter;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import io.wcm.testing.mock.aem.junit5.AemContext;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

@ExtendWith(AemContextExtension.class)
class GridContainerTest {

    private final AemContext context = new AemContext(ResourceResolverType.JCR_MOCK);

    private GridContainer gridContainer;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(GridContainer.class);

        Resource resource = context.create().resource("/content/test",
                "sling:resourceType", GridContainer.RESOURCE_TYPE,
                "numberOfColumns", "4");

        SlingHttpServletRequest request = context.request();
        context.request().setResource(resource);

        gridContainer = request.adaptTo(GridContainer.class);
    }

    @Test
    void testGetContainerNodeName() {
        assertEquals(GridContainer.GRID_CONTAINER_PARSYS_NODE_NAME, gridContainer.getContainerNodeName());
    }

    @Test
    void testGetNumberOfColumns() {
        assertEquals("4", gridContainer.getNumberOfColumns());

        Resource resource = context.create().resource("/content/test2",
                "sling:resourceType", GridContainer.RESOURCE_TYPE);

        context.request().setResource(resource);

        gridContainer = context.request().adaptTo(GridContainer.class);

        assertEquals("", gridContainer.getNumberOfColumns());
    }

    @Test
    void testGetExportedType() {
        assertEquals(GridContainer.RESOURCE_TYPE, gridContainer.getExportedType());
    }

    @Test
    void testGetExportedItemsOrder() {
        assertArrayEquals(new String[0], gridContainer.getExportedItemsOrder());
    }

    @Test
    void testGetExportedItems() {
        assertEquals(Collections.emptyMap(), gridContainer.getExportedItems());
    }
}