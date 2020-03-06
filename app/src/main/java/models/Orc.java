package models;

public class Orc extends Enemy {

    public Orc(){
        super.setHealth(40);
        super.setAttackPower(15);

    }

    public Orc(int health, int attackPower, int attackSpeed, int defense){
        setHealth(health);
        setAttackPower(attackPower);

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
