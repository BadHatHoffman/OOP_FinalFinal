package models;

public class Dragon extends Enemy {

    private int damageModifier;

    public Dragon(){
        super.setHealth(300);
        super.setAttackPower(20);
        super.setExperienceWorth(300);
        super.setHitNum(10);

    }
    public Dragon(int health, int attackPower, int attackSpeed, int defense, int damageModifier){
        setHealth(health);
        setAttackPower(attackPower);
        setDamageModifier(damageModifier);
    }

    public int getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(int damageModifier) {
        this.damageModifier = damageModifier;
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
