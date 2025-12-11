package luke.paxels;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tag.ItemTags;
import turniplabs.halplibe.helper.ItemBuilder;

import static luke.paxels.PaxelMod.MOD_ID;

public final class PaxelItems {
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
            .build(new ItemToolPaxel("tool.paxel.wood", itemKey("tool_paxel_wood"), 20000, 3, ToolMaterial.wood, null));

        TOOL_PAXEL_STONE = new ItemBuilder(MOD_ID)
            .build(new ItemToolPaxel("tool.paxel.stone", itemKey("tool_paxel_stone"), 20001, 3, ToolMaterial.stone, null));

        TOOL_PAXEL_IRON = new ItemBuilder(MOD_ID)
            .build(new ItemToolPaxel("tool.paxel.iron", itemKey("tool_paxel_iron"), 20002, 3, ToolMaterial.iron, null));

        TOOL_PAXEL_GOLD = new ItemBuilder(MOD_ID)
            .setTags(ItemTags.IS_SILK_TOUCH)
            .build(new ItemToolPaxel("tool.paxel.gold", itemKey("tool_paxel_gold"), 20003, 3, ToolMaterial.gold, null));

        TOOL_PAXEL_DIAMOND = new ItemBuilder(MOD_ID)
            .build(new ItemToolPaxel("tool.paxel.diamond", itemKey("tool_paxel_diamond"), 20004, 3, ToolMaterial.diamond, null));

        TOOL_PAXEL_STEEL = new ItemBuilder(MOD_ID)
            .build(new ItemToolPaxel("tool.paxel.steel", itemKey("tool_paxel_steel"), 20005, 3, ToolMaterial.steel, null));
    }

}
