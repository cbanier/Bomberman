/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.game;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import fr.ubx.poo.model.go.character.Player;
import fr.ubx.poo.model.go.character.Monster;

public class Game {

    private World world;
    private final Player player;
    private final List<List<Monster>> monsterList;
    private final String worldPath;
    public int initPlayerLives;
    public int initnbKey;
    public int initNbBombs;
    public int initRange;

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
        actualLevel=1;
        world = worlds.get(actualLevel-1);
        monsterList =  new ArrayList<List<Monster>>(levels);
        loadAllMonster();
        for (int i=0; i< levels; i++){
            monsterList.add(i, worlds.get(i).getMonsters());
        }
        Position positionPlayer=null;
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

    public List<World> getWorlds() {
        return worlds;
    }

    public int getLevels() {
        return levels;
    }

    public int getActualLevel() {
        return actualLevel;
    }

    public int getInitnbKey() {
        return initnbKey;
    }

    public int getInitNbBombs() {
        return initNbBombs;
    }

    public int getInitRange() {
        return initRange;
    }

    private void loadConfig(String path) {
        try (InputStream input = new FileInputStream(new File(path, "config.properties"))) {
            Properties prop = new Properties();
            // load the configuration file
            prop.load(input);
            initPlayerLives = Integer.parseInt(prop.getProperty("lives", "3"));
            initnbKey = 0;
            levels = Integer.parseInt(prop.getProperty("lives", "3"));
            initNbBombs = 1;
            initRange = 1;
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

    public List<List<Monster>> getMonsterList() {
        return monsterList;
    }

    private void loadAllMonster() {
        for (int i=0; i<levels;i++){
            for (int j = 0; j < worlds.get(i).findMonster().size(); j++) {
                worlds.get(i).getMonsters().add(new Monster(this, worlds.get(i).findMonster().get(j), this.worlds.get(i)));
            }
        }
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
