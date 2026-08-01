package luke.paxels.compat.commandly;

import luke.paxels.PaxelItems;
import net.minecraft.core.item.material.ToolMaterial;
import redart15.commandly.api.CommandlyPlugin;
import redart15.commandly.veincapitator.OreGroups;
import redart15.commandly.veincapitator.PickAxeRegister;

public class PaxelCommandlyPlugin implements CommandlyPlugin {

    @Override
    public void registerOreGroups(OreGroups oreGroups) {
        /* no need */
    }

    @Override
    public void registerPickaxe(PickAxeRegister register) {
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_WOOD,    ToolMaterial.wood);
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_STONE,   ToolMaterial.stone);
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_IRON,    ToolMaterial.iron);
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_GOLD,    ToolMaterial.gold);
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_DIAMOND, ToolMaterial.diamond);
        PickAxeRegister.register(PaxelItems.TOOL_PAXEL_STEEL,   ToolMaterial.steel);
    }
}
