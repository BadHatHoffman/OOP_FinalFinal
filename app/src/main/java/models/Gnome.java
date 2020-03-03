package models;

public class Gnome extends Enemy {

    public Gnome(){
        super.setHealth(20);
        super.setAttackPower(5);
        super.setAttackSpeed(60);
        super.setDefense(10);
    }

    public Gnome(int health, int attackPower, int attackSpeed, int defense){
        setHealth(health);
        setAttackPower(attackPower);
        setAttackSpeed(attackSpeed);
        setDefense(defense);
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
