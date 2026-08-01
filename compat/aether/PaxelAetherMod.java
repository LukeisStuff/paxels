package luke.paxels.compat.aether;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.spongepowered.asm.mixin.Mixins;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class PaxelAetherMod implements PreLaunchEntrypoint, GameStartEntrypoint, RecipeEntrypoint {
    public static boolean IS_AETHER_LOADED = false;

    public static RecipeEntrypoint recipeEntrypointDelegate;

    @Override
    public void onPreLaunch() {
        FabricLoader loader = FabricLoader.getInstance();
        IS_AETHER_LOADED = loader.isModLoaded("aether");

        if (IS_AETHER_LOADED) {
            Mixins.addConfiguration("compat/paxels/aether/aether.mixins.json");

            try {

                recipeEntrypointDelegate = (RecipeEntrypoint) Class
                    .forName("luke.paxels.compat.aether.PaxelAetherRecipes")
                    .getConstructor()
                    .newInstance();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void beforeGameStart() {
        if (IS_AETHER_LOADED) {
            PaxelAetherItems.init();
        }
    }

    @Override
    public void afterGameStart() {
    }

    @Override
    public void onRecipesReady() {
        if (IS_AETHER_LOADED) recipeEntrypointDelegate.onRecipesReady();
    }

    @Override
    public void initNamespaces() {
        if (IS_AETHER_LOADED) recipeEntrypointDelegate.initNamespaces();
    }
}
