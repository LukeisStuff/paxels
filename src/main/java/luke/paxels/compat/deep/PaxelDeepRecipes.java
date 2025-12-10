package luke.paxels.compat.deep;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import silveon22.deep.item.DEEPItems;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.paxels.PaxelMod.MOD_ID;

public class PaxelDeepRecipes implements RecipeEntrypoint {
    @Override
    public void onRecipesReady() {
        RecipeBuilderShaped paxelTemplate = new RecipeBuilderShaped(MOD_ID, "A5P", " S ", " S ");
        paxelTemplate
            .addInput('A', DEEPItems.amethystAxe)
            .addInput('5', DEEPItems.amethystShovel)
            .addInput('P', DEEPItems.amethystPickaxe)
            .addInput('S', Items.STICK)
            .create("amethyst_paxel", new ItemStack(PaxelDeepItems.TOOL_PAXEL_AMETHYST));

        paxelTemplate
            .addInput('A', DEEPItems.leadAxe)
            .addInput('5', DEEPItems.leadShovel)
            .addInput('P', DEEPItems.leadPickaxe)
            .addInput('S', Items.STICK)
            .create("lead_paxel", new ItemStack(PaxelDeepItems.TOOL_PAXEL_LEAD));

        paxelTemplate
            .addInput('A', DEEPItems.silverAxe)
            .addInput('5', DEEPItems.silverShovel)
            .addInput('P', DEEPItems.silverPickaxe)
            .addInput('S', Items.STICK)
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
