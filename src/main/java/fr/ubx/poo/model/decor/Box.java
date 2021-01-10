package fr.ubx.poo.model.decor;

public class Box extends Decor{

    public boolean canWalkOnP() {
        return true;
    }

    public boolean canWalkOnM() {
        return false;
    }

    @Override
    public String toString() {
        return "Box";
    }
}
