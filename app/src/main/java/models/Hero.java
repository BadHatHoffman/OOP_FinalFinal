package models;

public abstract class Hero extends Character {
    protected int exp;
    protected int MaxHealth;

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMaxHealth() {
        return MaxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        MaxHealth = maxHealth;
    }

    @Override
    public String toString(){
        return new StringBuilder(super.toString()).
                append("\nExperience: ").append(getExp()).toString();

    }
}
