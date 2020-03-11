package models;

public abstract class Enemy extends Character {
    protected int experienceWorth;
    protected int hitNum;

    public int getExperienceWorth() {
        return experienceWorth;
    }

    public void setExperienceWorth(int experienceWorth) {
        this.experienceWorth = experienceWorth;
    }

    public int getHitNum() {
        return hitNum;
    }

    public void setHitNum(int hitNum) {
        this.hitNum = hitNum;
    }
}
