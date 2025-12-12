package luke.paxels.compat.moonsteel;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.tag.Tag;
import org.spongepowered.asm.mixin.Mixins;
import silveon22.deep.block.DEEPBlocks;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.ModelEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;
import useless.moonsteel.MoonSteelBlocks;

import static luke.paxels.compat.deep.PaxelDeepCompatibility.IS_DEEP_LOADED;

public class PaxelMoonCompatibility implements PreLaunchEntrypoint, GameStartEntrypoint, ModelEntrypoint, RecipeEntrypoint {

    public static boolean IS_MOON_LOADED = false;

    public static ModelEntrypoint modelEntryPointDelegate;
    public static RecipeEntrypoint recipeEntrypointDelegate;

    @Override
    public void onPreLaunch() {
        FabricLoader loader = FabricLoader.getInstance();

        IS_MOON_LOADED = loader.isModLoaded("moonsteel");

        if (IS_MOON_LOADED) {
            Mixins.addConfiguration("compat/paxels/moon/moon.mixins.json");

            try {
                modelEntryPointDelegate = (ModelEntrypoint) Class
                    .forName("luke.paxels.compat.moonsteel.PaxelMoonModels")
                    .getConstructor()
                    .newInstance();

                recipeEntrypointDelegate = (RecipeEntrypoint) Class
                    .forName("luke.paxels.compat.moonsteel.PaxelMoonRecipes")
                    .getConstructor()
                    .newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void callInit(String classPath, String methodName) {
        try {
            Class.forName(classPath).getMethod(methodName).invoke(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void beforeGameStart() {
        if (IS_MOON_LOADED) {
            callInit("luke.paxels.compat.moonsteel.PaxelMoonItems", "init");
            if (IS_DEEP_LOADED) {
                Tag<Block<?>> forceFortune = MoonSteelBlocks.FORCE_FORTUNE;

                DEEPBlocks.stoneAmethystOre.withTags(forceFortune);
                DEEPBlocks.basaltAmethystOre.withTags(forceFortune);
                DEEPBlocks.limestoneAmethystOre.withTags(forceFortune);
                DEEPBlocks.graniteAmethystOre.withTags(forceFortune);
                DEEPBlocks.permafrostAmethystOre.withTags(forceFortune);
                DEEPBlocks.peridotiteAmethystOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteAmethystOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneAmethystOre.withTags(forceFortune);

                DEEPBlocks.stoneBismuthOre.withTags(forceFortune);
                DEEPBlocks.basaltBismuthOre.withTags(forceFortune);
                DEEPBlocks.limestoneBismuthOre.withTags(forceFortune);
                DEEPBlocks.graniteBismuthOre.withTags(forceFortune);
                DEEPBlocks.permafrostBismuthOre.withTags(forceFortune);
                DEEPBlocks.peridotiteBismuthOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteBismuthOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneBismuthOre.withTags(forceFortune);

                DEEPBlocks.stoneLeadOre.withTags(forceFortune);
                DEEPBlocks.basaltLeadOre.withTags(forceFortune);
                DEEPBlocks.limestoneLeadOre.withTags(forceFortune);
                DEEPBlocks.graniteLeadOre.withTags(forceFortune);
                DEEPBlocks.permafrostLeadOre.withTags(forceFortune);
                DEEPBlocks.peridotiteLeadOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteLeadOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneLeadOre.withTags(forceFortune);

                DEEPBlocks.stoneSilverOre.withTags(forceFortune);
                DEEPBlocks.basaltSilverOre.withTags(forceFortune);
                DEEPBlocks.limestoneSilverOre.withTags(forceFortune);
                DEEPBlocks.graniteSilverOre.withTags(forceFortune);
                DEEPBlocks.permafrostSilverOre.withTags(forceFortune);
                DEEPBlocks.netherrackSilverOre.withTags(forceFortune);
                DEEPBlocks.peridotiteSilverOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteSilverOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneSilverOre.withTags(forceFortune);

                DEEPBlocks.stoneUraniumOre.withTags(forceFortune);
                DEEPBlocks.basaltUraniumOre.withTags(forceFortune);
                DEEPBlocks.limestoneUraniumOre.withTags(forceFortune);
                DEEPBlocks.graniteUraniumOre.withTags(forceFortune);
                DEEPBlocks.permafrostUraniumOre.withTags(forceFortune);
                DEEPBlocks.peridotiteUraniumOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteUraniumOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneUraniumOre.withTags(forceFortune);

                DEEPBlocks.netherrackTopazOre.withTags(forceFortune);
                DEEPBlocks.netherrackRhodoniteOre.withTags(forceFortune);

                DEEPBlocks.peridotiteCoalOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteCoalOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneCoalOre.withTags(forceFortune);

                DEEPBlocks.peridotiteIronOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteIronOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneIronOre.withTags(forceFortune);

                DEEPBlocks.peridotiteGoldOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteGoldOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneGoldOre.withTags(forceFortune);

                DEEPBlocks.peridotiteDiamondOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteDiamondOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneDiamondOre.withTags(forceFortune);

                DEEPBlocks.peridotiteLapisOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteLapisOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneLapisOre.withTags(forceFortune);

                DEEPBlocks.peridotiteRedstoneOre.withTags(forceFortune);
                DEEPBlocks.peridotiteRedstoneGlowingOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteRedstoneOre.withTags(forceFortune);
                DEEPBlocks.abyssalriteRedstoneGlowingOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneRedstoneOre.withTags(forceFortune);
                DEEPBlocks.pearlstoneRedstoneGlowingOre.withTags(forceFortune);
            }
        }
    }

    @Override
    public void afterGameStart() {
    }

    @Override
    public void initBlockColors(BlockColorDispatcher dispatcher) {
        if (IS_MOON_LOADED) modelEntryPointDelegate.initBlockColors(dispatcher);
    }

    @Override
    public void initBlockModels(BlockModelDispatcher dispatcher) {
        if (IS_MOON_LOADED) modelEntryPointDelegate.initBlockModels(dispatcher);
    }

    @Override
    public void initItemModels(ItemModelDispatcher dispatcher) {
        if (IS_MOON_LOADED) modelEntryPointDelegate.initItemModels(dispatcher);
    }

    @Override
    public void initEntityModels(EntityRenderDispatcher dispatcher) {
        if (IS_MOON_LOADED) modelEntryPointDelegate.initEntityModels(dispatcher);
    }

    @Override
    public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {
        if (IS_MOON_LOADED) modelEntryPointDelegate.initTileEntityModels(dispatcher);
    }

    @Override
    public void onRecipesReady() {
        if (IS_MOON_LOADED) recipeEntrypointDelegate.onRecipesReady();
    }

    @Override
    public void initNamespaces() {
        if (IS_MOON_LOADED) recipeEntrypointDelegate.initNamespaces();
    }
}
