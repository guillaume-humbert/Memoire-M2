package org.miage.memoire.tiles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.definition.NoSuchDefinitionException;
import org.apache.tiles.servlet.context.ServletUtil;

/**
 * This servlet is used to render the tiles definitions.
 * @author Guillaume Humbert
 */
public class TilesServlet extends HttpServlet {

    /**
     * The HTTP 404 error code.
     */
    private static final int ERROR_404_CODE = 404;

    /**
     * The serialization ID.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Default constructor.
     */
    public TilesServlet() {
        super();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected final void doGet(final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException {
        this.processRequest(request, response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void doPost(final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException {
        this.processRequest(request, response);
    }

    /**
     * Processes an incoming HTTP request.
     * @param request The HTTP request.
     * @param response The HTTP response.
     * @throws ServletException If an IO error occurs.
     */
    protected final void processRequest(final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException {
        String path = request.getRequestURI();

        path = path.replaceFirst(request.getContextPath(), "");
        path = path.replace(".html", "");

        final TilesContainer container = ServletUtil.getContainer(request
                .getSession().getServletContext());

        try {
            container.render(path, request, response);
            container.endContext(request, response);
        } catch (NoSuchDefinitionException e) {
            try {
                response.sendError(TilesServlet.ERROR_404_CODE);
            } catch (IOException ex) {
                throw new ServletException(ex);
            }
        }
    }

}
