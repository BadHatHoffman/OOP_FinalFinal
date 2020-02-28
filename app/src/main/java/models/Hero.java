package models;

public abstract class Hero extends Character{
    protected int exp;

    public Hero(){

    }


    public Hero(int exp) {
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString(){
        return new StringBuilder(super.toString()).
                append("\nExperience: ").append(getExp()).toString();

    }
}
