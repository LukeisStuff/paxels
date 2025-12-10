package luke.paxels.compat.aether;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.EnvironmentHelper;

import static teamport.aether.item.AetherItems.AMBROSIUM;

public class ItemToolPaxelHolystone extends ItemToolPaxelAether {

	public ItemToolPaxelHolystone(String name, String namespaceId, int id, ToolMaterial toolMaterial) {
		super(name, namespaceId, id, 3, toolMaterial, null);
	}

	@Override
	public boolean onBlockDestroyed(World world, ItemStack itemstack, int i, int x, int y, int z, Side side, Mob mob) {
		Block<?> block = Blocks.blocksList[i];
		if (block != null && (block.getHardness() > 0.0F || this.isSilkTouch())) {
			itemstack.damageItem(1, mob);
		}
		if (!EnvironmentHelper.isClientWorld() && itemRand.nextInt(16) == 0 && block.getHardness() > 0.0F) {
			world.dropItem(x, y, z, new ItemStack(AMBROSIUM, 1));
		}
		return true;
	}

}
