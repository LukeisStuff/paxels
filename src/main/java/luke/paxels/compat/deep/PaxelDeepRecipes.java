package luke.paxels.compat.deep;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import teamport.aether.items.AetherItems;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.paxels.PaxelMod.MOD_ID;

public class PaxelDeepRecipes implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {
		RecipeBuilderShaped paxelTemplate = new RecipeBuilderShaped(MOD_ID, "A5P", " S ", " S ");
		paxelTemplate
			.addInput('A', Items.STRING)
			.addInput('5', Items.STRING)
			.addInput('P', Items.STRING)
			.addInput('S', AetherItems.STICK_SKYROOT)
			.create("amethyst_paxel", new ItemStack(PaxelDeepItems.TOOL_PAXEL_AMETHYST));

		paxelTemplate
			.addInput('A', Items.STRING)
			.addInput('5', Items.STRING)
			.addInput('P', Items.STRING)
			.addInput('S', AetherItems.STICK_SKYROOT)
			.create("lead_paxel", new ItemStack(PaxelDeepItems.TOOL_PAXEL_LEAD));

		paxelTemplate
			.addInput('A', Items.STRING)
			.addInput('5', Items.STRING)
			.addInput('P', Items.STRING)
			.addInput('S', AetherItems.STICK_SKYROOT)
			.create("silver_paxel", new ItemStack(PaxelDeepItems.TOOL_PAXEL_SILVER));
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);

		Registries.ITEM_GROUPS.getItem("paxels:tool_paxels").add(PaxelDeepItems.TOOL_PAXEL_AMETHYST.getDefaultStack());
		Registries.ITEM_GROUPS.getItem("paxels:tool_paxels").add(PaxelDeepItems.TOOL_PAXEL_LEAD.getDefaultStack());
		Registries.ITEM_GROUPS.getItem("paxels:tool_paxels").add(PaxelDeepItems.TOOL_PAXEL_SILVER.getDefaultStack());
	}
}
