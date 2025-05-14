package com.czrbyn.configManager.manager;

import com.czrbyn.configManager.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CheckAllArgs {

    private FileConfiguration f;
    private File file;

    private MainOperationsFile mof;

    public boolean Check(String[] args, CommandSender sender) {
        if (args.length < 4) {
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &cNot enough arguments provided! Usage: /configmanager <addList etc> <pluginName (target)> <filename> <key> <thingToAdd>"));

            return false;
        } else {
            f = getConfigurationFile(args[1], args[2]);
            file = getConfigFile(args[1], args[2]);

            if (file == null || f == null) {
                sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &cEither the configuration filename you provided is wrong, or the plugin is wrong. Please retry."));
                return false;
            } else {
                var arg1 = args[0];
                var key = args[3];
                if (checkArg1(arg1, f, key, sender, file)) {
                    switch (arg1) {
                        case "createString","createInt","createBoolean","createDouble","createFloat","createLong","createList":
                            if (args.length > 5) {
                                String result = java.util.Arrays.stream(args, 4, args.length)
                                        .collect(Collectors.joining(" "));

                                mof.createOperator(f, key, result, file, args);
                            } else {
                                mof.createOperator(f, key, args[4], file, args);
                            }
                            return true;
                        case "setValue","addToList","removeFromList","clearList" :
                            if (args.length > 5) {
                                String result = java.util.Arrays.stream(args, 4, args.length)
                                        .collect(Collectors.joining(" "));

                                mof.createOperator(f, key, result, file, args);
                            } else {
                                mof.createOperator(f, key, args[4], file, args);
                            }
                    }
                }
            }
        }
        return true;
    }

    public boolean checkArg1(String arg, FileConfiguration cfg, String key, CommandSender sender, File file) {
        return switch (arg) {
            case "createString", "createInt", "createBoolean", "createDouble", "createFloat", "createLong",
                 "createList" -> canCreate(cfg, key, sender);
            case "setValue", "addToList", "removeFromList", "clearList" ->
                    canModify(cfg, key, sender);
            case "getValue", "getType" -> canGet(cfg, key, sender);
            case "removeKey" -> canRemove(cfg, key, sender);
            case "createFile", "reloadFile", "deleteFile", "saveFile" -> canDelete(sender, file);
            default -> false;
        };
    }

    public boolean canDelete(CommandSender sender, File file) {
        if (file.exists()) {
            return true;
        } else {
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &cThe file you provided does not exist."));
            return false;
        }
    }

    public boolean canRemove(FileConfiguration cfg, String key, CommandSender sender) {
        if (cfg.get(key) == null) {
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &cThis key does not need to be deleted as it does not exist already."));
            return false;
        } else {
            return true;
        }
    }

    public boolean canGet(FileConfiguration cfg, String key, CommandSender sender) {
        if (cfg.get(key) == null) {
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &cThe key you provided does not exist, please create it."));
            return false;
        } else {
            return true;
        }
    }

    public boolean canModify(FileConfiguration cfg, String key, CommandSender sender) {
        if (cfg.get(key) == null) {
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &cThe key you provided does not exist, please create it first using the command."));
            return false;
        } else {
            return true;
        }
    }

    public boolean canCreate(FileConfiguration cfg, String key, CommandSender sender) {
        if (cfg.get(key) != null) {
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &cThe key you provided already exists, please remove it first."));
            return false;
        } else {
            return true;
        }
    }

    public FileConfiguration getConfigurationFile(String pluginName, String fileName) {
        File file = getConfigFile(pluginName, fileName);
        return file != null ? YamlConfiguration.loadConfiguration(file) : null;
    }

    public File getConfigFile(String pluginName, String fileName) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);
        if (plugin == null || !plugin.isEnabled()) return null;

        File file = new File(plugin.getDataFolder(), fileName);
        return file.exists() ? file : null;
    }

}
