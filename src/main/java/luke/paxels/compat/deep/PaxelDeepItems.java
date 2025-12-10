package luke.paxels.compat.deep;

import luke.paxels.ItemToolPaxel;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.material.ToolMaterial;
import turniplabs.halplibe.helper.ItemBuilder;

import static luke.paxels.PaxelMod.MOD_ID;

public final class PaxelDeepItems {
    public static Item TOOL_PAXEL_AMETHYST;
    public static Item TOOL_PAXEL_LEAD;
    public static Item TOOL_PAXEL_SILVER;

    public static final ToolMaterial amethyst = (new ToolMaterial()).setDurability(96).setEfficiency(55.0F, 100.0F).setMiningLevel(3).setDamage(5).setBlockHitDelay(0);
    public static final ToolMaterial lead = (new ToolMaterial()).setDurability(144).setEfficiency(8.0F, 10.0F).setMiningLevel(2);
    public static final ToolMaterial silver = (new ToolMaterial()).setDurability(512).setEfficiency(4.0F, 9.0F).setMiningLevel(2).setSilkTouch(true);

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
        TOOL_PAXEL_AMETHYST = new ItemBuilder(MOD_ID)
            .build(new ItemToolPaxel("tool.paxel.amethyst", itemKey("tool_paxel_amethyst"), 20010, 3, amethyst, null));

        TOOL_PAXEL_LEAD = new ItemBuilder(MOD_ID)
            .build(new ItemToolPaxel("tool.paxel.lead", itemKey("tool_paxel_lead"), 20011, 3, lead, null));

        TOOL_PAXEL_SILVER = new ItemBuilder(MOD_ID)
            .build(new ItemToolPaxel("tool.paxel.silver", itemKey("tool_paxel_silver"), 20012, 3, silver, null));
    }

}
