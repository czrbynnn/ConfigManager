package com.czrbyn.configManager;

import com.czrbyn.configManager.commands.ConfigManagerTabCompletor;
import com.czrbyn.configManager.commands.MainCommand;
import com.czrbyn.configManager.manager.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public final class ConfigManager extends JavaPlugin {

    private static ConfigManager cfm;

    private MainCommand mcmd;
    private ConfigManagerTabCompletor cmtc;

    private CheckAllArgs caa;

    private MainOperationsFile mof;

    private CreateOperations co;
    private FileOperations fo;
    private ModificationOperations mo;
    private RemovalOperations ro;
    private ViewingOperations vo;

    @Override
    public void onEnable() {
        cfm = this;


        cmtc = new ConfigManagerTabCompletor();





        co = new CreateOperations();
        fo = new FileOperations();
        mo = new ModificationOperations();
        ro = new RemovalOperations();
        vo = new ViewingOperations();

        mof = new MainOperationsFile();

        caa = new CheckAllArgs();

        mcmd = new MainCommand();

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

    public MainOperationsFile getMof() {
        return mof;
    }

    public List<Object> getAllOperations() {
        List<Object> list = new ArrayList<>();

        list.add(co);
        list.add(fo);
        list.add(mo);
        list.add(ro);
        list.add(vo);

        return list;
    }
}
