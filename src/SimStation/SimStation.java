package SimStation;

import mvc.Model;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class SimStation extends Model  {
    public final int globalMaxSpeed = 10;
    private MyTimer timer;
    protected int clock = 0;
    protected List<Agent> agents = new ArrayList<Agent>();
    private boolean suspended = true;

    private void startTimer() {
        timer = new MyTimer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    public SimStation() {
        startTimer();
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }
    protected void timeIsNow100()
    {
        do100ClockStuff();
    }
    protected void do100ClockStuff(){};
    private class ClockUpdater extends TimerTask implements  Serializable {
        public void run() {
            if(!suspended)
                clock++;
            for (Agent agent : agents) {
//                agent.setAgentState(Agent.AgentState.RUNNNING);
                if (agent.getState() == Thread.State.TERMINATED) {
                    break;
                }
                agent.setNeedUpdate(true);
            }
                if(clock == 100)
                    timeIsNow100();
            changed();
        }
    }

    public void start() {
        suspended = false;
        populate();
    }

    public void suspend() {
        suspended = true;
        if (agents.get(0).agentState == Agent.AgentState.STOPPED) {
        JOptionPane.showMessageDialog(null, "Can't suspend simulation is stopped");
    } else
            for (Agent agent : agents) {
        agent.setAgentState(Agent.AgentState.SUSPENDED);
        agent.suspend();
    }
}

    public void resume() {

        suspended = false;

        if (agents.get(0).agentState == Agent.AgentState.STOPPED) {
            JOptionPane.showMessageDialog(null, "Can't resume simulation is stopped");
        } else
            for (Agent agent : agents) {
                agent.setAgentState(Agent.AgentState.READY);
                agent.resume();
            }
    }

    public void stop() {
        if (agents.get(0).agentState == Agent.AgentState.STOPPED) {
            JOptionPane.showMessageDialog(null, "resume simulation is stopped");
        } else
            for (Agent agent : agents) {
                agent.setAgentState(Agent.AgentState.STOPPED);

                agent.stop();
            }
    }

    public void populate() {
    }

    public void showStats() {
        String [] stats = getStats();
        String msg  = "";
        for(String s : stats)
            msg += s + "\n";

        JOptionPane.showMessageDialog(null,msg);

    }

    public String[] getStats() {
        String[] stats = new String[2];
        return stats;
    }
    public Agent getNeighbor(Agent a) {
        double minDistance = 1000000000;
        Agent neighbor = agents.get(0);
        for (Agent agent : agents) {
            if (agent.xc != a.xc && agent.yc != a.yc) {
                double tmp = a.getDistance(agent);
                if ( tmp< minDistance) {
                    minDistance = tmp;
                    neighbor = agent;
                }
            }
        }
        return neighbor;
    }
}