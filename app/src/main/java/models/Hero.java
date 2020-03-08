package models;

public abstract class Hero extends Character {
    protected int exp;
    protected int MaxHealth;
    protected int blockChance;
    protected int dodgeChance;

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

    public int getBlockChance() {
        return blockChance;
    }

    public void setBlockChance(int blockChance) {

        if(blockChance <= 30){
            this.blockChance = blockChance;
        }
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
        if(dodgeChance <= 10) {
            this.dodgeChance = dodgeChance;
        }

    }

    abstract public void levelUp();
    @Override
    public String toString(){
        return new StringBuilder(super.toString()).
                append("\nExperience: ").append(getExp()).toString();

    }
}
