package luke.paxels.compat.aether;

import luke.paxels.compat.aether.mixin.AetherPickaxeAccessor;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLog;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityActivator;
import net.minecraft.core.data.gamerule.GameRules;
import net.minecraft.core.data.gamerule.TreecapitatorHelper;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import redart15.commandly.veincapitator.VeinMining;
import teamport.aether.block.AetherBlockTags;
import teamport.aether.block.AetherBlocks;
import teamport.aether.compat.commandly.AetherCommandlyRules;
import teamport.aether.entity.player.PlayerUntil;
import teamport.aether.item.item_tool.ItemToolPickaxeAether;

import java.util.Random;


public class ItemToolPaxelAether extends ItemToolPickaxeAether {

    public ItemToolPaxelAether(String name, String namespaceId, int id, int damageDealt, ToolMaterial toolMaterial, Tag<Block<?>> tagEffectiveAgainst) {
        super(name, namespaceId, id, toolMaterial);
        this.setMaxDamage(toolMaterial.getDurability() * 2);
    }

    @Override
    public float getStrVsBlock(ItemStack itemstack, Block<?> block) {
        return block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE) || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_AXE) || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_SHOVEL) ? this.material.getEfficiency(false) : 1.0F;
    }

    @Override
    public boolean canHarvestBlock(Mob mob, ItemStack itemStack, Block<?> block) {
        Integer miningLevel = AetherPickaxeAccessor.getMiningLevels().get(block);

        if (miningLevel != null) {
            return this.material.getMiningLevel() >= miningLevel;
        } else {
            return block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE)
                || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_AXE)
                || block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_SHOVEL);
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
                .setMiningTags(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE)
                .mine(blockId, side);
        }

        return true;
    }

    @Override
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

    @Override
    public void onUseByActivator(ItemStack itemStack, TileEntityActivator activatorBlock, World world, Random random, int blockX, int blockY, int blockZ, double offX, double offY, double offZ, Direction direction) {
        this.shovelBlock(itemStack, null, world, blockX + direction.getOffsetX(), blockY + direction.getOffsetY(), blockZ + direction.getOffsetZ(), direction.getSide());
    }

}
