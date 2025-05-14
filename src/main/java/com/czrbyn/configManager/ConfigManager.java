package com.czrbyn.configManager;

import com.czrbyn.configManager.commands.ConfigManagerTabCompletor;
import com.czrbyn.configManager.commands.MainCommand;
import com.czrbyn.configManager.manager.CheckAllArgs;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConfigManager extends JavaPlugin {

    private static ConfigManager cfm;

    private MainCommand mcmd;
    private ConfigManagerTabCompletor cmtc;

    private CheckAllArgs caa;

    @Override
    public void onEnable() {
        cfm = this;

        mcmd = new MainCommand();
        cmtc = new ConfigManagerTabCompletor();

        caa = new CheckAllArgs();



        getCommand("configmanager").setExecutor(mcmd);
        getCommand("configmanager").setTabCompleter(cmtc);

    }

    @Override
    public void onDisable() {

    }

    public static ConfigManager getInstance() {
        return cfm;
    }

    public CheckAllArgs getCaa() {
        return caa;
    }
}
