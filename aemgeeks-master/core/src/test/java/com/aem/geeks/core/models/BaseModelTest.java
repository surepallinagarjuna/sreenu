// package com.aem.geeks.core.models;
// import com.adobe.cq.export.json.ComponentExporter;
// import com.adobe.cq.export.json.ContainerExporter;
// import com.adobe.cq.export.json.ExporterConstants;
// import com.maximus.aem.base.core.models.BaseModelContainer;
// import com.maximus.aem.base.core.models.FormTab;
// import com.maximus.aem.base.core.models.datalayer.ContainerData;
// import com.maximus.aem.base.core.models.datalayer.builder.DataLayerBuilder;
// import org.apache.sling.api.SlingHttpServletRequest;
// import org.apache.sling.api.resource.Resource;
// import org.apache.sling.models.annotations.Exporter;
// import org.apache.sling.models.annotations.Model;
// import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
// import org.apache.sling.models.annotations.injectorspecific.SlingObject;
// import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;



// import javax.annotation.Nullable;



// @Model(
//         adaptables = {SlingHttpServletRequest.class},
//         adapters = {FormTab.class, ComponentExporter.class, ContainerExporter.class},
//         resourceType = FormTabImpl.RESOURCE_TYPE
// )
// @Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
// public class  BaseModelTest  {



//     public static final String PN_PANEL_TITLE = "cq:panelTitle";
//     public static final String RESOURCE_TYPE = "maximus-base/components/content/form-tabs/form-tab";
//     public static final String TAB_PARSYS_NODE_NAME = "tab-par";



//     @SlingObject
//     private Resource resource;



//   @ValueMapValue(name = PN_PANEL_TITLE, injectionStrategy = InjectionStrategy.OPTIONAL)
//  private String title;



// public String getName() {
//  return resource.getName();
//  }



//     @Override
//     public String getTitle() {
//         return title;
//     }



//     @Override
//     protected String getContainerNodeName() {
//         return TAB_PARSYS_NODE_NAME;
//     }



//     @Override
//     @Nullable
//     public ContainerData getComponentData() {
//         return DataLayerBuilder.extending(super.getComponentData()).asContainer()
//             .withTitle(this::getTitle)
//             .build();
//     }
// }

