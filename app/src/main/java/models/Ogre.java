package models;

public class Ogre extends Enemy {

    public Ogre(){
        super.setHealth(rng.nextInt(20)+50);
        super.setAttackPower(rng.nextInt(3)+12);
        super.setExperienceWorth(65);
        super.setHitNum(10);
    }

    public Ogre(int health, int attackPower, int experienceWorth, int hitNum, int level){
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

