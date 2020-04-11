package Plague;

import SimStation.Agent;
import SimStation.SimStation;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Plague extends SimStation {
    private final int numberOfAgents = 50;

    public static int VIRULENCE = 20; // % chance of infection
    public static int RESISTANCE = 30; // % chance of resisting infection

    public static int getRESISTANCE() {
        return RESISTANCE;
    }

    @Override
    public void populate() {
        agents = new ArrayList<Agent>();
        for (int i = 0; i < numberOfAgents; i++) {
            Agent agent = new PlagueAgent(this);
            setInfectionRandomly(agent);
            agents.add(agent);
            agent.start();
        }
    }

    @Override
    public String[] getStats() {
        String[] stats = new String[3];
        stats[0] = "#agents = " + agents.size();
        stats[1] = "clock = " + clock;
        stats[2] = "% infected = " + calculateInfected();
        return stats;
    }

    private double calculateInfected() {
        int infected = 0;
        for (Agent agent : agents)
        {
//
           if(agent.getColor() == Color.red)
               infected++;

        }
        return infected  * 1.0 / agents.size() * 1.0 * 100.0 ;
    }
    public static void  setInfectionRandomly(Agent agent)
    {
        Random random = new Random();
        int infection = random.nextInt(100);
        if(infection > VIRULENCE)
        {
            //not infected
            agent.setColor(Color.green);
        }else
        {
            // check the resistance rate
            infection = random.nextInt(100);
            if(infection < RESISTANCE )
            {
                // not infected
                agent.setColor(Color.green);
            }
            else // infected
                agent.setColor(Color.red);

        }

    }
}
