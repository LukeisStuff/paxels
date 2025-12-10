package luke.paxels.compat.aether;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import teamport.aether.block.AetherBlockTags;
import teamport.aether.entity.floating_block.EntityFloatingBlock;
import teamport.aether.item.AetherHasCustomDamageType;
import turniplabs.halplibe.helper.EnvironmentHelper;

public class ItemToolPaxelGravitite extends ItemToolPaxelAether implements AetherHasCustomDamageType {

	public ItemToolPaxelGravitite(String name, String namespaceId, int id, ToolMaterial toolMaterial) {
		super(name, namespaceId, id, 3, toolMaterial, null);
	}

	@Override
	public boolean onUseItemOnBlock(
		ItemStack itemstack,
		Player player,
		World world,
		int blockX, int blockY, int blockZ,
		Side side,
		double xPlaced, double yPlaced
	) {
		Block<?> block = world.getBlock(blockX, blockY, blockZ);
		Block<?> nextBlock = world.getBlock(blockX, blockY + 1, blockZ);
		if (block == null
			|| !player.isSneaking()
			|| block.getHardness() < 0
			|| (nextBlock != null
			&& nextBlock.id() != Blocks.COBWEB.id()
			&& !nextBlock.hasTag(BlockTags.PLACE_OVERWRITES))
			|| (!block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE)
			&& !block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_AXE)
			&& !block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_SHOVEL))) {
			return false;
		}

		if (EnvironmentHelper.isClientWorld()) {
			return true;
		}

		@Nullable TileEntity tileEntity = world.getTileEntity(blockX, blockY, blockZ);
		int metadata = world.getBlockMetadata(blockX, blockY, blockZ);
		world.removeBlockTileEntity(blockX, blockY, blockZ);
		world.setBlockWithNotify(blockX, blockY, blockZ, 0);
		EntityFloatingBlock entityFloatingBlock = new EntityFloatingBlock(
			world,
			(double) blockX + 0.5F, (double) blockY + 0.5F, (double) blockZ + 0.5F,
			block.id(), metadata, tileEntity);
		entityFloatingBlock.setHasRemovedBlock(true);
		world.entityJoinedWorld(entityFloatingBlock);
		itemstack.damageItem(1, player);
		return true;
	}

	@Override
	public DamageType getDamageType() {
		return DamageType.FALL;
	}
}
