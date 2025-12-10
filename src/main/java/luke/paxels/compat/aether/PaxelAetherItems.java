package luke.paxels.compat.aether;

import net.minecraft.core.item.Item;
import teamport.aether.item.item_tool.AetherToolMaterial;
import turniplabs.halplibe.helper.ItemBuilder;

import static luke.paxels.PaxelMod.MOD_ID;

public final class PaxelAetherItems {
	public static Item TOOL_PAXEL_SKYROOT;
	public static Item TOOL_PAXEL_HOLYSTONE;
	public static Item TOOL_PAXEL_ZANITE;
	public static Item TOOL_PAXEL_GRAVITITE;
	public static Item TOOL_PAXEL_VALKYRIE;

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
		TOOL_PAXEL_SKYROOT = new ItemBuilder(MOD_ID)
			.build(new ItemToolPaxelAether("tool.paxel.skyroot", itemKey("tool_paxel_skyroot"), 20005, AetherToolMaterial.SKYROOT));

		TOOL_PAXEL_HOLYSTONE = new ItemBuilder(MOD_ID)
			.build(new ItemToolPaxelHolystone("tool.paxel.holystone", itemKey("tool_paxel_holystone"), 20006, AetherToolMaterial.HOLYSTONE));

		TOOL_PAXEL_ZANITE = new ItemBuilder(MOD_ID)
			.build(new ItemToolPaxelZanite("tool.paxel.zanite", itemKey("tool_paxel_zanite"), 20007, AetherToolMaterial.ZANITE));

		TOOL_PAXEL_GRAVITITE = new ItemBuilder(MOD_ID)
			.build(new ItemToolPaxelGravitite("tool.paxel.gravitite", itemKey("tool_paxel_gravitite"), 20008, AetherToolMaterial.GRAVITITE));

		TOOL_PAXEL_VALKYRIE = new ItemBuilder(MOD_ID)
			.build(new ItemToolPaxelValkyrie("tool.paxel.valkyrie", itemKey("tool_paxel_valkyrie"), 20009, AetherToolMaterial.VALKYRIE));
	}

}
