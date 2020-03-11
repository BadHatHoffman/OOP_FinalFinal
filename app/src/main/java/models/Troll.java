package models;

public class Troll extends Enemy {

    public Troll(){
        super.setHealth(30);
        super.setAttackPower(10);
        super.setExperienceWorth(40);
        super.setHitNum(7);

    }

    public Troll(int health, int attackPower, int experienceWorth, int hitNum, int level){
        setHealth(health);
        setAttackPower(attackPower);
        setExperienceWorth(experienceWorth);
        setHitNum(hitNum);
        setLevel(level);

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
    public void setExperienceWorth(int experienceWorth) {
        super.setExperienceWorth(experienceWorth);
    }

    @Override
    public void setHitNum(int hitNum) {
        super.setHitNum(hitNum);
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

