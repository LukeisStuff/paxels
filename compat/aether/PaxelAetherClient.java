package luke.paxels.compat.aether;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import turniplabs.halplibe.util.ModelEntrypoint;

import static luke.paxels.compat.aether.PaxelAetherMod.IS_AETHER_LOADED;

public class PaxelAetherClient implements ModelEntrypoint {
    public static ModelEntrypoint modelEntryPointDelegate;

    static {
        if (IS_AETHER_LOADED) {
            try {

                modelEntryPointDelegate = (ModelEntrypoint) Class
                    .forName("luke.paxels.compat.aether.PaxelAetherModels")
                    .getConstructor()
                    .newInstance();

            } catch (Exception e) {
                throw new RuntimeException("Failed to init Aether model delegate", e);
            }
        }
    }

    @Override
    public void initBlockColors(BlockColorDispatcher dispatcher) {
        if (IS_AETHER_LOADED) modelEntryPointDelegate.initBlockColors(dispatcher);
    }

    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {
        if (IS_AETHER_LOADED) modelEntryPointDelegate.initBlockModels(dispatcher);
    }

    @Override
    public void initItemModels(ItemModelDispatcher dispatcher) {
        if (IS_AETHER_LOADED) modelEntryPointDelegate.initItemModels(dispatcher);
    }

    @Override
    public void initEntityModels(EntityRenderDispatcher dispatcher) {
        if (IS_AETHER_LOADED) modelEntryPointDelegate.initEntityModels(dispatcher);
    }

    @Override
    public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {
        if (IS_AETHER_LOADED) modelEntryPointDelegate.initTileEntityModels(dispatcher);
    }

}
