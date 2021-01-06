package fr.ubx.poo.model.go.character;
import fr.ubx.poo.model.decor.*;
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.game.World;
import fr.ubx.poo.game.WorldEntity;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.GameObject;
import fr.ubx.poo.game.Game;

public class Monster extends GameObject implements Movable {
    Direction direction;
    private World world;
    private final boolean alive = true;
    private boolean moveRequested = false;
    private int lives = 1;


    public Monster(Game game, Position position) {
        super(game, position);
        world=game.getWorld();
        this.direction = Direction.random();
        this.lives = 1;
    }

    public World getWorld() {
        return world;
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
        if (game.getWorld().get(nextPos) instanceof Princess){
            return true;
        }
        if (game.getWorld().get(nextPos) instanceof BombNumberDec){
            return false;
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
        if(nextPos==game.getPlayer().getPosition()){
            return true;
        }
        return false;
    }

    public void doMove(Direction direction) {
        Position nextPos = direction.nextPosition(getPosition());
        if(canMove(direction)){
            this.setPosition(nextPos);
            world.setChanged();
            if (game.getPlayer().getPosition().equals(this.getPosition())){
                game.getPlayer().setLives(game.getPlayer().getLives()-1);;
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

    public boolean isAlive() {
        if(getLives()==0) return false;
        return alive;
    }

}
