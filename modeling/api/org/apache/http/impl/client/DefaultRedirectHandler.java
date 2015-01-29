package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolException;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

public class DefaultRedirectHandler implements RedirectHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.806 -0500", hash_original_field = "4C021DF32978B8873540C8586D107095", hash_generated_field = "AED16E84EEB6EA92E138FA12F2449034")
    
    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.803 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.808 -0500", hash_original_method = "2DD669B5624C7C7440898F877B0DEDA7", hash_generated_method = "648FCB378FF86F9EEBDEE287A5FDE4BB")
    
public DefaultRedirectHandler() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.811 -0500", hash_original_method = "03F3AE903C1DF30A5B96C5B08682C8BA", hash_generated_method = "0B28BC45B12A308D37FAE479BB358BED")
    
public boolean isRedirectRequested(
            final HttpResponse response,
            final HttpContext context) {
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        int statusCode = response.getStatusLine().getStatusCode();
        switch (statusCode) {
        case HttpStatus.SC_MOVED_TEMPORARILY:
        case HttpStatus.SC_MOVED_PERMANENTLY:
        case HttpStatus.SC_SEE_OTHER:
        case HttpStatus.SC_TEMPORARY_REDIRECT:
            return true;
        default:
            return false;
        } //end of switch
    }
 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.814 -0500", hash_original_method = "21747B99F20BEEB46FB81199FFB99B8C", hash_generated_method = "4740C71BA7B35191C20AA85957C5FD67")
    
public URI getLocationURI(
            final HttpResponse response, 
            final HttpContext context) throws ProtocolException {
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        //get the location header to find out where to redirect to
        Header locationHeader = response.getFirstHeader("location");
        if (locationHeader == null) {
            // got a redirect response, but no location header
            throw new ProtocolException(
                    "Received redirect response " + response.getStatusLine()
                    + " but no location header");
        }
        String location = locationHeader.getValue();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Redirect requested to location '" + location + "'");
        }

        URI uri;
        try {
            uri = new URI(location);            
        } catch (URISyntaxException ex) {
            throw new ProtocolException("Invalid redirect URI: " + location, ex);
        }

        HttpParams params = response.getParams();
        // rfc2616 demands the location value be a complete URI
        // Location       = "Location" ":" absoluteURI
        if (!uri.isAbsolute()) {
            if (params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT)) {
                throw new ProtocolException("Relative redirect location '" 
                        + uri + "' not allowed");
            }
            // Adjust location URI
            HttpHost target = (HttpHost) context.getAttribute(
                    ExecutionContext.HTTP_TARGET_HOST);
            if (target == null) {
                throw new IllegalStateException("Target host not available " +
                        "in the HTTP context");
            }
            
            HttpRequest request = (HttpRequest) context.getAttribute(
                    ExecutionContext.HTTP_REQUEST);
            
            try {
                URI requestURI = new URI(request.getRequestLine().getUri());
                URI absoluteRequestURI = URIUtils.rewriteURI(requestURI, target, true);
                uri = URIUtils.resolve(absoluteRequestURI, uri); 
            } catch (URISyntaxException ex) {
                throw new ProtocolException(ex.getMessage(), ex);
            }
        }
        
        if (params.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS)) {
            
            RedirectLocations redirectLocations = (RedirectLocations) context.getAttribute(
                    REDIRECT_LOCATIONS);
            
            if (redirectLocations == null) {
                redirectLocations = new RedirectLocations();
                context.setAttribute(REDIRECT_LOCATIONS, redirectLocations);
            }
            
            URI redirectURI;
            if (uri.getFragment() != null) {
                try {
                    HttpHost target = new HttpHost(
                            uri.getHost(), 
                            uri.getPort(),
                            uri.getScheme());
                    redirectURI = URIUtils.rewriteURI(uri, target, true);
                } catch (URISyntaxException ex) {
                    throw new ProtocolException(ex.getMessage(), ex);
                }
            } else {
                redirectURI = uri;
            }
            
            if (redirectLocations.contains(redirectURI)) {
                throw new CircularRedirectException("Circular redirect to '" +
                        redirectURI + "'");
            } else {
                redirectLocations.add(redirectURI);
            }
        }
        
        return uri;
    }
}
