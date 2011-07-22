package org.miage.memoire.tiles;

import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.factory.BasicTilesContainerFactory;
import org.apache.tiles.startup.AbstractTilesInitializer;

/**
 * This class is used to initialize the Tiles framework.
 * @see BasicTilesListener
 * @author Guillaume Humbert
 */
public final class SimpleTilesInitializer extends AbstractTilesInitializer {

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbstractTilesContainerFactory createContainerFactory(
            final TilesApplicationContext context) {
        return new BasicTilesContainerFactory();
    }

}
