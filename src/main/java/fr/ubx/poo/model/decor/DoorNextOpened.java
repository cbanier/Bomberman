package fr.ubx.poo.model.decor;

public class DoorNextOpened extends Decor{
    @Override
    public String toString() {return "DoorNextOpened";}

    public boolean canWalkOnP() {
        return true;
    }
    public boolean canWalkOnM() {
        return false;
    }
}
