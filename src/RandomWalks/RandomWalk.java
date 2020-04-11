package RandomWalks;

import SimStation.Agent;
import SimStation.SimStation;

import java.util.ArrayList;

public class RandomWalk extends SimStation {
     private final int numberOfAgents = 50;
     private final int globalMaxSpeed = 10;


    @Override
    public void populate() {
         agents = new ArrayList<Agent>();
        for (int i = 0; i < numberOfAgents; i++) {
             Agent agent = new DrunkAgent();
             agents.add(agent);
             agent.start();
//             agent.run();
        }

    }

    @Override
    public String[] getStats() {
        String[] stats = new String[2];
        stats[0] = "#agents = " + agents.size();
        stats[1] = "clock = " + clock;
        return stats;
    }
}
