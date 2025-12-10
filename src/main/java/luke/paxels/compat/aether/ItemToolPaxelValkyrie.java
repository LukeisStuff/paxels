package luke.paxels.compat.aether;

import luke.paxels.compat.aether.mixin.AetherPickaxeAccessor;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLog;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.gamerule.GameRules;
import net.minecraft.core.data.gamerule.TreecapitatorHelper;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import redart15.commandly.veincapitator.VeinMining;
import teamport.aether.AetherMod;
import teamport.aether.block.AetherBlockTags;
import teamport.aether.compat.commandly.AetherCommandlyRules;
import teamport.aether.entity.player.PlayerUntil;
import teamport.aether.item.AetherHasCustomDamageType;

public class ItemToolPaxelValkyrie extends ItemToolPaxelAether implements AetherHasCustomDamageType {

	public ItemToolPaxelValkyrie(String name, String namespaceId, int id, ToolMaterial toolMaterial) {
		super(name, namespaceId, id, toolMaterial);
	}

    @Override
	public float getStrVsBlock(ItemStack itemstack, Block<?> block) {
		return block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE) || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_AXE) || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_SHOVEL)
			|| block.hasTag(BlockTags.MINEABLE_BY_AXE) || block.hasTag(BlockTags.MINEABLE_BY_SHOVEL) || block.hasTag(BlockTags.MINEABLE_BY_PICKAXE) || block.hasTag(BlockTags.MINEABLE_BY_HOE)
			? this.material.getEfficiency(false) : 1.0F;
	}

    @Override
    public boolean canHarvestBlock(Mob mob, ItemStack itemStack, Block<?> block) {
        Integer miningLevel = AetherPickaxeAccessor.getMiningLevels().get(block);

        if (miningLevel != null) {
            return this.material.getMiningLevel() >= miningLevel;
        } else {
            return block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE)
                || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_AXE)
                || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_SHOVEL)
                || block.hasTag(BlockTags.MINEABLE_BY_PICKAXE)
                || block.hasTag(BlockTags.MINEABLE_BY_AXE)
                || block.hasTag(BlockTags.MINEABLE_BY_SHOVEL);
        }
    }

    @Override
    public boolean beforeDestroyBlock(World world, ItemStack itemStack, int blockId, int x, int y, int z, Side side, Player player) {
        if (!world.isClientSide && world.getGameRuleValue(GameRules.TREECAPITATOR) && !player.isSneaking()) {
            int id = world.getBlockId(x, y, z);
            if (Block.hasLogicClass(Blocks.getBlock(id), BlockLogicLog.class)) {
                return !(new TreecapitatorHelper(world, x, y, z, player)).chopTree();
            }
        }
        if (!world.isClientSide && AetherCommandlyRules.canVeinMine(world) && !player.isSneaking()) {
            return !VeinMining
                .veinMining(world, itemStack, x, y, z, player)
                .setDropCause(PlayerUntil.isSilkTouch(player) ? EnumDropCause.SILK_TOUCH : EnumDropCause.PROPER_TOOL)
                .setMiningTags(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE, BlockTags.MINEABLE_BY_PICKAXE)
                .mine(blockId, side);
        }

        return true;
    }

	@Override
	public DamageType getDamageType() {
		return AetherMod.HOLY;
	}
}
