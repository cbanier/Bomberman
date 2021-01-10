package fr.ubx.poo.model.decor;

public class DoorPrevOpened extends Decor{
    @Override
    public String toString() {return "DoorPrevOpened";}

    public boolean canWalkOnP() {
        return true;
    }

    public boolean canWalkOnM() {
        return false;
    }
}
