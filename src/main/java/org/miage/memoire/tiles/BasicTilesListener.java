package org.miage.memoire.tiles;

import org.apache.tiles.startup.TilesInitializer;
import org.apache.tiles.web.startup.AbstractTilesListener;

/**
 * This class is used to start the Tiles engine. See <a
 * href="http://tiles.apache.org/framework/tutorial/configuration.html"> tiles
 * configuration tutorial.</a>
 * @author Guillaume Humbert
 */
public final class BasicTilesListener extends AbstractTilesListener {

    /**
     * Default constructor.
     */
    public BasicTilesListener() {
        super();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected TilesInitializer createTilesInitializer() {
        return new SimpleTilesInitializer();
    }

}
