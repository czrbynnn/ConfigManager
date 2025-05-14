package com.czrbyn.configManager.commands;

import com.czrbyn.configManager.ConfigManager;
import com.czrbyn.configManager.manager.CheckAllArgs;
import com.czrbyn.configManager.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    private ConfigManager cfm;
    private CheckAllArgs caa;

    public MainCommand() {
        cfm = ConfigManager.getInstance();

        caa = cfm.getCaa();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (caa.Check(args, sender)) {
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &aShould be a success! Make sure to check first."));
            return true;
        } else {
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &fSomething went wrong during the process. Check the console."));
            return false;
        }
    }
}
