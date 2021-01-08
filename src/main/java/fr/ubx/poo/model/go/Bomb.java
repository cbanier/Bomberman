package fr.ubx.poo.model.go;


<<<<<<< HEAD:src/main/java/fr/ubx/poo/model/go/Bomb.java
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.decor.Box;


public class Bombs extends GameObject{
    private int bombState;
    private boolean bombRequested = false;

    public Bombs(Game game, Position position){
        super(game,position);
        this.bombState = 0;
=======
import fr.ubx.poo.model.decor.*;
import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.GameObject;
import fr.ubx.poo.game.Game;



public class Bombs extends GameObject{
    private int stateBomb;
    private int range;

    public Bombs(Game game, Position position){
        super(game,position);
        this.stateBomb=0;
        range=game.getPlayer().getBombRange();
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
>>>>>>> 54d0d85ad265f5fd377cebd0b60232aa80927c16:src/main/java/fr/ubx/poo/model/go/Bombs.java
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }
    
    public int getBombState() {
        return bombState;
    }

    public void setBombState(int bombState) {
        this.bombState = bombState;
    }

    public void requestBomb() {
        bombRequested = true;
    }

    public void update(long state){
        if (bombRequested){
            doExplosion(state);
            //doDestroy();
        }
    }

<<<<<<< HEAD:src/main/java/fr/ubx/poo/model/go/Bomb.java
    // EQUIVALENT DE DOMOVE POUR LES MOVABLE
    // TO DO ++++++
    public void doExplosion(long state) {
        long lauchAt = game.getPlayer().getTimerSinceBombWasLaunch();
        if (lauchAt - 1 == state){

        }
        if (lauchAt - 2 == state){

        }
        if (lauchAt - 3 == state){

        }
        if (lauchAt - 4 == state){

        }
        if (lauchAt - 5 == state){

        }
    }
    //determine in function of bombRange what's can be destroyed arround the bomb
    public boolean canDestroy(Direction direction) {
        Position posArroundBomb_range1 = direction.nextPosition(this.getPosition());
        Position posArroundBomb_range2 = direction.nextPosition(posArroundBomb_range1);
        if (game.getPlayer().getBombRange()>1){
            if (game.getWorld().get(posArroundBomb_range1) instanceof Box){
                return true;
            }
            else if (game.getWorld().get(posArroundBomb_range2) instanceof Box){
                return true;
            }
        }
        else {
            if (game.getWorld().get(posArroundBomb_range1) instanceof Box){
                return true;
            }
        }
        return false;
    }
=======
>>>>>>> 54d0d85ad265f5fd377cebd0b60232aa80927c16:src/main/java/fr/ubx/poo/model/go/Bombs.java
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
<<<<<<< HEAD:src/main/java/fr/ubx/poo/model/go/Bomb.java
    }
=======
    } 
>>>>>>> 54d0d85ad265f5fd377cebd0b60232aa80927c16:src/main/java/fr/ubx/poo/model/go/Bombs.java
}
