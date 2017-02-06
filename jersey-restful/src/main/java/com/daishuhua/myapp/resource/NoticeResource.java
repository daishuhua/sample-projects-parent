package com.daishuhua.myapp.resource;

import org.glassfish.jersey.server.mvc.Template;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daishuhua on 17-2-3.
 */
@Path("/")
public class NoticeResource {

    @GET
//    @Path("{subResources:.+}")
    @Path("pc")
    @Template(name = "/notice")
    @Produces("text/html")
    public String showNoticePage() {
        return "";
    }

    @POST
//    @Path("{subResources:.+}")
    @Path("mobile")
    @Produces("application/json")
    public Map<String, String> responseMobileApi() {
        Map<String, String> test = new HashMap<>();
        test.put("key1", "value1");
        test.put("key2", "value2");
        return test;
    }
}
