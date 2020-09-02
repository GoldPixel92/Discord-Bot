package de.Gold_Pixel.commands;

import de.Gold_Pixel.commands.types.ServerCommands;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeCommand implements ServerCommands {

    @Override
    public void performCommand(Member m, TextChannel channel, Message message) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        channel.sendMessage("Es ist " + sdf.format(cal.getTime()) + "!").queue();
    }
}
