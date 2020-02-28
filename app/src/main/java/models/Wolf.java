package models;

public class Wolf extends Hero {

    public Wolf(int health, int attackPower, int attackSpeed, int defense, int exp){
        setHealth(health);
        setAttackPower(attackPower);
        setAttackSpeed(attackSpeed);
        setDefense(defense);
        setExp(exp);
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
    public int getExp() {
        return super.getExp();
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
