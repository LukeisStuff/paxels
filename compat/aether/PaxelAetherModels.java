package luke.paxels.compat.aether;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import turniplabs.halplibe.util.ModelEntrypoint;

@Environment(EnvType.CLIENT)
public class PaxelAetherModels implements ModelEntrypoint {

    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {

    }

    @Override
    public void initItemModels(ItemModelDispatcher dispatcher) {
        dispatcher.addDispatch(new ItemModelStandard(PaxelAetherItems.TOOL_PAXEL_SKYROOT, null).setIcon("paxels:item/tool_paxel_skyroot").setFull3D());
        dispatcher.addDispatch(new ItemModelStandard(PaxelAetherItems.TOOL_PAXEL_HOLYSTONE, null).setIcon("paxels:item/tool_paxel_holystone").setFull3D());
        dispatcher.addDispatch(new ItemModelStandard(PaxelAetherItems.TOOL_PAXEL_ZANITE, null).setIcon("paxels:item/tool_paxel_zanite").setFull3D());
        dispatcher.addDispatch(new ItemModelStandard(PaxelAetherItems.TOOL_PAXEL_GRAVITITE, null).setIcon("paxels:item/tool_paxel_gravitite").setFull3D());
        dispatcher.addDispatch(new ItemModelStandard(PaxelAetherItems.TOOL_PAXEL_VALKYRIE, null).setIcon("paxels:item/tool_paxel_valkyrie").setFull3D());
    }

    @Override
    public void initEntityModels(EntityRenderDispatcher dispatcher) {

    }

    @Override
    public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

    }

    @Override
    public void initBlockColors(BlockColorDispatcher dispatcher) {

    }
}
