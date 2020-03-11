package models;

public class Dragon extends Enemy {

    private int damageModifier;

    public Dragon(){
        super.setHealth(400);
        super.setAttackPower(20);
        super.setExperienceWorth(300);
        super.setHitNum(10);

    }
    public Dragon(int health, int attackPower, int experienceWorth, int hitNum, int level, int damageModifier){
        setHealth(health);
        setAttackPower(attackPower);
        setExperienceWorth(experienceWorth);
        setHitNum(hitNum);
        setLevel(level);
        setDamageModifier(damageModifier);

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

    public int getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(int damageModifier) {
        this.damageModifier = damageModifier;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString()).append("\n").toString();
    }


}
