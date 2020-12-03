package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Thor extends Hero {
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUN_THE_BOSS);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean stun = RPG_Game.random.nextBoolean();
        if (stun == true) {
            boss.setDamage(boss.getDamage() - 50);
        }else {
            for (int i = 0; i < heroes.length; i++) {

                if (heroes[i].getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                }
            }
        }
        }

    }

