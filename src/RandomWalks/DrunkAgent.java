package RandomWalks;

import SimStation.Agent;

import java.util.Random;

public class DrunkAgent extends Agent {


    public DrunkAgent() {
        this.globalMaxSpeed = 10;
        Random rand = new Random();
        heading = getRandomHeading();
        agentState = AgentState.READY;
        nextStep = rand.nextInt(globalMaxSpeed + 1);
    }

    @Override
    public void update() {
        Random rand = new Random();
        int max = globalMaxSpeed , min   = 1;
        nextStep = rand.nextInt(((max - min) + 1) + min);
        move(nextStep);
    }


}
