package models;

public class Human extends Hero{

    public Human(){
        super.setHealth(120);
        super.setMaxHealth(120);
        super.setAttackPower(15);
        super.setBlockChance(30);
        super.setDodgeChance(10);
    }

    public Human(int health, int attackPower, int blockChance, int dodgeChance, int exp){
        setHealth(health);
        setAttackPower(attackPower);
        setBlockChance(blockChance);
        setDodgeChance(dodgeChance);
        setExp(exp);
    }

    @Override
    public void setMaxHealth(int maxHealth) {
        super.setMaxHealth(maxHealth);
    }

    @Override
    public void setExp(int exp) {
        super.setExp(exp);
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
    public void setBlockChance(int blockChance) {
        super.setBlockChance(blockChance);
    }

    @Override
    public void setDodgeChance(int dodgeChance) {
        super.setDodgeChance(dodgeChance);
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
