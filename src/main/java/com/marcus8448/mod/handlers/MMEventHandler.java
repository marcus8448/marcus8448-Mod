package com.marcus8448.mod.handlers;

import com.marcus8448.mod.Config;
import com.marcus8448.mod.utils.Constants;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
				TextComponentString message = new TextComponentString("§9Thank you for installing §lMarcus' Mod§9 for " + Constants.MCV + ". Go to§6 ");
				
				//playerMP.sendMessage(new TextComponentString("§9Thank you for installing §lMarcus' Mod§9 for " + Constants.MCV + ". Go to§6 https://github.com/marcus8448/Marcus8448-Mod/issues/ §9to submit an §c§lissue§9 if you find one."));
				ITextComponent componentIssueLink = new TextComponentString("https://github.com/marcus8448/Marcus8448-Mod/issues/");
                Style styleLink = new Style();
                styleLink.setUnderlined(Boolean.TRUE);
                styleLink.setColor(TextFormatting.GOLD);
                styleLink.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/marcus8448/Marcus8448-Mod/issues"));
                componentIssueLink.setStyle(styleLink);
                message.appendSibling(componentIssueLink);
                ITextComponent after = new TextComponentString(" §9to submit an §c§lissue§9 if you find one.");
                message.appendSibling(after);
                playerMP.sendMessage(message);
                
			}
		}
	}
}

