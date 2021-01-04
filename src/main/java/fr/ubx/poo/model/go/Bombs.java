package fr.ubx.poo.model.go;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.decor.BombNumberInc;


public class Bombs extends GameObject{
    public Bombs(Game game, Position position){
        super(game,position);
    }

    public void bombActions(){
        for(Direction d : Direction.values()){
            Position nextPos = d.nextPosition(getPosition());
            /// to do
        }
    }

}
