package luke.paxels.compat.aether;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.ItemStack;
import teamport.aether.items.AetherItems;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.paxels.PaxelMod.MOD_ID;

public class PaxelAetherRecipes implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {
		RecipeBuilderShaped paxelTemplate = new RecipeBuilderShaped(MOD_ID, "A5P", " S ", " S ");
		paxelTemplate
			.addInput('A', AetherItems.TOOL_AXE_SKYROOT)
			.addInput('5', AetherItems.TOOL_SHOVEL_SKYROOT)
			.addInput('P', AetherItems.TOOL_PICKAXE_SKYROOT)
			.addInput('S', AetherItems.STICK_SKYROOT)
			.create("skyroot_paxel", new ItemStack(PaxelAetherItems.TOOL_PAXEL_SKYROOT));

		paxelTemplate
			.addInput('A', AetherItems.TOOL_AXE_HOLYSTONE)
			.addInput('5', AetherItems.TOOL_SHOVEL_HOLYSTONE)
			.addInput('P', AetherItems.TOOL_PICKAXE_HOLYSTONE)
			.addInput('S', AetherItems.STICK_SKYROOT)
			.create("holystone_paxel", new ItemStack(PaxelAetherItems.TOOL_PAXEL_HOLYSTONE));

		paxelTemplate
			.addInput('A', AetherItems.TOOL_AXE_ZANITE)
			.addInput('5', AetherItems.TOOL_SHOVEL_ZANITE)
			.addInput('P', AetherItems.TOOL_PICKAXE_ZANITE)
			.addInput('S', AetherItems.STICK_SKYROOT)
			.create("zanite_paxel", new ItemStack(PaxelAetherItems.TOOL_PAXEL_ZANITE));

		paxelTemplate
			.addInput('A', AetherItems.TOOL_AXE_GRAVITITE)
			.addInput('5', AetherItems.TOOL_SHOVEL_GRAVITITE)
			.addInput('P', AetherItems.TOOL_PICKAXE_GRAVITITE)
			.addInput('S', AetherItems.STICK_SKYROOT)
			.create("gravitite_paxel", new ItemStack(PaxelAetherItems.TOOL_PAXEL_GRAVITITE));

		paxelTemplate
			.addInput('A', AetherItems.TOOL_AXE_VALKYRIE)
			.addInput('5', AetherItems.TOOL_SHOVEL_VALKYRIE)
			.addInput('P', AetherItems.TOOL_PICKAXE_VALKYRIE)
			.addInput('S', AetherItems.STICK_SKYROOT)
			.create("valkyrie_paxel", new ItemStack(PaxelAetherItems.TOOL_PAXEL_VALKYRIE));
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);

		Registries.ITEM_GROUPS.getItem("paxels:tool_paxels").add(PaxelAetherItems.TOOL_PAXEL_SKYROOT.getDefaultStack());
		Registries.ITEM_GROUPS.getItem("paxels:tool_paxels").add(PaxelAetherItems.TOOL_PAXEL_HOLYSTONE.getDefaultStack());
		Registries.ITEM_GROUPS.getItem("paxels:tool_paxels").add(PaxelAetherItems.TOOL_PAXEL_ZANITE.getDefaultStack());
		Registries.ITEM_GROUPS.getItem("paxels:tool_paxels").add(PaxelAetherItems.TOOL_PAXEL_GRAVITITE.getDefaultStack());
		Registries.ITEM_GROUPS.getItem("paxels:tool_paxels").add(PaxelAetherItems.TOOL_PAXEL_VALKYRIE.getDefaultStack());
	}
}
