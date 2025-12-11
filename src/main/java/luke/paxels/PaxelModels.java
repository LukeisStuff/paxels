package luke.paxels;

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
public class PaxelModels implements ModelEntrypoint {

    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {

    }

    @Override
    public void initItemModels(ItemModelDispatcher dispatcher) {
        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_WOOD, null).setIcon("paxels:item/tool_paxel_wood").setFull3D());
        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_STONE, null).setIcon("paxels:item/tool_paxel_stone").setFull3D());
        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_IRON, null).setIcon("paxels:item/tool_paxel_iron").setFull3D());
        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_GOLD, null).setIcon("paxels:item/tool_paxel_gold").setFull3D());
        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_DIAMOND, null).setIcon("paxels:item/tool_paxel_diamond").setFull3D());
        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_STEEL, null).setIcon("paxels:item/tool_paxel_steel").setFull3D());

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
