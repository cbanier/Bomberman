/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.game;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import fr.ubx.poo.model.go.character.Player;

public class Game {

    private World world;
    private final Player player;
    private final String worldPath;
    public int initPlayerLives;
    public int initnbKey;

    private int levels;
    private int actualLevel;
    private WorldEntity[][] raw;
    private List<World> worlds;

    public Game(String worldPath) {
        this.worldPath = worldPath;
        loadConfig(worldPath);
        worlds = new ArrayList<>(levels);
        for(int i=1; i<=levels; i++){
            worlds.add(new WorldFromFile(worldPath +"/level"+ i + ".txt"));
        }
        //worlds.add(new WorldFromFile(worldPath + "/level3.txt"));
        //worlds.add(new WorldFromFile(worldPath + "/level2.txt"));
        actualLevel=1;
        world = worlds.get(actualLevel-1);
        //world = new WorldStatic();
        Position positionPlayer = null;
        try {
            positionPlayer = world.findPlayer();
            player = new Player(this, positionPlayer);
        } catch (PositionNotFoundException e) {
            System.err.println("Position not found : " + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    public int getInitPlayerLives() {
        return initPlayerLives;
    }

    public int getActualLevel() {
        return actualLevel;
    }

    public int getInitnbKey() {
        return initnbKey;
    }

    private void loadConfig(String path) {
        try (InputStream input = new FileInputStream(new File(path, "config.properties"))) {
            Properties prop = new Properties();
            // load the configuration file
            prop.load(input);
            initPlayerLives = Integer.parseInt(prop.getProperty("lives", "3"));
            initnbKey = Integer.parseInt("0");
            levels = Integer.parseInt(prop.getProperty("lives", "3"));
        } catch (IOException ex) {
            System.err.println("Error loading configuration");
        }
    }

    public World getWorld() {
        return world;
    }

    public Player getPlayer() {
        return this.player;
    }

    public String getWorldPath() {
        return worldPath;
    }
    


    public void UpWorld(){
        actualLevel=actualLevel+1;
        world=worlds.get(actualLevel-1);
    }

    public void DownWorld(){
        actualLevel=actualLevel-1;
        world=worlds.get(actualLevel-1);
    }
}
