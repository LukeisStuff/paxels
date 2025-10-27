package luke.paxels.compat.aether;

import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.util.helper.DamageType;
import teamport.aether.AetherMod;
import teamport.aether.blocks.AetherBlockTags;
import teamport.aether.items.AetherHasCustomDamageType;

public class ItemToolPaxelValkyrie extends ItemToolPaxelAether implements AetherHasCustomDamageType {

	public ItemToolPaxelValkyrie(String name, String namespaceId, int id, ToolMaterial toolMaterial) {
		super(name, namespaceId, id, toolMaterial);
	}

	@Override
	public float getStrVsBlock(ItemStack itemstack, Block<?> block) {
		if (!block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_AXE))
			return Items.TOOL_AXE_DIAMOND.getStrVsBlock(itemstack, block);
		if (!block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE))
			return Items.TOOL_AXE_DIAMOND.getStrVsBlock(itemstack, block);
		if (!block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_SHOVEL))
			return Items.TOOL_AXE_DIAMOND.getStrVsBlock(itemstack, block);
		return this.material.getEfficiency(false);
	}

	@Override
	public DamageType getDamageType() {
		return AetherMod.HOLY;
	}
}
