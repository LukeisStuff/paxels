package luke.paxels;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.crafting.LookupFuelFurnace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.util.dependency.Key;


public class PaxelMod implements ModInitializer {
    public static final String MOD_ID = HalpLibe.registerMod("paxels");
    public static final Key KEY = Key.of(MOD_ID);
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Paxels initialized.");
        CommonEvents.BEFORE_GAME_START.listen(KEY, PaxelMod::beforeGameStart);
        CommonEvents.AFTER_GAME_START.listen(KEY, PaxelMod::afterGameStart);
        CommonEvents.RECIPES_READY.listen(KEY, PaxelRecipes::onRecipesReady);
        CommonEvents.RECIPES_NAMESPACE_INIT.listen(KEY, PaxelRecipes::initNamespaces);
        CommonEvents.AFTER_ITEM_INIT.listen(KEY, PaxelItems::init);
    }


    public static void afterGameStart() {
        LookupFuelFurnace.instance.addFuelEntry(PaxelItems.TOOL_PAXEL_WOOD.id, 500);
    }

    public static void beforeGameStart() {
        PaxelItems.init();
    }

}
