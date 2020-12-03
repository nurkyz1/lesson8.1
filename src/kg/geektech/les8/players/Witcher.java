package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Witcher extends Hero {
    public Witcher(int health, int damage) {
        super(health, damage,SuperAbility.HEAL_THE_HERO);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean heal = RPG_Game.random.nextBoolean();
        for (int i = 0; i <heroes.length ; i++) {
          if (heroes[i].getHealth()<=0&& heal==true){
             heroes[i].setHealth(heroes[i].getHealth()+heroes[i].getHealth());
             this.setHealth(0);
          }
        }

    }
}
