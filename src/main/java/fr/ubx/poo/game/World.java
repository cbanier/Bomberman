/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.game;

import fr.ubx.poo.model.decor.Decor;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

import fr.ubx.poo.model.go.character.Monster;

import fr.ubx.poo.game.Game;

public class World {
    private final Map<Position, Decor> grid;
    private final WorldEntity[][] raw;
    public final Dimension dimension;
    private final List<Monster> monsters;
    private boolean changed = false; 
    private boolean Up= false;
    private boolean Down=false;

    public boolean hasChanged() { return changed; }

    public boolean hasUp() { return Up; }

    public boolean hasDown() { return Down; }

    

    public World(WorldEntity[][] raw) {
        this.raw = raw;
        dimension = new Dimension(raw.length, raw[0].length);
        grid = WorldBuilder.build(raw, dimension);
        monsters= new ArrayList<>();
        changed = false; 
        Up= false;
        Down=false;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }


    public void setChanged(){
        changed= true;
    }

    public void finishChanged(){
        changed=false;
    }

    public void SetUp(){
        Up=true;
    }

    public void SetUpfinish(){
        Up=false;
    }

    public void SetDown(){
        Down=true;
    }

    public void SetDownfinish(){
        Down=false;
    }

    public Position findPlayer() throws PositionNotFoundException {
        for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {
                if (raw[y][x] == WorldEntity.Player) {
                    return new Position(x, y);
                }
            }
        }
        throw new PositionNotFoundException("Player");
    }

    public List<Position> findMonster() {
        List<Position> monsterPos = new ArrayList<>();
        for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {
                if (raw[y][x] == WorldEntity.Monster) {
                    monsterPos.add(new Position(x, y));

                }
            }
        }
        return monsterPos;
    }


    public Position finDoorN() {
        for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {
                if (raw[y][x] == WorldEntity.DoorPrevOpened) {
                    return new Position(x, y);
                }
            }
        }
        return null;
    }

    public Position finDoorP() {
        for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {
                if (raw[y][x] == WorldEntity.DoorNextClosed) {
                    return new Position(x, y);
                }
            }
        }
        return null;
    }

    public Decor get(Position position) {
        return grid.get(position);
    }

    public void set(Position position, Decor decor) {
        grid.put(position, decor);
        changed=true;
    }

    public void clear(Position position) {
        grid.remove(position);
        changed=true;
    }

    public void forEach(BiConsumer<Position, Decor> fn) {
        grid.forEach(fn);
    }



    public Collection<Decor> values() {
        return grid.values();
    }

    public boolean isInside(Position position) {
        return true; // to update
    }

    public boolean isEmpty(Position position) {
        return grid.get(position)==null;
    }
}
