package luke.paxels;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;

import static net.minecraft.core.item.tool.ItemToolPickaxe.miningLevels;

public class ItemToolPaxel extends ItemTool {

	protected ItemToolPaxel(String name, String namespaceId, int id, ToolMaterial toolMaterial) {
		super(name, namespaceId, id, 3, toolMaterial, null);
	}

	public float getStrVsBlock(ItemStack itemstack, Block<?> block) {
		return block.hasTag(BlockTags.MINEABLE_BY_PICKAXE) || block.hasTag(BlockTags.MINEABLE_BY_AXE) || block.hasTag(BlockTags.MINEABLE_BY_SHOVEL) || block.hasTag(BlockTags.MINEABLE_BY_HOE) ? this.material.getEfficiency(false) : 1.0F;
	}

	public boolean canHarvestBlock(Mob mob, ItemStack itemStack, Block<?> block) {
		Integer miningLevel = miningLevels.get(block);
		if (miningLevel != null) {
			return this.material.getMiningLevel() >= miningLevel;
		} else {
			return block.hasTag(BlockTags.MINEABLE_BY_PICKAXE) || block.hasTag(BlockTags.MINEABLE_BY_AXE) || block.hasTag(BlockTags.MINEABLE_BY_SHOVEL) || block.hasTag(BlockTags.MINEABLE_BY_HOE);
		}
	}
}
