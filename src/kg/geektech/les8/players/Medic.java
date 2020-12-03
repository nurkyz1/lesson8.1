package kg.geektech.les8.players;

public class Medic extends Hero{
    private int healPoints;
    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            //if(heroes[i].getHealth() > 0 && heroes[i] != this)
            if(heroes[i].getHealth() > 0 && !(heroes[i] instanceof Medic))
            heroes[i].setHealth(heroes[i].getHealth() + healPoints);
        }
    }
}
