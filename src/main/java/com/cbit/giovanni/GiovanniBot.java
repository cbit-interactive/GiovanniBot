package com.cbit.giovanni;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class GiovanniBot {
    private final Dotenv config;

    private final ShardManager shardManager;

    /**
     * Giovanni bot contructor. Loads sharding
     * @throws LoginException occurs when bot token is invalid or cannot be found
     */
    public GiovanniBot() throws LoginException {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        DefaultShardManagerBuilder shard = DefaultShardManagerBuilder.createDefault(token);
        shard.setActivity(Activity.streaming("/help", "https://youtu.be/3uiea53t1L4?si=Q0TmmgrCDIAtWpfV"));
        shard.setStatus(OnlineStatus.ONLINE);
        shardManager = shard.build();
    }

    /**
     * Loads config file for use in other files
     * @return configuration file
     */
    public Dotenv getConfig(){
        return config;
    }

    /**
     * Loads shard manager for use in other files
     * @return Shard manager
     */
    public ShardManager getShardManager(){
        return shardManager;
    }

    public static void main(String[] args){

        // Main
        try {
            GiovanniBot bot = new GiovanniBot();

        } catch (LoginException e) {
            System.out.println("Error with bot token!");
            throw new RuntimeException(e);
        }
    }
}
