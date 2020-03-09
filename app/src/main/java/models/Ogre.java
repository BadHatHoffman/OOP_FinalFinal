package models;

public class Ogre extends Enemy {

    public Ogre(){
        super.setHealth(40);
        super.setAttackPower(15);
        super.setExperienceWorth(65);
        super.setHitNum(10);
    }

    public Ogre(int health, int attackPower, int attackSpeed, int defense){
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

