package com.aem.geeks.core.models;
    import java.util.List;

    import javax.inject.Inject;

    import org.apache.sling.api.resource.Resource;
    import org.apache.sling.models.annotations.Default;
    import org.apache.sling.models.annotations.DefaultInjectionStrategy;
    import org.apache.sling.models.annotations.Model;
    import org.apache.sling.models.annotations.injectorspecific.ChildResource;


    @Model (adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

    public class Header {
        @Inject
        @Default(values = "nagarjuna")
        private String pathfield;

        @Inject
        @Default(values = "madhava")
        private String textfield;

        @Inject
        private Boolean checkbox;


        public String getPathfield() {

            return pathfield;
        }

        public String getTextfield() {

            return textfield;
        }

        public Boolean getCheckbox() {
            return checkbox;
        }

        public List<Header1> getMultifield() {
            return multifield;
        }

        @ChildResource
        private List<Header1>multifield;


    }
