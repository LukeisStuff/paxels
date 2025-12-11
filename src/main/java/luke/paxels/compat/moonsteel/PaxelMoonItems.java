package luke.paxels.compat.moonsteel;

import luke.paxels.ItemToolPaxel;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;
import useless.moonsteel.MoonSteelItems;

import static luke.paxels.PaxelMod.MOD_ID;

public final class PaxelMoonItems {
    public static Item TOOL_PAXEL_MOONSTEEL;

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
        TOOL_PAXEL_MOONSTEEL = new ItemBuilder(MOD_ID)
            .build(new ItemToolPaxel("tool.paxel.moonsteel", itemKey("tool_paxel_moonsteel"), 20020, 3, MoonSteelItems.moonSteelTool, null));
    }

}
