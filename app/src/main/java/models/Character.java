package models;

import java.util.Random;

public abstract class Character {
    protected int health;
    protected int attackPower;
    protected int attackSpeed;
    protected int defense;
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

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
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
                append("\nAttack Power: ").append(getAttackPower()).
                append("\nAttack Speed: ").append(getAttackSpeed()).
                append("\nDefense: ").append(getDefense()).toString();
    }
}
