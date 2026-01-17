package luke.paxels.compat.commandly;

import luke.paxels.PaxelItems;
import luke.paxels.compat.aether.PaxelAetherItems;
import luke.paxels.compat.deep.PaxelDeepItems;
import luke.paxels.compat.moonsteel.PaxelMoonItems;
import net.minecraft.core.item.material.ToolMaterial;
import redart15.commandly.api.CommandlyPlugin;
import redart15.commandly.veincapitator.OreGroups;
import redart15.commandly.veincapitator.PickAxeRegister;
import silveon22.deep.block.DEEPBlocks;
import teamport.aether.item.item_tool.AetherToolMaterial;
import useless.moonsteel.MoonSteelItems;

import static luke.paxels.compat.aether.PaxelAetherCompatibility.IS_AETHER_LOADED;
import static luke.paxels.compat.deep.PaxelDeepCompatibility.IS_DEEP_LOADED;
import static luke.paxels.compat.moonsteel.PaxelMoonCompatibility.IS_MOON_LOADED;

public class PaxelCommandlyPlugin implements CommandlyPlugin {

    @Override
    public void registerOreGroups(OreGroups oreGroups) {
        if (IS_DEEP_LOADED) {
            OreGroups.OreGroupBuilder amethyst = OreGroups.OreGroupBuilder.register("amethyst");
            OreGroups.OreGroupBuilder bismuth = OreGroups.OreGroupBuilder.register("bismuth");
            OreGroups.OreGroupBuilder lead = OreGroups.OreGroupBuilder.register("lead");
            OreGroups.OreGroupBuilder silver = OreGroups.OreGroupBuilder.register("silver");
            OreGroups.OreGroupBuilder uranium = OreGroups.OreGroupBuilder.register("uranium");
            OreGroups.OreGroupBuilder topaz = OreGroups.OreGroupBuilder.register("topaz");
            OreGroups.OreGroupBuilder rhodonite = OreGroups.OreGroupBuilder.register("rhodonite");

            amethyst.addOre(DEEPBlocks.stoneAmethystOre)
                .addOre(DEEPBlocks.basaltAmethystOre)
                .addOre(DEEPBlocks.limestoneAmethystOre)
                .addOre(DEEPBlocks.graniteAmethystOre)
                .addOre(DEEPBlocks.permafrostAmethystOre)
                .addOre(DEEPBlocks.peridotiteAmethystOre)
                .addOre(DEEPBlocks.abyssalriteAmethystOre)
                .addOre(DEEPBlocks.pearlstoneAmethystOre);

            bismuth.addOre(DEEPBlocks.stoneBismuthOre)
                .addOre(DEEPBlocks.basaltBismuthOre)
                .addOre(DEEPBlocks.limestoneBismuthOre)
                .addOre(DEEPBlocks.graniteBismuthOre)
                .addOre(DEEPBlocks.permafrostBismuthOre)
                .addOre(DEEPBlocks.abyssalriteBismuthOre)
                .addOre(DEEPBlocks.pearlstoneBismuthOre)
                .addOre(DEEPBlocks.peridotiteBismuthOre);

            lead.addOre(DEEPBlocks.stoneLeadOre)
                .addOre(DEEPBlocks.basaltLeadOre)
                .addOre(DEEPBlocks.limestoneLeadOre)
                .addOre(DEEPBlocks.graniteLeadOre)
                .addOre(DEEPBlocks.permafrostLeadOre)
                .addOre(DEEPBlocks.peridotiteLeadOre)
                .addOre(DEEPBlocks.abyssalriteLeadOre)
                .addOre(DEEPBlocks.pearlstoneLeadOre);

            silver.addOre(DEEPBlocks.stoneSilverOre)
                .addOre(DEEPBlocks.basaltSilverOre)
                .addOre(DEEPBlocks.limestoneSilverOre)
                .addOre(DEEPBlocks.graniteSilverOre)
                .addOre(DEEPBlocks.permafrostSilverOre)
                .addOre(DEEPBlocks.netherrackSilverOre)
                .addOre(DEEPBlocks.peridotiteSilverOre)
                .addOre(DEEPBlocks.abyssalriteSilverOre)
                .addOre(DEEPBlocks.pearlstoneSilverOre);

            uranium.addOre(DEEPBlocks.stoneUraniumOre)
                .addOre(DEEPBlocks.basaltUraniumOre)
                .addOre(DEEPBlocks.limestoneUraniumOre)
                .addOre(DEEPBlocks.graniteUraniumOre)
                .addOre(DEEPBlocks.permafrostUraniumOre)
                .addOre(DEEPBlocks.peridotiteUraniumOre)
                .addOre(DEEPBlocks.abyssalriteUraniumOre)
                .addOre(DEEPBlocks.pearlstoneUraniumOre);

            topaz.addOre(DEEPBlocks.netherrackTopazOre);

            rhodonite.addOre(DEEPBlocks.netherrackRhodoniteOre);

            OreGroups.OreGroupBuilder.register("coal")
                .addOre(DEEPBlocks.peridotiteCoalOre)
                .addOre(DEEPBlocks.abyssalriteCoalOre)
                .addOre(DEEPBlocks.pearlstoneCoalOre);

            OreGroups.OreGroupBuilder.register("iron")
                .addOre(DEEPBlocks.peridotiteIronOre)
                .addOre(DEEPBlocks.abyssalriteIronOre)
                .addOre(DEEPBlocks.pearlstoneIronOre);

            OreGroups.OreGroupBuilder.register("gold")
                .addOre(DEEPBlocks.peridotiteGoldOre)
                .addOre(DEEPBlocks.abyssalriteGoldOre)
                .addOre(DEEPBlocks.pearlstoneGoldOre);

            OreGroups.OreGroupBuilder.register("diamond")
                .addOre(DEEPBlocks.peridotiteDiamondOre)
                .addOre(DEEPBlocks.abyssalriteDiamondOre)
                .addOre(DEEPBlocks.pearlstoneDiamondOre);

            OreGroups.OreGroupBuilder.register("lapis")
                .addOre(DEEPBlocks.peridotiteLapisOre)
                .addOre(DEEPBlocks.abyssalriteLapisOre)
                .addOre(DEEPBlocks.pearlstoneLapisOre);

            OreGroups.OreGroupBuilder.register("redstone")
                .addOre(DEEPBlocks.peridotiteRedstoneOre)
                .addOre(DEEPBlocks.peridotiteRedstoneGlowingOre)
                .addOre(DEEPBlocks.abyssalriteRedstoneOre)
                .addOre(DEEPBlocks.abyssalriteRedstoneGlowingOre)
                .addOre(DEEPBlocks.pearlstoneRedstoneOre)
                .addOre(DEEPBlocks.pearlstoneRedstoneGlowingOre);
        }

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
            PickAxeRegister.register(PaxelAetherItems.TOOL_PAXEL_SKYROOT, AetherToolMaterial.skyroot);
            PickAxeRegister.register(PaxelAetherItems.TOOL_PAXEL_HOLYSTONE, AetherToolMaterial.holystone);
            PickAxeRegister.register(PaxelAetherItems.TOOL_PAXEL_ZANITE, AetherToolMaterial.zanite);
            PickAxeRegister.register(PaxelAetherItems.TOOL_PAXEL_GRAVITITE, AetherToolMaterial.gravitite);
            PickAxeRegister.register(PaxelAetherItems.TOOL_PAXEL_VALKYRIE, AetherToolMaterial.valkyrie);
        }
        if (IS_DEEP_LOADED) {
            PickAxeRegister.register(PaxelDeepItems.TOOL_PAXEL_LEAD, PaxelDeepItems.lead);
            PickAxeRegister.register(PaxelDeepItems.TOOL_PAXEL_AMETHYST, PaxelDeepItems.amethyst);
            PickAxeRegister.register(PaxelDeepItems.TOOL_PAXEL_SILVER, PaxelDeepItems.silver);
        }
        if (IS_MOON_LOADED) {
            PickAxeRegister.register(PaxelMoonItems.TOOL_PAXEL_MOONSTEEL, MoonSteelItems.moonSteelTool);
        }
    }
}
