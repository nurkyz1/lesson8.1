package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Berserk extends Hero{
    public Berserk(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i <heroes.length ; i++) {
            if (heroes[i]==this) {
                heroes[i].setDamage(heroes[i].getDamage() + boss.getDamage() / 2);
                boss.setHealth(-heroes[i].getDamage() + boss.getDamage() / 2);
            }
        }

    }
}
