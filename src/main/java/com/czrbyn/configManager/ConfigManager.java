package com.czrbyn.configManager;

import com.czrbyn.configManager.commands.ConfigManagerTabCompletor;
import com.czrbyn.configManager.commands.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConfigManager extends JavaPlugin {

    private MainCommand mcmd;
    private ConfigManagerTabCompletor cmtc;

    @Override
    public void onEnable() {
        mcmd = new MainCommand();
        cmtc = new ConfigManagerTabCompletor();

        getCommand("configmanager").setExecutor(mcmd);
        getCommand("configmanager").setTabCompleter(cmtc);

    }

    @Override
    public void onDisable() {

    }
}
