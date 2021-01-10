package fr.ubx.poo.model.decor;

public class BombRangeInc extends Decor{
    

    @Override
    public boolean canWalkOnP() {
        return true;
    }

    public boolean canWalkOnM() {
        return true;
    }
    public String toString() {return "BombRangeInc";}
}
