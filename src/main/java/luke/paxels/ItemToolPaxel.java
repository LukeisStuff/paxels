package luke.paxels;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLog;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.gamerule.GameRules;
import net.minecraft.core.data.gamerule.TreecapitatorHelper;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import redart15.commandly.veincapitator.VeinMining;
import teamport.aether.block.AetherBlocks;
import teamport.aether.compat.commandly.AetherCommandlyRules;
import teamport.aether.entity.player.PlayerUntil;

import java.util.Random;

import static luke.paxels.compat.aether.PaxelAetherCompatibility.IS_AETHER_LOADED;

public class ItemToolPaxel extends ItemToolPickaxe {


    public ItemToolPaxel(String name, String namespaceId, int id, int damageDealt, ToolMaterial toolMaterial, Tag<Block<?>> tagEffectiveAgainst) {
        super(name, namespaceId, id, toolMaterial);
        this.setMaxDamage(toolMaterial.getDurability() * 2);
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
                .setMiningTags(BlockTags.MINEABLE_BY_PICKAXE)
                .mine(blockId, side);
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
            world.playBlockSoundEffect(entityplayer, blockX + 0.5F, blockY + 0.5F, blockZ + 0.5F, Blocks.blocksList[blockId], EnumBlockSoundEffectType.PLACE);
            if (!world.isClientSide) {
                world.setBlockWithNotify(blockX, blockY, blockZ, Blocks.PATH_DIRT.id());
                itemstack.damageItem(1, entityplayer);
            }
            return true;
        }
        if (IS_AETHER_LOADED) {
            if (side != Side.BOTTOM && blockAbove == 0 && (blockId == AetherBlocks.GRASS_AETHER.id() || blockId == AetherBlocks.DIRT_AETHER.id())) {
                world.playBlockSoundEffect(entityplayer, blockX + 0.5F, blockY + 0.5F, blockZ + 0.5F, Blocks.blocksList[blockId], EnumBlockSoundEffectType.PLACE);
                if (!world.isClientSide) {
                    world.setBlockWithNotify(blockX, blockY, blockZ, AetherBlocks.PATH_DIRT_AETHER.id());
                    itemstack.damageItem(1, entityplayer);
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void onUseByActivator(ItemStack itemStack, TileEntityActivator activatorBlock, World world, Random random, int blockX, int blockY, int blockZ, double offX, double offY, double offZ, Direction direction) {
        this.shovelBlock(itemStack, null, world, blockX + direction.getOffsetX(), blockY + direction.getOffsetY(), blockZ + direction.getOffsetZ(), direction.getSide());
    }

}
