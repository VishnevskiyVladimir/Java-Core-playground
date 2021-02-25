package generics.game;


import generics.game.hero.Archer;
import generics.game.hero.Hero;
import generics.game.hero.Strelok;
import generics.game.weapon.Bow;
import generics.game.weapon.Gun;
import generics.game.weapon.Weapon;

public class WeaponRunner {
    public static void main(String[] args) {
        Archer<Bow> archer = new Archer<>("legolas", new Bow());
        Strelok<Gun> roland = new Strelok<>("legolas", new Gun());

        printWeaponDamage(archer);
        printWeaponDamage(roland);

    }

    public static <T extends Weapon> void printWeaponDamage(Hero<T> hero) {
        System.out.println(hero.getWeapon().getDamage());
    }

}
