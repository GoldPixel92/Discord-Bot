package de.Gold_Pixel.commands;

import de.Gold_Pixel.commands.types.ServerCommands;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class GreetingCommand implements ServerCommands {
    @Override
    public void performCommand(Member m, TextChannel channel, Message message) {
        channel.sendMessage("Hallo " + m.getAsMention() + "!").queue();
    }
}
