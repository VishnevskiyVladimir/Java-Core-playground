package generics.game.hero;


import generics.game.weapon.Weapon;

public class Strelok<Gun extends Weapon> extends Hero<Gun> {

    public Strelok(String name, Gun gun) {
        super(name, gun);
    }
}
