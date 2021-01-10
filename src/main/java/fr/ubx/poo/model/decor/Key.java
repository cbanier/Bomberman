package fr.ubx.poo.model.decor;

public class Key extends Decor{
    @Override
    public String toString() {return "Key";}


    public boolean canWalkOnP() {
        return true;
    }

    public boolean canWalkOnM() {
        return true;
    }
}
