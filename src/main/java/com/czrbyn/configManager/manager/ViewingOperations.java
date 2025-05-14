package com.czrbyn.configManager.manager;

import org.bukkit.configuration.file.FileConfiguration;

public class ViewingOperations {

    public Object getValue(FileConfiguration cfg, String key) {
        return cfg.get(key);
    }

    public Object getType(FileConfiguration cfg, String key) {
        Object value = cfg.get(key);

        assert value != null;
        return value.getClass().getSimpleName();
    }

}
