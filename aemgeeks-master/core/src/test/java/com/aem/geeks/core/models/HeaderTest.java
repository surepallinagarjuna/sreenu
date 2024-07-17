package com.aem.geeks.core.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.google.common.collect.ImmutableMap;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class HeaderTest {

    private final AemContext ctx = new AemContext();

    @BeforeEach
    void setUp() {
        ctx.addModelsForClasses(Header.class, Header1.class);

        // Creating the parent Header resource
        ctx.create().resource("/content/header",
                ImmutableMap.<String, Object>builder()
                        .put("pathfield", "nagarjuna")
                        .put("textfield", "madhava")
                        .put("checkbox", true)
                        .build());

        // Creating the child Header1 resources
        ctx.create().resource("/content/header/multifield/0",
                ImmutableMap.<String, Object>builder()
                        .put("name", "John Doe")
                        .put("date", Calendar.getInstance())
                        .build());
        ctx.create().resource("/content/header/multifield/1",
                ImmutableMap.<String, Object>builder()
                        .put("name", "Jane Doe")
                        .put("date", Calendar.getInstance())
                        .build());
    }

    @Test
    void testHeaderModel() {
        Resource headerResource = ctx.resourceResolver().getResource("/content/header");
        Header header = headerResource.adaptTo(Header.class);
        assertNotNull(header);
        assertEquals("nagarjuna", header.getPathfield());
        assertEquals("madhava", header.getTextfield());
        assertTrue(header.getCheckbox());

        List<Header1> multifield = header.getMultifield();
        assertNotNull(multifield);
        assertEquals(2, multifield.size());

        Header1 header1_0 = multifield.get(0);
        assertEquals("John Doe", header1_0.getText());
        assertNotNull(header1_0.getDate());

        Header1 header1_1 = multifield.get(1);
        assertEquals("Jane Doe", header1_1.getText());
        assertNotNull(header1_1.getDate());
    }
}
