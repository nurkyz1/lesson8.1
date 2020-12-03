package kg.geektech.les8.players;

public abstract class Hero extends GameEntity
        implements HavingSuperPower {
    SuperAbility superAbility;
    public Hero(int health, int damage,
                SuperAbility superAbility) {
        super(health, damage);
        this.superAbility = superAbility;
    }

    public SuperAbility getSuperAbility() {
        return superAbility;
    }

    public void setSuperAbility(SuperAbility superAbility) {
        this.superAbility = superAbility;
    }
}
