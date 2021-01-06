package fr.ubx.poo.model.go;


import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.engine.GameEngine;


public class Bombs extends GameObject{
    GameEngine gameEngine;
    public Bombs(Game game, Position position){
        super(game,position);
    }


    public int bombActions(){
        //gestion du timer
        //retourne un entier entre 0 et 5
        return (int) gameEngine.getNow();
    }

}
