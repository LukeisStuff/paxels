package luke.paxels;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import turniplabs.halplibe.event.defs.ClientEvents;

import static luke.paxels.PaxelMod.*;
import static net.minecraft.client.render.item.model.ItemModelDispatcher.*;

public class PaxelClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LOGGER.info("Paxels initialized.");
        ClientEvents.ITEM_MODEL_RELOAD.listen(KEY, PaxelClient::initItemModels);
    }

    public static void initItemModels(ItemModelDispatcher dispatcher) {


        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_WOOD).setIcon("paxels:item/tool_paxel_wood")
            .setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND)
            .setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND)
            .setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND)
            .setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND)
        );

        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_STONE).setIcon("paxels:item/tool_paxel_stone")
            .setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND)
            .setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND)
            .setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND)
            .setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND)
        );

        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_IRON).setIcon("paxels:item/tool_paxel_iron")
            .setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND)
            .setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND)
            .setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND)
            .setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND)
        );

        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_GOLD).setIcon("paxels:item/tool_paxel_gold")
            .setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND)
            .setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND)
            .setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND)
            .setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND)
        );

        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_DIAMOND).setIcon("paxels:item/tool_paxel_diamond")
            .setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND)
            .setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND)
            .setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND)
            .setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND)
        );

        dispatcher.addDispatch(new ItemModelStandard(PaxelItems.TOOL_PAXEL_STEEL).setIcon("paxels:item/tool_paxel_steel")
            .setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND)
            .setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND)
            .setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND)
            .setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND)
        );

    }
}
