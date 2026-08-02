package luke.paxels;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tag.ItemTags;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

import static luke.paxels.PaxelMod.MOD_ID;

@SuppressWarnings({"java:S1104", "java:S1444", "java:S3008" })
public final class PaxelItems {
    private PaxelItems(){}
    public static Item TOOL_PAXEL_WOOD;
    public static Item TOOL_PAXEL_STONE;
    public static Item TOOL_PAXEL_IRON;
    public static Item TOOL_PAXEL_GOLD;
    public static Item TOOL_PAXEL_DIAMOND;
    public static Item TOOL_PAXEL_STEEL;


    private static boolean hasInit = false;

    public static void init() {
        if (!hasInit) {
            hasInit = true;
            initializeItems();
        }
    }

    public static String itemKey(String string) {
        return MOD_ID + ":item/" + string;
    }

    public static void initializeItems() {
        TOOL_PAXEL_WOOD = new ItemBuilder(MOD_ID)
            .setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_WOOD))
            .build(new ItemToolPaxel("tool.paxel.wood", itemKey("tool_paxel_wood"), 20000, ToolMaterial.wood));

        TOOL_PAXEL_STONE = new ItemBuilder(MOD_ID)
            .setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_STONE))
            .build(new ItemToolPaxel("tool.paxel.stone", itemKey("tool_paxel_stone"), 20001,ToolMaterial.stone));

        TOOL_PAXEL_IRON = new ItemBuilder(MOD_ID)
            .setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_IRON))
            .build(new ItemToolPaxel("tool.paxel.iron", itemKey("tool_paxel_iron"), 20002, ToolMaterial.iron));

        TOOL_PAXEL_GOLD = new ItemBuilder(MOD_ID)
            .setTags(ItemTags.IS_SILK_TOUCH)
            .setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_GOLD))
            .build(new ItemToolPaxel("tool.paxel.gold", itemKey("tool_paxel_gold"), 20003, ToolMaterial.gold));

        TOOL_PAXEL_DIAMOND = new ItemBuilder(MOD_ID)
            .setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_DIAMOND))
            .build(new ItemToolPaxel("tool.paxel.diamond", itemKey("tool_paxel_diamond"), 20004, ToolMaterial.diamond));

        TOOL_PAXEL_STEEL = new ItemBuilder(MOD_ID)
            .setCreativeInventoryPlacement(new CreativeInventoryPlacement.After(() -> Items.TOOL_SWORD_STEEL))
            .build(new ItemToolPaxel("tool.paxel.steel", itemKey("tool_paxel_steel"), 20005, ToolMaterial.steel));
    }

}
