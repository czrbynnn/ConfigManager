package com.czrbyn.configManager.manager;

import com.czrbyn.configManager.ConfigManager;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.List;

public class MainOperationsFile {

    private CreateOperations co;
    private FileOperations fo;
    private ModificationOperations mo;
    private RemovalOperations ro;
    private ViewingOperations vo;

    public MainOperationsFile() {
        List<Object> list = ConfigManager.getInstance().getAllOperations();

        co = (CreateOperations) list.get(0);
        fo = (FileOperations) list.get(1);
        mo = (ModificationOperations) list.get(2);
        ro = (RemovalOperations) list.get(3);
        vo = (ViewingOperations) list.get(4);

    }

    public void createOperator(FileConfiguration cfg, String key, Object value, File file, String[] args) {
        switch (args[0]) {
            case "createString":
                co.createString(cfg, key, value, file);
                break;
            case "createInt":
                co.createInt(cfg, key, value, file);
                break;
            case "createBoolean":
                co.createBoolean(cfg, key, value, file);
                break;
            case "createDouble":
                co.createDouble(cfg, key, value, file);
                break;
            case "createFloat":
                co.createFloat(cfg, key, value, file);
                break;
            case "createLong":
                co.createLong(cfg, key, value, file);
                break;
            case "createList":
                co.createList(cfg, key, file);
                break;
        }
    }

    public void fileOperator2(CommandSender sender, String[] args, Plugin plugin) {
        if (args[0].equals("createFile")) {
            fo.createFile(args[2], sender, plugin);
        }
    }

    public void fileOperator(File f, CommandSender sender, String[] args) {
        switch (args[0]) {
            case "reloadFile":
                fo.reloadFile(f, sender);
                break;
            case "saveFile":
                fo.saveFile(f, sender);
                break;
        }
    }

    public void modifyOperator(FileConfiguration cfg, String key, Object value, File f, String[] args) {
        switch (args[0]) {
            case "setValue":
                mo.setValue(cfg, key, value, f);
                break;
            case "addToList":
                mo.addToList(cfg, key, value, f);
                break;
            case "removeFromList":
                mo.removeFromList(cfg, key, value, f);
                break;
            case "clearList":
                mo.clearList(cfg, key, f);
                break;
        }
    }

    public void removeOperator(FileConfiguration cfg, String key, File f, String[] args) {
        if (args[0].equals("removeKey")) {
            ro.RemoveKey(cfg, key, f);
        }
    }

    public Object viewOperator(FileConfiguration cfg, String key, Object value, File f, String[] args) {
        return switch (args[0]) {
            case "getValue" -> vo.getValue(cfg, key);
            case "getType" -> vo.getType(cfg, key);
            default -> "";
        };
    }

}
