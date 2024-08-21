package com.aem.geeks.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ContainerExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Collections;
import java.util.Map;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = {GridContainer.class, ComponentExporter.class, ContainerExporter.class},
    resourceType = GridContainer.RESOURCE_TYPE
)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class GridContainer implements ContainerExporter {

    public static final String RESOURCE_TYPE = "maximus-base/components/content/grid-container";
    public static final String GRID_CONTAINER_PARSYS_NODE_NAME = "grid";

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String numberOfColumns;

    protected String getContainerNodeName() {
        return GRID_CONTAINER_PARSYS_NODE_NAME;
    }

    public String getNumberOfColumns() {
        return StringUtils.isNotBlank(this.numberOfColumns) ? this.numberOfColumns : "";
    }

    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }

    @Override
    public String[] getExportedItemsOrder() {
        return new String[0]; // Implement this if needed
    }

    @Override
    public Map<String, ComponentExporter> getExportedItems() {
        return Collections.emptyMap(); // Implement this if needed
    }
}