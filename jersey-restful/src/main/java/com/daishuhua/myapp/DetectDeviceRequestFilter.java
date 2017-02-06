package com.daishuhua.myapp;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import java.io.IOException;
import java.net.URI;

/**
 * Created by daishuhua on 17-2-4.
 */

@PreMatching
public class DetectDeviceRequestFilter implements ContainerRequestFilter{

    /**
     * Filter method called before a request has been dispatched to a resource.
     * <p>
     * <p>
     * Filters in the filter chain are ordered according to their {@code javax.annotation.Priority}
     * class-level annotation value.
     * If a request filter produces a response by calling {@link ContainerRequestContext#abortWith}
     * method, the execution of the (either pre-match or post-match) request filter
     * chain is stopped and the response is passed to the corresponding response
     * filter chain (either pre-match or post-match). For example, a pre-match
     * caching filter may produce a response in this way, which would effectively
     * skip any post-match request filters as well as post-match response filters.
     * Note however that a responses produced in this manner would still be processed
     * by the pre-match response filter chain.
     * </p>
     *
     * @param requestContext request context.
     * @throws IOException if an I/O exception occurs.
     * @see PreMatching
     */
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        URI requestUri;

        if (requestContext.getHeaderString("User-Agent").contains("Mobile")) {
            requestUri = requestContext.getUriInfo().getBaseUriBuilder().path("/mobile").build();
            requestContext.setMethod(HttpMethod.POST);
        } else {
            requestUri = requestContext.getUriInfo().getBaseUriBuilder().path("/pc").build();
            requestContext.setMethod(HttpMethod.GET);
        }
        requestContext.setRequestUri(requestUri);
    }
}
