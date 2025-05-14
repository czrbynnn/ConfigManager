package com.czrbyn.configManager.manager;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CreateOperations {

    public void createString(FileConfiguration cfg, String key, Object value, File f) {
        if (value instanceof String) {
            cfg.set(key, value);
            saveConfig(cfg, f);
        }
    }

    public void createInt(FileConfiguration cfg, String key, Object value, File f) {
        if (value instanceof Integer) {
            cfg.set(key, value);
            saveConfig(cfg, f);
        }
    }

    public void createBoolean(FileConfiguration cfg, String key, Object value, File f) {
        if (value instanceof Boolean) {
            cfg.set(key, value);
            saveConfig(cfg, f);
        }
    }

    public void createDouble(FileConfiguration cfg, String key, Object value, File f) {
        if (value instanceof Double) {
            cfg.set(key, value);
            saveConfig(cfg, f);
        }
    }

    public void createFloat(FileConfiguration cfg, String key, Object value, File f) {
        if (value instanceof Float) {
            cfg.set(key, value);
            saveConfig(cfg, f);
        }
    }

    public void createLong(FileConfiguration cfg, String key, Object value, File f) {
        if (value instanceof Long) {
            cfg.set(key, value);
            saveConfig(cfg, f);
        }
    }

    public void createList(FileConfiguration cfg, String key, File f) {
        List<Object> list = new ArrayList<>();
        cfg.set(key, list);
        saveConfig(cfg, f);
    }

    public void saveConfig(FileConfiguration cfg, File configFile) {
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
