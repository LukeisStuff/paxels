package luke.paxels;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.crafting.LookupFuelFurnace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class PaxelMod implements ModInitializer, GameStartEntrypoint {
	public static final String MOD_ID = "paxels";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Paxels initialized.");
	}

	@Override
	public void beforeGameStart() {
		PaxelItems.init();
	}

	@Override
	public void afterGameStart() {
		LookupFuelFurnace.instance.addFuelEntry(PaxelItems.TOOL_PAXEL_WOOD.id, 500);

	}
}
