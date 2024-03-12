//  package com.aem.geeks.core.services;

// // import org.osgi.service.component.annotations.Activate;
// // import org.osgi.service.component.annotations.Component;
// // import org.osgi.service.component.annotations.Deactivate;
// // import org.osgi.service.component.annotations.Modified;
// // import org.slf4j.Logger;
// // import org.slf4j.LoggerFactory;

// // @Component(immediate =true)
// // public class ParuService {

// //     private static final Logger LOG = LoggerFactory.getLogger(ParuService.class);

// //     @Activate
// //     public void activate(){
// //         LOG.info("ParuService - I am busy");

// //     }

// //     @Deactivate
// //     public void Deactivate(){
// //         LOG.info(" ParuService - am notbusy");

// //     }

// //     @Modified
// //     public void Modified(){
// //         LOG.info("ParuService - i am alredy told na");

// //     }
    
// // }

// import java.util.ArrayList;
// import java.util.Iterator;

// import javax.inject.Inject;

// import org.apache.sling.api.SlingHttpServletRequest;
// import org.apache.sling.api.resource.Resource;
// import org.apache.sling.models.annotations.DefaultInjectionStrategy;
// import org.apache.sling.models.annotations.Model;
// import org.apache.sling.models.annotations.injectorspecific.ChildResource;
// import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

// @Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
// public class NSlingPractice {
// 	@ValueMapValue
// 	public String name;

// 	@ValueMapValue
// 	public Integer number;

// 	@Inject
// 	Resource resource;

	

// 	public String getName() {
// 		return name;
// 	}

// 	public Integer getNumber() {
// 		return number;
// 	}

// 	@ChildResource
// 	Resource studentdetails;
	

// 	public ArrayList<Nbeans> getMultiChildNode() {
// 		ArrayList<Nbeans> emmy = new ArrayList<Nbeans>();
// 		Nbeans nb = new Nbeans();
		
// 		Resource childResource=resource.getChild("studentdetails");
// 		Iterator<Resource> itemResource = childResource.listChildren();

// 		while (itemResource.hasNext()) {

// 			Resource itemResource1 = itemResource.next();

// 			// to get the data //
// 			String fullname = itemResource1.getValueMap().get("fullname", String.class);
// 			Integer studentnumber = itemResource1.getValueMap().get("studentnumber", Integer.class);
// 			Integer pincode = itemResource1.getValueMap().get("pincode", Integer.class);
// 			String address = itemResource1.getValueMap().get("address", String.class);

// 			// to set the data//
// 			nb.setFullname(fullname);
// 			nb.setStudentnumber(studentnumber);
// 			nb.setPincode(pincode);
// 			nb.setAddress(address);

// 			// sub child

// 			Resource subChildResource = itemResource1.getChild("employeedetailswithnestedmultifield");

// 			Iterator<Resource> item = subChildResource.listChildren();
// 			while (item.hasNext()) {
// 				Resource itemResource2 = item.next();
// 				String empname = itemResource2.getValueMap().get("empname", String.class);
// 				Integer empid = itemResource2.getValueMap().get("empid", Integer.class);
// 				String dob = itemResource2.getValueMap().get("dob", String.class);
// 				nb.setEmpname(empname);
// 				nb.setEmpid(empid);
// 				nb.setDob(dob);

			

// 			// sub child1

// 			Resource subChildResource1 = itemResource2.getChild("bookdetails");
// 			Iterator<Resource> item1 = subChildResource1.listChildren();
// 			while (item1.hasNext()) {
// 				Resource itemresource3 = item1.next();

// 				String authorname = itemresource3.getValueMap().get("authorname", String.class);
// 				String publishyear = itemresource3.getValueMap().get("publishyear", String.class);
// 				String bookname = itemresource3.getValueMap().get("bookname", String.class);

// 				nb.setAuthorname(authorname);
// 				nb.setPublishyear(publishyear);
// 				nb.setBookname(bookname);
// 				emmy.add(nb);
// 			}
// 		}
// 	}
// 		return emmy;

// 	}

// }

