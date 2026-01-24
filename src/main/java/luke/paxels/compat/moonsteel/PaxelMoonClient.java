package luke.paxels.compat.moonsteel;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import turniplabs.halplibe.util.ModelEntrypoint;

import static luke.paxels.compat.moonsteel.PaxelMoonMod.IS_MOON_LOADED;

public class PaxelMoonClient implements ModelEntrypoint {
    public static ModelEntrypoint modelEntryPointDelegate;

    static {
        if (IS_MOON_LOADED) {
            try {

                modelEntryPointDelegate = (ModelEntrypoint) Class
                    .forName("luke.paxels.compat.moonsteel.PaxelMoonModels")
                    .getConstructor()
                    .newInstance();

            } catch (Exception e) {
                throw new RuntimeException("Failed to init Moon3 model delegate", e);
            }
        }
    }

    @Override
    public void initBlockColors(BlockColorDispatcher dispatcher) {
        if (IS_MOON_LOADED) modelEntryPointDelegate.initBlockColors(dispatcher);
    }

    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {
        if (IS_MOON_LOADED) modelEntryPointDelegate.initBlockModels(dispatcher);
    }

    @Override
    public void initItemModels(ItemModelDispatcher dispatcher) {
        if (IS_MOON_LOADED) modelEntryPointDelegate.initItemModels(dispatcher);
    }

    @Override
    public void initEntityModels(EntityRenderDispatcher dispatcher) {
        if (IS_MOON_LOADED) modelEntryPointDelegate.initEntityModels(dispatcher);
    }

    @Override
    public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {
        if (IS_MOON_LOADED) modelEntryPointDelegate.initTileEntityModels(dispatcher);
    }

}
