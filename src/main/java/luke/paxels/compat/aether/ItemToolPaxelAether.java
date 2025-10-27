package luke.paxels.compat.aether;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import teamport.aether.blocks.AetherBlockTags;

import static teamport.aether.items.itemtool.ItemToolPickaxeAether.miningLevels;


public class ItemToolPaxelAether extends ItemTool {

	public ItemToolPaxelAether(String name, String namespaceId, int id, ToolMaterial toolMaterial) {
		super(name, namespaceId, id, 3, toolMaterial, null);
		this.setMaxDamage(toolMaterial.getDurability() * 2);
	}

	public float getStrVsBlock(ItemStack itemstack, Block<?> block) {
		return block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE) || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_AXE) || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_SHOVEL) ? this.material.getEfficiency(false) : 1.0F;
	}

	public boolean canHarvestBlock(Mob mob, ItemStack itemStack, Block<?> block) {
		Integer miningLevel = miningLevels.get(block);
		if (miningLevel != null) {
			return this.material.getMiningLevel() >= miningLevel;
		} else {
			return block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE) || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_AXE) || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_SHOVEL);
		}
	}
}
