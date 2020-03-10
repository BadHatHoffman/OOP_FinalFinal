package models;

public class Elf extends Hero {

    public Elf(){
        super.setHealth(100);
        super.setMaxHealth(100);
        super.setAttackPower(20);
        super.setBlockChance(30);

    }

    public Elf(int health, int attackPower, int blockChance, int exp){
        setHealth(health);
        setAttackPower(attackPower);
        setBlockChance(blockChance);
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
    public void levelUp() {
        setMaxHealth(getMaxHealth() + 6);
        setHealth(getMaxHealth());
        setAttackPower(getAttackPower() + 6 );
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
