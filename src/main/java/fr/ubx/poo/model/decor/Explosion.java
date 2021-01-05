package fr.ubx.poo.model.decor;

import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.go.GameObject;

public class Explosion extends GameObject {
    public Explosion(Game game, Position position) {
        super(game, position);
    }

    public String toString() {
        return "Explosion";
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }
}
