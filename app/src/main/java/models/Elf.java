package models;

public class Elf extends Hero {

    public Elf(){
        super.setHealth(100);
        super.setMaxHealth(100);
        super.setAttackPower(20);
        super.setAttackSpeed(60);
        super.setDefense(50);
    }

    public Elf(int health, int attackPower, int attackSpeed, int defense, int exp){
        setHealth(health);
        setAttackPower(attackPower);
        setAttackSpeed(attackSpeed);
        setDefense(defense);
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
