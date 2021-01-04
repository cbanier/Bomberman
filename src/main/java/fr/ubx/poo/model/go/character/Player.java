/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.go.character;
import fr.ubx.poo.model.decor.*;
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.game.WorldEntity;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.GameObject;
import fr.ubx.poo.game.Game;

public class Player extends GameObject implements Movable {

    private final boolean alive = true;
    Direction direction;
    private boolean moveRequested = false;
    private int lives = 1;
    private boolean winner;
    private int nbBombs = 1;
    private int bombRange = 1;

    public Player(Game game, Position position) {
        super(game, position);
        this.direction = Direction.S;
        this.lives = game.getInitPlayerLives();
    }

    public int getLives() {
        return lives;
    }

    public Direction getDirection() {
        return direction;
    }

    public void requestMove(Direction direction) {
        if (direction != this.direction) {
            this.direction = direction;
        }
        moveRequested = true;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public boolean canMove(Direction direction) {
        Position nextPos = direction.nextPosition(getPosition());
        if (game.getWorld().isEmpty(nextPos)){
            return nextPos.inside(game.getWorld().dimension);
        }
        if (game.getWorld().get(nextPos) instanceof Monster){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof Princess){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof BombNumberDec){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof BombNumberInc){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof BombRangeInc){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof BombRangeDec){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof Heart){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof Key){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof Box){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof DoorNextOpened){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof DoorPrevOpened){
            return true;
        }
        return false;
    }

    public void doMove(Direction direction) {
        Position nextPos = direction.nextPosition(getPosition());
        Position next=direction.nextPosition(nextPos);
        if (game.getWorld().get(nextPos) instanceof Box){
            if (game.getWorld().isEmpty(next)){
                if(next.inside(game.getWorld().dimension)){
                game.getWorld().set(next,game.getWorld().get(nextPos));
                game.getWorld().clear(nextPos);
                }
            }
        }
        else{
            setPosition(nextPos);
            if (game.getWorld().get(nextPos) instanceof Monster){
                setLives(getLives()-1);
            }
            if (game.getWorld().get(nextPos) instanceof Key){
                game.initnbKey=1;
                game.getWorld().clear(nextPos);
            }
            if (game.getWorld().get(nextPos) instanceof DoorNextOpened){
                game.UpWorld();
                game.getWorld().SetUp();
            }
            if (game.getWorld().get(nextPos) instanceof DoorPrevOpened){
                game.DownWorld();
                game.getWorld().SetDown();
            }
            if (game.getWorld().get(nextPos) instanceof Princess){
                this.winner=true;
            }
            if (game.getWorld().get(nextPos) instanceof Heart){
                game.getWorld().clear(nextPos);
                setLives(getLives()+1);
            }
            if (game.getWorld().get(nextPos) instanceof BombNumberInc){
                game.getWorld().clear(nextPos);
                setNbBombs(getNbBombs()+1);
            }
            if (game.getWorld().get(nextPos) instanceof BombNumberDec){
                if (getNbBombs()>1)
                    game.getWorld().clear(nextPos);
                    setNbBombs(getNbBombs()-1);
            }
            if (game.getWorld().get(nextPos) instanceof BombRangeInc){
                game.getWorld().clear(nextPos);
                setBombRange(getBombRange()+1);
            }
            if (game.getWorld().get(nextPos) instanceof BombRangeDec){
                if (getBombRange()>1){
                    game.getWorld().clear(nextPos);
                    setBombRange(getBombRange()-1);
                }
            }
        }
    }

    public void update(long now) {
        if (moveRequested) {
            if (canMove(direction)) {
                doMove(direction);
            }
        }
        moveRequested = false;
    }

    public boolean isWinner() {
        return winner;
    }

    public boolean isAlive() {
        if(getLives()==0) return false;
        return alive;
    }
    public int getNbBombs() {
        return nbBombs;
    }

    public void setNbBombs(int nbBombs) {
        this.nbBombs = nbBombs;
    }

    public int getBombRange() {
        return bombRange;
    }

    public void setBombRange(int bombRange) {
        this.bombRange = bombRange;
    }
}
