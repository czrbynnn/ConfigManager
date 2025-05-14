package com.czrbyn.configManager.manager;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class RemovalOperations {

    public void RemoveKey(FileConfiguration cfg, String key, File file) {
        cfg.set(key, null);
        SaveConfig(cfg, file);
    }

    public void SaveConfig(FileConfiguration cfg, File configFile) {
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
