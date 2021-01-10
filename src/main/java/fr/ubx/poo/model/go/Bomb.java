package fr.ubx.poo.model.go;


import fr.ubx.poo.model.decor.*;
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.GameObject;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.World;
import fr.ubx.poo.game.WorldEntity;



public class Bomb extends GameObject{
    private int stateBomb;
    private int range;
    private World world;

    public Bomb(Game game, Position position){
        super(game,position);
        this.stateBomb=0;
        range=game.getPlayer().getBombRange();
        world=game.getWorlds().get(game.getActualLevel()-1);
    }

    public World getWorld() {
        return world;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }
    public int getStateBomb() {
        return stateBomb;
    }

    public void setStateBomb(int stateBomb) {
        this.stateBomb = stateBomb;
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    //make the destruction
    public void doDestroy() {
        for (Direction d : Direction.values()){
            for (int i= 1 ; i <= this.range ; i++){
                Position nextPos= d.nextPosition(this.getPosition(),i);
                Position next= d.nextPosition(nextPos,i);
                if (game.getWorld().get(nextPos) instanceof Box ||  game.getWorld().get(nextPos) instanceof BombNumberDec ||
                        game.getWorld().get(nextPos) instanceof BombNumberInc || game.getWorld().get(nextPos) instanceof BombRangeDec ||
                        game.getWorld().get(nextPos) instanceof BombNumberInc) {
                    game.getWorld().clear(nextPos);
                    game.getWorld().setChanged();
                    if (game.getPlayer().getPosition().equals(next) ||  game.getWorld().getMonsters().stream().anyMatch(monster -> monster.getPosition().equals(next))){
                        break;
                    }
                }
                if (game.getPlayer().getPosition().equals(nextPos)) {
                    game.getPlayer().setLives(game.getPlayer().getLives()-1);
                }
                if (game.getWorld().getMonsters().stream().anyMatch(monster -> monster.getPosition().equals(nextPos))) {
                    game.getWorld().getMonsters().removeIf(monster -> monster.getPosition().equals(nextPos));
                    game.getWorld().setChanged();
                    if (game.getPlayer().getPosition().equals(nextPos)) {
                        game.getPlayer().setLives(game.getPlayer().getLives()-1);
                        break;
                    }
                }
                if (!game.getWorld().isEmpty(nextPos)) {
                }
            }
        }
    }
}
