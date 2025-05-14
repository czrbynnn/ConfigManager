package com.czrbyn.configManager.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigManagerTabCompletor implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("createString","createInt","createBoolean","createDouble","createFloat","createLong","createList","setValue","addToList","removeFromList","clearList","getValue","getType","removeKey","createFile","reloadFile","saveFile");
        }

        if (args.length == 2) {
            List<String> pluginNames = new ArrayList<>();
            for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                String name = plugin.getName();
                if (name.toLowerCase().startsWith(args[1].toLowerCase())) {
                    pluginNames.add(name);
                }
            }
            return pluginNames;
        }



        return Collections.emptyList();
    }

}
