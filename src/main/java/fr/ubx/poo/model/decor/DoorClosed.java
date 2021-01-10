package fr.ubx.poo.model.decor;

public class DoorClosed extends Decor{
   

    @Override
    public boolean canWalkOnP() {
        return false;
    }

    public boolean canWalkOnM() {
        return false;
    }

    public String toString() {return "DoorClosed"; }
}
