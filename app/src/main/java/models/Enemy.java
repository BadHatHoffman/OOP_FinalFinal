package models;

public abstract class Enemy extends Character {
    protected int experienceWorth;

    public int getExperienceWorth() {
        return experienceWorth;
    }

    public void setExperienceWorth(int experienceWorth) {
        this.experienceWorth = experienceWorth;
    }
}
