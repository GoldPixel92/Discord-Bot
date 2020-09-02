package de.Gold_Pixel;

import de.Gold_Pixel.Listener.BotListener;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiscordBot {

    public static DiscordBot INSTANCE;

    public ShardManager shardMan;
    private CommandManager cmdMan;

    public static void main(String[] args) {
        try {
            new DiscordBot();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public DiscordBot() throws LoginException {
        INSTANCE = this;

        DefaultShardManagerBuilder builder = new DefaultShardManagerBuilder();
        builder.setToken("");

        builder.setActivity(Activity.playing("something."));
        builder.setStatus(OnlineStatus.ONLINE);

        this.cmdMan = new CommandManager();
        builder.addEventListeners(new BotListener());

        shardMan = builder.build();
        System.out.println("Bot online.");

        shutdown();
    }

    public void shutdown() {
        new Thread(() -> {

            String line = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                while ((line = reader.readLine()) != null) {
                    if (line.equalsIgnoreCase("exit")) {
                        if (shardMan != null) {
                            shardMan.setStatus(OnlineStatus.OFFLINE);
                            shardMan.shutdown();
                            System.out.println("Bot offline.");
                        }

                        reader.close();

                    } else {
                        System.out.println("Use 'exit' to shutdown.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public CommandManager getCmdMan(){

        return cmdMan;
    }

}
