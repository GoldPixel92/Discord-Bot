package de.Gold_Pixel;

import de.Gold_Pixel.commands.ClearCommand;
import de.Gold_Pixel.commands.GreetingCommand;
import de.Gold_Pixel.commands.DateCommand;
import de.Gold_Pixel.commands.TimeCommand;
import de.Gold_Pixel.commands.types.ServerCommands;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.ConcurrentHashMap;

public class CommandManager {

    public ConcurrentHashMap<String, ServerCommands> commands;

    public CommandManager() {
        this.commands = new ConcurrentHashMap<>();

        //befehle werden der HashMap hinzugefügt und dann wird eine neue Klasse für jeden Befehl erstellt

        this.commands.put("clear", new ClearCommand());
        this.commands.put("datum", new DateCommand());
        this.commands.put("zeit", new TimeCommand());
        this.commands.put("hi", new GreetingCommand());
    }

    public boolean perform(String command, Member m, TextChannel channel, Message message){

        ServerCommands cmd;
        if((cmd = this.commands.get(command.toLowerCase())) != null) {
            cmd.performCommand(m, channel, message);
            return true;
        }
        return false;
    }
}
