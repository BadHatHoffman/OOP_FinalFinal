package models;

public class Dragon extends Character {

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
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public int getAttackPower() {
        return super.getAttackPower();
    }

    @Override
    public int getAttackSpeed() {
        return super.getAttackSpeed();
    }

    @Override
    public int getDefense() {
        return super.getDefense();
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
