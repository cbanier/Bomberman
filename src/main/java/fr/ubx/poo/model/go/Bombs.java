package fr.ubx.poo.model.go;


import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.engine.GameEngine;
import fr.ubx.poo.model.decor.*;


public class Bombs extends GameObject{
    public GameEngine gameEngine;
    public boolean BombRequested;

    public Bombs(Game game, Position position){
        super(game,position);
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public void requestBomb(Position position) {
        if (position != getPosition()) {
            setPosition(position);
        }
        BombRequested = true;
    }

    public int getTimer(){
        return (int) getGameEngine().getNow();
    }
    public Bombs bombActions(int i) {
        if (i == 0) {
            return new Bomb4(game, getPosition());
        }
        if (i == 1) {
            return new Bomb3(game, getPosition());
        }
        if (i == 2) {
            return new Bomb2(game, getPosition());
        }
        if (i == 3) {
            return new Bomb1(game, getPosition());
        }
        if (i == 4) {
            return new Explosion(game, getPosition());
        }
        return null;
    }
}
