package fr.ubx.poo.model.decor;

public class BombNumberInc extends Decor{
    

    @Override
    public boolean canWalkOnP() {
        return true;
    }

    public boolean canWalkOnM() {
        return true;
    }
    public String toString() {return "BombNumberInc";}
}
