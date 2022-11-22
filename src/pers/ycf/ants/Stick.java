package pers.ycf.ants;

public class Stick {
    private Ant[] ants;
    //length of stick
    private int stickL;



    public Stick(){
        this.ants = new Ant[5];
        int[] startPoints = new int[]{30, 80, 110, 160, 250};
        for (int i = 0; i < 5; i++) {
            ants[i] = new Ant(i, 5, startPoints[i]);
        }
        this.stickL = 300;
    }

    /**
     * reset all ants to origin place
     */
    public void refresh(){
        for (Ant ant : ants) {
            ant.setCurP(ant.getStartP());
            ant.setOnTheStick(true);
        }
    }

    /**
     * @return whether all ants have left the stick
     */
    public boolean isAllFinished(){
        for (Ant ant : ants) {
            if (ant.isOnTheStick()) return false;
        }
        return true;
    }

    /**
     * the next state by t time
     * @param t the move time of ants
     */
    public void updateState(int t){
        for (Ant ant : ants) {
            if (ant.isOnTheStick())
                ant.setCurP( ant.getCurP() + ant.getSpeed() * t * ant.getDirection() );
        }
        //check whether they meet and change their directions
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                if (ants[i].isOnTheStick() && ants[i].getCurP() == ants[j].getCurP()){
                    ants[i].reverse();
                    ants[j].reverse();
                }
            }
        }
        //check whether the ant meet the exit and update the state of ant
        for (Ant ant : ants) {
            if (ant.getCurP() == 0 || ant.getCurP() == stickL) {
                ant.setOnTheStick(false);
            }
        }

    }



    public Ant[] getAnts() {
        return ants;
    }


    public int getStickL() {
        return stickL;
    }

}
