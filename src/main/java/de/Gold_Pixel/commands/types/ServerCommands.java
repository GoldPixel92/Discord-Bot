package de.Gold_Pixel.commands.types;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;


public interface ServerCommands {

    public void performCommand(Member m, TextChannel channel, Message message);

}
