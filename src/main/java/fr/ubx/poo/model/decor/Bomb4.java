package fr.ubx.poo.model.decor;

import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.go.Bombs;
import fr.ubx.poo.model.go.GameObject;

public class Bomb4 extends Bombs {
    public Bomb4(Game game, Position position) {
        super(game, position);
    }

    public String toString() {
        return "Bomb4";
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }
}