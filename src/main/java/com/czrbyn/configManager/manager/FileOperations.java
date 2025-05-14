package com.czrbyn.configManager.manager;

import com.czrbyn.configManager.utils.ColorUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class FileOperations {

    public void createFile(String fileToCreate, CommandSender sender, Plugin plugin) {
        try {
            File toCreate = new File(plugin.getDataFolder(), fileToCreate);
            if (toCreate.createNewFile()) {
                sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8]&a File successfully created."));
            }
        } catch (IOException e) {
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8]&c File creation unsuccessful, check console for extra information."));
            e.printStackTrace();
        }
    }



    public void reloadFile(File fileToReload, CommandSender sender) {
        try {
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(fileToReload);
            cfg.save(fileToReload);
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &aFile reloading successful."));
        } catch (Exception e) {
            e.printStackTrace();
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &cFile reloading unsuccessful, check console for extra information."));
        }
    }

    public void saveFile(File fileToSave, CommandSender sender) {
        try {
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(fileToSave);
            cfg.save(fileToSave);
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &aFile saving successful."));
        } catch (Exception e) {
            e.printStackTrace();
            sender.sendMessage(ColorUtils.colorize("&8[&bConfigManager&8] &cFile saving unsuccessful, check console for extra information."));
        }


    }

}
