package fr.ubx.poo.model.go;


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
    //make the destruction
    public void doDestroy() {
        for (Direction d : Direction.values()){
            if (canDestroy(d)){
                //effacer l'élément en question
            }
        }
    }
}
