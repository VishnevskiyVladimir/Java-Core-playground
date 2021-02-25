package generics.game.hero;


import generics.game.weapon.RangeWeapon;

public class Archer<T extends RangeWeapon> extends Hero<T> {

    public Archer(String name, T weapon) {
        super(name, weapon);
    }
}
