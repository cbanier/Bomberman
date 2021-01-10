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


    public Monster(Game game, Position position, World world) {
        super(game, position);
        this.world=world;
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
        if (this.world.isEmpty(nextPos)){
            return nextPos.inside(world.dimension);
        }
        if(this.world.get(nextPos).canWalkOnM()){
            return true;
        }
        return false;
    }

    public void doMove(Direction direction) {
        Position nextPos = direction.nextPosition(getPosition());
        if(canMove(direction)){
            this.setPosition(nextPos);
            world.setChanged();
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
