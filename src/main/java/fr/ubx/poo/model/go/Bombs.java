package fr.ubx.poo.model.go;


import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;


public class Bombs extends GameObject{
    public Bombs(Game game, Position position){
        super(game,position);
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    public long bomb_time(){
        return game.getPlayer().getBombRequestedTimer();
    }

    public int bomb_getter(){
        if (bomb_time() - 1 == 0){
            return 0;
        }
        if (bomb_time() - 2 == 0){
            return 1;
        }
        if (bomb_time() - 3 == 0){
            return 2;
        }
        if (bomb_time() - 4 == 0){
            return 3;
        }
        if (bomb_time() - 5 == 0){
            return 4;
        }
        return 5;
    }

}
