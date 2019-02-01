package com.sasha.reminecraft.reaction.server;

import com.github.steveice10.mc.protocol.data.game.window.CraftingBookDataType;
import com.github.steveice10.mc.protocol.packet.ingame.client.window.ClientCraftingBookDataPacket;
import com.sasha.reminecraft.client.ReClient;
import com.sasha.reminecraft.reaction.IPacketReactor;

public class ClientCraftingBookDataReaction implements IPacketReactor<ClientCraftingBookDataPacket> {


    @Override
    public boolean takeAction(ClientCraftingBookDataPacket packet) {
        if (packet.getType() == CraftingBookDataType.CRAFTING_BOOK_STATUS) {
            ReClient.ReClientCache.INSTANCE.wasFilteringCraftingRecipes = packet.isFilterCraftingActive();
            ReClient.ReClientCache.INSTANCE.wasFilteringSmeltingRecipes = packet.isFilterSmeltingActive();
            ReClient.ReClientCache.INSTANCE.wasCraftingRecipeBookOpened = packet.isCraftingBookOpen();
            ReClient.ReClientCache.INSTANCE.wasSmeltingRecipeBookOpened = packet.isSmeltingBookOpen();
        }
        return true;
    }
}
