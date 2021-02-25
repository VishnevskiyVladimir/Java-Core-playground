package generics.game.hero;


import generics.game.weapon.Weapon;

public abstract class Hero<T extends Weapon> {
    private String name;
    private T weapon;

    public Hero(String name, T weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public void attack() {
        System.out.println("Attacking by " + weapon.getClass());
        System.out.println("Damage is " + weapon.getDamage());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getWeapon() {
        return weapon;
    }

    public void setWeapon(T weapon) {
        this.weapon = weapon;
    }
}
