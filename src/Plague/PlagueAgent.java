package Plague;

import SimStation.Agent;

import java.awt.*;
import java.util.Random;

public class PlagueAgent extends Agent {
    Plague plague;
    public PlagueAgent() {
        this.globalMaxSpeed = 10;
        Random rand = new Random();
        heading = getRandomHeading();
        agentState = AgentState.READY;
        nextStep = rand.nextInt(globalMaxSpeed + 1);
    }
    public PlagueAgent(Plague plague)
    {
        this.plague = plague;
        this.globalMaxSpeed = plague.globalMaxSpeed;
        Random rand = new Random();
        heading = getRandomHeading();
        agentState = AgentState.READY;
        int min = 1 , max =plague.globalMaxSpeed;
        nextStep = rand.nextInt((max - min) + 1) + min;
    }
    @Override
    public void update() {

        Agent bird = plague.getNeighbor(this);
        if(bird.getColor() == Color.red && color == Color.green)
        {
            Random random = new Random();
            int infection = random.nextInt(100);
            if(infection < Plague.getRESISTANCE())
            {
                // not infected
                this.setColor(Color.green);
            }
            else // infected
                this.setColor(Color.red);
        }
        move(nextStep);
    }

}
