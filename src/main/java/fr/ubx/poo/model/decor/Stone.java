/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.decor;

public class Stone extends Decor {
    @Override
    public String toString() {
        return "Stone";
    }

    public boolean canWalkOnP() {
        return false;
    }

    public boolean canWalkOnM() {
        return false;
    }
}
