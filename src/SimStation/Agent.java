package SimStation;

import java.awt.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Agent extends Thread implements Serializable {
final int border =  390;
    protected int globalMaxSpeed;
    protected int nextStep;
    private boolean needUpdate;

    public enum AgentState {
        READY,
        RUNNNING,
        SUSPENDED,
        STOPPED
    }

    public enum Heading {
        WEST,
        EaST,
        NORTH,
        SOUTH
    }

    protected boolean suspended = false;
    protected int xc;
    protected int yc;
    protected Color color = Color.green;
    protected AgentState agentState = AgentState.READY;
    protected Heading heading;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNextStep() {
        return nextStep;
    }

    public Heading getHeading() {
        return heading;
    }

    public Agent() {
        Random rand = new Random();
        xc = rand.nextInt(border);
        yc = rand.nextInt(border);
    }

    @Override
    public void run() {
        while (agentState != AgentState.STOPPED) {
            if (needUpdate) {
                update();
                needUpdate = false;
            } else {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public void update() {
    }

    public void setNeedUpdate(boolean needUpdate) {
        this.needUpdate = needUpdate;

    }

    public void setAgentState(AgentState agentState) {
        this.agentState = agentState;
    }

    public AgentState getAgentState() {
        return agentState;
    }


    // turn E from current position
    private void goEast(int amount) {
//
        xc = Math.min(border, xc + amount);

    }

    // turn W from current position
    private void goWest(int amount) {
        xc = Math.max(0, xc - amount);

    }

    // draw forward a certain amount
    private void goNorth(int amount) {
        yc = Math.max(0, yc - amount);

    }

    // draw backwards a certain amount
    private void goSouth(int amount) {

        yc = Math.min(border, yc + amount);
    }


    public void move(int steps) {
        switch (heading) {
            case WEST:
                goWest(steps);
                break;
            case EaST:
                goEast(steps);
                break;
            case NORTH:
                goNorth(steps);
                break;
            case SOUTH:
                goSouth(steps);
                break;
        }

    }

    private static final List<Heading> VALUES =
            Collections.unmodifiableList(Arrays.asList(Heading.values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Heading getRandomHeading() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public double getDistance(Agent a) {
        return Math.sqrt((xc -a.xc) * (xc - a.xc) + (yc - a.yc) * (yc - a.yc));
    }


}
