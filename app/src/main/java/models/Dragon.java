package models;

public class Dragon extends Enemy {

    private int damageModifier;

    public Dragon(int health, int attackPower, int attackSpeed, int defense, int damageModifier){
        setHealth(health);
        setAttackPower(attackPower);
        setAttackSpeed(attackSpeed);
        setDefense(defense);
        setDamageModifier(damageModifier);
    }

    public int getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(int damageModifier) {
        this.damageModifier = damageModifier;
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public void setAttackPower(int attackPower) {
        super.setAttackPower(attackPower);
    }

    @Override
    public void setAttackSpeed(int attackSpeed) {
        super.setAttackSpeed(attackSpeed);
    }

    @Override
    public void setDefense(int defense) {
        super.setDefense(defense);
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
    }

    @Override
    public int attack(int roll) {
        return 0;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString()).append("\n").toString();
    }

}
