package luke.paxels.compat.deep;

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
public class PaxelDeepModels implements ModelEntrypoint {

	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {

	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
		dispatcher.addDispatch(new ItemModelStandard(PaxelDeepItems.TOOL_PAXEL_AMETHYST, null).setIcon("paxels:item/tool_paxel_amethyst").setFull3D());
		dispatcher.addDispatch(new ItemModelStandard(PaxelDeepItems.TOOL_PAXEL_LEAD, null).setIcon("paxels:item/tool_paxel_lead").setFull3D());
		dispatcher.addDispatch(new ItemModelStandard(PaxelDeepItems.TOOL_PAXEL_SILVER, null).setIcon("paxels:item/tool_paxel_silver").setFull3D());
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
