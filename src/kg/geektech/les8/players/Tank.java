package kg.geektech.les8.players;

public class Tank extends Hero {
    public Tank(int health, int damage) {
        super(health, damage,SuperAbility.DEFENDER);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i <heroes.length ; i++) {

               heroes[i].setHealth(heroes[i].getHealth()+boss.getDamage()/5);
               heroes[i].setHealth(heroes[i].getHealth()-boss.getDamage()/5);

        }
    }
}
