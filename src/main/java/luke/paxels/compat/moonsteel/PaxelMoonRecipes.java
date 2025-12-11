package luke.paxels.compat.moonsteel;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;
import useless.moonsteel.MoonSteelItems;

import static luke.paxels.PaxelMod.MOD_ID;

public class PaxelMoonRecipes implements RecipeEntrypoint {
    @Override
    public void onRecipesReady() {
        RecipeBuilderShaped paxelTemplate = new RecipeBuilderShaped(MOD_ID, "A5P", " S ", " S ");
        paxelTemplate
            .addInput('A', MoonSteelItems.TOOL_AXE_MOONSTEEL)
            .addInput('5', MoonSteelItems.TOOL_SHOVEL_MOONSTEEL)
            .addInput('P', MoonSteelItems.TOOL_PICKAXE_MOONSTEEL)
            .addInput('S', Items.STICK)
            .create("moonsteel_paxel", new ItemStack(PaxelMoonItems.TOOL_PAXEL_MOONSTEEL));
    }

    @Override
    public void initNamespaces() {
        RecipeBuilder.initNameSpace(MOD_ID);

        Registries.ITEM_GROUPS.getItem("paxels:tool_paxels").add(PaxelMoonItems.TOOL_PAXEL_MOONSTEEL.getDefaultStack());
    }
}
