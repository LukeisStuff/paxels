package luke.paxels.compat.aether;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLog;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.data.gamerule.GameRules;
import net.minecraft.core.data.gamerule.TreecapitatorHelper;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import teamport.aether.blocks.AetherBlockTags;
import teamport.aether.blocks.AetherBlocks;

import java.util.Random;

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


	public boolean beforeDestroyBlock(World world, ItemStack itemStack, int blockId, int x, int y, int z, Side side, Player player) {
		if (!world.isClientSide && world.getGameRuleValue(GameRules.TREECAPITATOR) && !player.isSneaking()) {
			int id = world.getBlockId(x, y, z);
			if (Block.hasLogicClass(Blocks.getBlock(id), BlockLogicLog.class)) {
				return !(new TreecapitatorHelper(world, x, y, z, player)).chopTree();
			}
		}

		return true;
	}

	public boolean onUseItemOnBlock(ItemStack itemstack, Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		return this.shovelBlock(itemstack, player, world, blockX, blockY, blockZ, side);
	}

	public boolean shovelBlock(ItemStack itemstack, @Nullable Player entityplayer, World world, int blockX, int blockY, int blockZ, Side side) {
		int blockId = world.getBlockId(blockX, blockY, blockZ);
		int blockAbove = world.getBlockId(blockX, blockY + 1, blockZ);
		if (side != Side.BOTTOM && blockAbove == 0 && (blockId == Blocks.GRASS.id() || blockId == Blocks.DIRT.id() || blockId == Blocks.GRASS_RETRO.id() || blockId == Blocks.FARMLAND_DIRT.id())) {
			world.playBlockSoundEffect(entityplayer, (float) blockX + 0.5F, (float) blockY + 0.5F, (float) blockZ + 0.5F, Blocks.blocksList[blockId], EnumBlockSoundEffectType.PLACE);
			if (!world.isClientSide) {
				world.setBlockWithNotify(blockX, blockY, blockZ, Blocks.PATH_DIRT.id());
				itemstack.damageItem(1, entityplayer);
			}
			return true;
		}
		if (side != Side.BOTTOM && blockAbove == 0 && (blockId == AetherBlocks.GRASS_AETHER.id() || blockId == AetherBlocks.DIRT_AETHER.id())) {
			world.playBlockSoundEffect(entityplayer, (float) blockX + 0.5F, (float) blockY + 0.5F, (float) blockZ + 0.5F, Blocks.blocksList[blockId], EnumBlockSoundEffectType.PLACE);
			if (!world.isClientSide) {
				world.setBlockWithNotify(blockX, blockY, blockZ, AetherBlocks.PATH_DIRT_AETHER.id());
				itemstack.damageItem(1, entityplayer);
			}
			return true;
		} else {
			return false;
		}
	}

	public void onUseByActivator(ItemStack itemStack, TileEntityActivator activatorBlock, World world, Random random, int blockX, int blockY, int blockZ, double offX, double offY, double offZ, Direction direction) {
		this.shovelBlock(itemStack, null, world, blockX + direction.getOffsetX(), blockY + direction.getOffsetY(), blockZ + direction.getOffsetZ(), direction.getSide());
	}

}
