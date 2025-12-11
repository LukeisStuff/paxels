package luke.paxels;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static luke.paxels.PaxelMod.MOD_ID;

public class PaxelRecipes implements RecipeEntrypoint {

    @Override
    public void onRecipesReady() {
        RecipeBuilderShaped paxelTemplate = new RecipeBuilderShaped(MOD_ID, "A5P", " S ", " S ");
        paxelTemplate
            .addInput('A', Items.TOOL_AXE_WOOD)
            .addInput('5', Items.TOOL_SHOVEL_WOOD)
            .addInput('P', Items.TOOL_PICKAXE_WOOD)
            .addInput('S', Items.STICK)
            .create("wood_paxel", new ItemStack(PaxelItems.TOOL_PAXEL_WOOD));

        paxelTemplate
            .addInput('A', Items.TOOL_AXE_STONE)
            .addInput('5', Items.TOOL_SHOVEL_STONE)
            .addInput('P', Items.TOOL_PICKAXE_STONE)
            .addInput('S', Items.STICK)
            .create("stone_paxel", new ItemStack(PaxelItems.TOOL_PAXEL_STONE));

        paxelTemplate
            .addInput('A', Items.TOOL_AXE_IRON)
            .addInput('5', Items.TOOL_SHOVEL_IRON)
            .addInput('P', Items.TOOL_PICKAXE_IRON)
            .addInput('S', Items.STICK)
            .create("iron_paxel", new ItemStack(PaxelItems.TOOL_PAXEL_IRON));

        paxelTemplate
            .addInput('A', Items.TOOL_AXE_GOLD)
            .addInput('5', Items.TOOL_SHOVEL_GOLD)
            .addInput('P', Items.TOOL_PICKAXE_GOLD)
            .addInput('S', Items.STICK)
            .create("gold_paxel", new ItemStack(PaxelItems.TOOL_PAXEL_GOLD));

        paxelTemplate
            .addInput('A', Items.TOOL_AXE_DIAMOND)
            .addInput('5', Items.TOOL_SHOVEL_DIAMOND)
            .addInput('P', Items.TOOL_PICKAXE_DIAMOND)
            .addInput('S', Items.STICK)
            .create("diamond_paxel", new ItemStack(PaxelItems.TOOL_PAXEL_DIAMOND));

        paxelTemplate
            .addInput('A', Items.TOOL_AXE_STEEL)
            .addInput('5', Items.TOOL_SHOVEL_STEEL)
            .addInput('P', Items.TOOL_PICKAXE_STEEL)
            .addInput('S', Items.STICK)
            .create("steel_paxel", new ItemStack(PaxelItems.TOOL_PAXEL_STEEL));

    }

    @Override
    public void initNamespaces() {
        RecipeBuilder.initNameSpace(MOD_ID);

        Registries.ITEM_GROUPS.register("paxels:tool_paxels", Registries.stackListOf(
            PaxelItems.TOOL_PAXEL_WOOD,
            PaxelItems.TOOL_PAXEL_STONE,
            PaxelItems.TOOL_PAXEL_IRON,
            PaxelItems.TOOL_PAXEL_GOLD,
            PaxelItems.TOOL_PAXEL_DIAMOND,
            PaxelItems.TOOL_PAXEL_STEEL));
    }
}
