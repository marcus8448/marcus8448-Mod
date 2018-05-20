package com.marcus8448.mod.handlers;

import com.marcus8448.mod.Config;
import com.marcus8448.mod.utils.Constants;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.Option;
import scala.util.parsing.json.JSON;
import scala.util.parsing.json.JSONType;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_Alpha
 *
 */
public class MMEventHandler {

	/**
	 * Send a message when entity joins world
	 * @author marcus8448
	 * @see EntityJoinWorldEvent
	 * @param event
	 */
	@SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof EntityPlayerMP) {
			EntityPlayerMP playerMP = (EntityPlayerMP) entity;
			if (Config.sendMessageOnStartup) {
				playerMP.sendMessage(new TextComponentString("§9Thank you for installing §lMarcus' Mod§9 for " + Constants.MCV + ". Go to§6 https://github.com/marcus8448/Marcus8448-Mod/issues/ §9to submit an §c§lissue§9 if you find one."));
				//Option<Object> jsonThingy = JSON.parseFull("{\"text\":\"Thank you for installing \",\"color\":\"blue\"},{\"text\":\"marcus8448's Mod \",\"color\":\"dark_blue\",\"bold\":true,\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/marcus8448/Marcus8448-Mod/\"}},{\"text\":\"click \",\"color\":\"blue\",\"bold\":false},{\"text\":\"this button ⬛\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/marcus8448/Marcus8448-Mod/issues/\"}},{\"text\":\" to create an \",\"color\":\"blue\"},{\"text\":\"ISSUE REPORT\",\"color\":\"red\",\"bold\":true,\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://github.com/marcus8448/Marcus8448-Mod/issues/\"}},{\"text\":\" if you find a bug.\",\"color\":\"blue\",\"bold\":false}");
			}
		}
	}
}

