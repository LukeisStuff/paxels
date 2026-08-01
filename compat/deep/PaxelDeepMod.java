package luke.paxels.compat.deep;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class PaxelDeepMod implements PreLaunchEntrypoint, GameStartEntrypoint, RecipeEntrypoint {
    public static boolean IS_DEEP_LOADED = false;

    public static RecipeEntrypoint recipeEntrypointDelegate;

    @Override
    public void onPreLaunch() {
        FabricLoader loader = FabricLoader.getInstance();

        IS_DEEP_LOADED = loader.isModLoaded("deep");

        if (IS_DEEP_LOADED) {

            try {

                recipeEntrypointDelegate = (RecipeEntrypoint) Class
                    .forName("luke.paxels.compat.deep.PaxelDeepRecipes")
                    .getConstructor()
                    .newInstance();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void beforeGameStart() {
        if (IS_DEEP_LOADED) {
            PaxelDeepItems.init();
        }
    }

    @Override
    public void afterGameStart() {
    }

    @Override
    public void onRecipesReady() {
        if (IS_DEEP_LOADED) recipeEntrypointDelegate.onRecipesReady();
    }

    @Override
    public void initNamespaces() {
        if (IS_DEEP_LOADED) recipeEntrypointDelegate.initNamespaces();
    }
}
