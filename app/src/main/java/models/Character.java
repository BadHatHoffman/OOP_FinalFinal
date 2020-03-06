package models;

import java.util.Random;

public abstract class Character {
    protected int health;
    protected int attackPower;
    protected int level;
    public Random rng = new Random();


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int roll(int quantity, int sides){
        int roll = 0;
        for(int i = 0; i < quantity; i++){
            roll += rng.nextInt(sides) + 1 ;
        }
        return roll;
    }

    public abstract int attack(int roll);

    @Override
    public String toString(){
        return new StringBuilder(this.getClass().getSimpleName()).
                append("\nHealth: ").append(getHealth()).
                append("\nAttack Power: ").append(getAttackPower()).toString();
    }
}
