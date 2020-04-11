package Prisoner;

import SimStation.Agent;

import java.util.Random;

public  class PrisonerAgent extends Agent  {

    IPrisoner strategy;
    // todo: make a variable of the IPrisoner so it would cooaprate or nor
    // options: 1- radndomy inside the prisoner agent
    // 2- count from the first
    public int fitness = 0;
    protected Prisoners prisoners;
    public boolean lastCoaporation;
    public PrisonerAgent() {
        this.globalMaxSpeed = 10;
        Random rand = new Random();
        heading = getRandomHeading();
        agentState = AgentState.READY;
        nextStep = rand.nextInt(globalMaxSpeed + 1);
    }
    public PrisonerAgent(Prisoners p)
    {
        this.prisoners = p;
        this.globalMaxSpeed = p.globalMaxSpeed;
        Random rand = new Random();
        heading = getRandomHeading();
        agentState = AgentState.READY;
        int min = 1 , max =p.globalMaxSpeed;
        nextStep = rand.nextInt((max - min) + 1) + min;
    }

    public void setStrategy(IPrisoner strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update() {
        //todo: implement this
        Agent prisonersNeighbor = prisoners.getNeighbor(this);
        // todo: implement this, to find the neighbour
        PrisonerAgent agent = (PrisonerAgent) prisonersNeighbor;


        updateFitness(this, agent);
        move(nextStep);
    }
    protected void updateFitness(PrisonerAgent a1 , PrisonerAgent a2)
    {
        boolean me = a1.strategy.cooperate(a1.lastCoaporation) ,  him = a2.strategy.cooperate(a2.lastCoaporation);
        if(me && him)
        {
            a1.fitness += 3;
            a2.fitness += 3;
            a1.lastCoaporation = true;
            a2.lastCoaporation = true;
        }
        if(!me && him)
        {
            a1.fitness+= 5;
            a1.lastCoaporation = true;
            a2.lastCoaporation = false;
        }
        if (me && !him)
        {
            a2.fitness+=5;
            a1.lastCoaporation = false;
            a2.lastCoaporation = true;
        }
        if(!me && !him)
        {
            a1.fitness += 1;
            a2.fitness += 1;
            a1.lastCoaporation = false;
            a2.lastCoaporation = false;
        }
    }
}
