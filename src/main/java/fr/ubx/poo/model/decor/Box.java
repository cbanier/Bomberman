package fr.ubx.poo.model.decor;

public class Box extends Decor{
    

    @Override
    public boolean canWalkOnP() {
        return true;
    }

    public boolean canWalkOnM() {
        return false;
    }

    public String toString() {return "Box";}
}
