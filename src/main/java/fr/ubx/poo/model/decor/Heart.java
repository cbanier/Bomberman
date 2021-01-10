package fr.ubx.poo.model.decor;

public class Heart extends Decor {
    @Override
    public String toString() {return "Heart";}

    public boolean canWalkOnP() {
        return true;
    }

    public boolean canWalkOnM() {
        return true;
    }
}
