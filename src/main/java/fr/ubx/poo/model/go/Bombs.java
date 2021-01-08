package fr.ubx.poo.model.go;


import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;


public class Bombs extends GameObject{
    private int stateBomb;

    public Bombs(Game game, Position position){
        super(game,position);
        this.stateBomb=0;
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

    /*
    // EQUIVALENT DE DOMOVE POUR LES MOVABLE
    // TO DO ++++++
    public void doExplosion(long state) {

    }
    //determine in function of bombRange what's can be destroyed arround the bomb
    public boolean canDestroy(Direction direction) {
        Position posArroundBomb_range1 = direction.nextPosition(getBombToExplosePos());
        Position posArroundBomb_range2 = direction.nextPosition(posArroundBomb_range1);
        if (getBombRange()>1){
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
    } */
}
