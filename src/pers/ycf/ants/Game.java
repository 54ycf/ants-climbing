package pers.ycf.ants;

import java.util.ArrayList;
import java.util.List;


public class Game {

    private Stick stick;
    private int condition;

    public Game(){
        stick = new Stick();
    }

     public void reset(){
        stick.refresh();
        for (Ant ant : stick.getAnts()) { //enumerate each case
            ant.setDirection( (condition >> ant.getId()) % 2 == 1 ? 1 : -1);
        }
        condition++;
    }

    /**
     * @return the cost time of update ants places
     */
     public int exec(){
        List<Ant> toRight = new ArrayList<>(5); //put in all ants who are going right
        List<Ant> toLeft = new ArrayList<>(5); //put in all ants who are going left
        int minTimeToRightest = Integer.MAX_VALUE;
        int minTimeToLeftest  = Integer.MAX_VALUE;
        for (Ant ant : stick.getAnts()) {
            if (ant.isOnTheStick() && ant.getDirection() == 1) {
                toRight.add(ant);
                int timeToRightest = (stick.getStickL() - ant.getCurP()) / ant.getSpeed();
                minTimeToRightest = Math.min(minTimeToRightest, timeToRightest);
            } else if (ant.isOnTheStick() && ant.getDirection() == -1) {
                toLeft.add(ant);
                int timeToLeftest = ant.getCurP() / ant.getSpeed();
                minTimeToLeftest = Math.min(minTimeToLeftest, timeToLeftest);
            }
        }

        int minMeetTime = Integer.MAX_VALUE;
        for (Ant antR : toRight) {
            for (Ant antL : toLeft) {
                int d = antL.getCurP() - antR.getCurP();
                if (d > 0) {
                    int meetTime = d / (antL.getSpeed() + antR.getSpeed());
                    minMeetTime = Math.min(minMeetTime, meetTime);
                }
            }
        }

        int minTime = Math.min(minMeetTime, Math.min(minTimeToLeftest, minTimeToRightest));
        stick.updateState(minTime);
        return minTime;
    }

    public boolean isGameOver(){
        return stick.isAllFinished();
    }
}
