package pers.ycf.ants;

public class Ant {
    private int id;
    private int speed;
    private int startP;
    private int curP;
    private int direction; //1 is right, -1 is left
    private boolean isOnTheStick;

    public Ant(int id, int speed, int startP) {
        this.id = id;
        this.speed = speed;
        this.startP = startP;
        this.isOnTheStick = true;
    }

    public void reverse(){
        this.direction *= -1;
    }

    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }
    public int getStartP() {
        return startP;
    }


    public int getCurP() {
        return curP;
    }

    public void setCurP(int curP) {
        this.curP = curP;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isOnTheStick() {
        return isOnTheStick;
    }

    public void setOnTheStick(boolean onTheStick) {
        isOnTheStick = onTheStick;
    }
}
