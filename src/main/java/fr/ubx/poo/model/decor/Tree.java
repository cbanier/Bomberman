/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.decor;


public class Tree extends Decor {
    @Override
    public String toString() {
        return "Tree";
    }

    public boolean canWalkOnP() {
        return false;
    }

    public boolean canWalkOnM() {
        return false;
    }
}
