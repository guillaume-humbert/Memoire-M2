package org.miage.memoire;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * This filter sets the UTF-8 charset on the request and response objects.
 * @author Guillaume Humbert
 */
public class CharsetFilter implements Filter {

    /**
     * Default empty constructor.
     */
    public CharsetFilter() {
        super();
    }
    
    /**
     * Nothing is done.
     */
    @Override
    public void destroy() {
        // Nothing.
    }

    /**
     * Sets the UTF-8 charset encoding on request and response objects.
     * @param request The HTTP request.
     * @param response The HTTP response.
     * @param chain The filter chain.
     * @throws ServletException If an error occurred..
     */
    @Override
    public void doFilter(final ServletRequest request,
        final ServletResponse response, final FilterChain chain)
        throws ServletException {
        
        try {
            final String charset = "UTF-8";
            request.setCharacterEncoding(charset);
            response.setCharacterEncoding(charset);
            chain.doFilter(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }
        
    }

    /**
     * Nothing is done.
     * @param config Not used.
     * @throws ServletException Not thrown.
     */
    @Override
    public void init(final FilterConfig config) throws ServletException {
        // Nothing.
        
    }

}
