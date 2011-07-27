package org.miage.memoire.tiles;

import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.factory.BasicTilesContainerFactory;
import org.apache.tiles.startup.AbstractTilesInitializer;

/**
 * This class is used to initialize the Tiles framework.
 * @see BasicTilesListener
 * @author Guillaume Humbert
 */
public final class SimpleTilesInitializer extends AbstractTilesInitializer {

    /**
     * Default constructor.
     */
    public SimpleTilesInitializer() {
        super();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected BasicTilesContainerFactory createContainerFactory(
            final TilesApplicationContext context) {
        return new BasicTilesContainerFactory();
    }

}
