package luke.paxels.compat.commandly;

import luke.paxels.PaxelItems;
import luke.paxels.compat.aether.PaxelAetherItems;
import net.minecraft.core.item.material.ToolMaterial;
import redart15.commandly.api.CommandlyPlugin;
import redart15.commandly.veincapitator.OreGroups;
import redart15.commandly.veincapitator.PickAxeRegister;
import teamport.aether.item.item_tool.AetherToolMaterial;

import static luke.paxels.compat.aether.PaxelAetherCompatibility.IS_AETHER_LOADED;

public class PaxelCommandlyPlugin implements CommandlyPlugin {

    @Override
    public void registerOreGroups(OreGroups oreGroups) {
    }

    @Override
    public void registerPickaxe(PickAxeRegister register) {
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_WOOD, ToolMaterial.wood);
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_STONE, ToolMaterial.stone);
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_IRON, ToolMaterial.iron);
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_GOLD, ToolMaterial.gold);
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_DIAMOND, ToolMaterial.diamond);
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_STEEL, ToolMaterial.steel);

        if (IS_AETHER_LOADED) {
            PickAxeRegister.register(PaxelAetherItems.TOOL_PAXEL_SKYROOT, AetherToolMaterial.SKYROOT);
            PickAxeRegister.register(PaxelAetherItems.TOOL_PAXEL_HOLYSTONE, AetherToolMaterial.HOLYSTONE);
            PickAxeRegister.register(PaxelAetherItems.TOOL_PAXEL_ZANITE, AetherToolMaterial.ZANITE);
            PickAxeRegister.register(PaxelAetherItems.TOOL_PAXEL_GRAVITITE, AetherToolMaterial.GRAVITITE);
            PickAxeRegister.register(PaxelAetherItems.TOOL_PAXEL_VALKYRIE, AetherToolMaterial.VALKYRIE);
        }
    }
}
