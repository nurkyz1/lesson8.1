package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == this) {
                heroes[i].setDamage(heroes[i].getDamage() * RPG_Game.random.nextInt(4) + 2);
            }
        }
    }
}
