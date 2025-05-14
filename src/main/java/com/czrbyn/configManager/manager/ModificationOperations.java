package com.czrbyn.configManager.manager;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModificationOperations {

    public void setValue(FileConfiguration cfg, String key, Object value, File f) {
        cfg.set(key, value);
        saveConfig(cfg, f);
    }

    public void addToList(FileConfiguration cfg, String key, Object value, File f) {
        Object raw = cfg.get(key);
        List<Object> list;

        if (raw instanceof List) {
            list = new ArrayList<>((List<?>) raw);
        } else {
            list = new ArrayList<>();
        }

        list.add(value);
        cfg.set(key, list);

        try {
            cfg.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFromList(FileConfiguration cfg, String key, Object value, File f) {
        Object raw = cfg.get(key);
        List<Object> list;

        if (raw instanceof List) {
            list = new ArrayList<>((List<?>) raw);
        } else {
            list = new ArrayList<>();
        }

        list.remove(value);
        cfg.set(key, list);

        try {
            cfg.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearList(FileConfiguration cfg, String key, File f) {
        Object raw = cfg.get(key);
        List<Object> list;

        if (raw instanceof List) {
            list = new ArrayList<>((List<?>) raw);
        } else {
            list = new ArrayList<>();
        }

        list.clear();
        cfg.set(key, list);

        try {
            cfg.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveConfig(FileConfiguration cfg, File configFile) {
        try {
            cfg.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
