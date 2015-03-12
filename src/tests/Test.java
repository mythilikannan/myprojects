package tests;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class Test {
	
	public static void main(String args[])
	{
		ClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);     
	    Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
	    // create one expense
	    
	    Map<String,Object> postBody = new HashMap<String,Object>();
	    postBody.put("date", "2015-02-20");
	    postBody.put("amount", 100);
	    postBody.put("reason", "example tax");
	    
	    	    ClientResponse response = service.path("REST").path("expenses").path("post")
	            .accept("application/json")
                .type("application/json").post(ClientResponse.class, postBody);
	    
	    // Get all the expenses. 
	    System.out.println(service.path("REST").path("expenses").path("get")
	        .accept(MediaType.APPLICATION_JSON).get(String.class));


	}

	 private static URI getBaseURI() {
		    return UriBuilder.fromUri("http://localhost:8080/test/").build();
		  }

}
