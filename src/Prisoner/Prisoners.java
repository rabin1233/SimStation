package Prisoner;

import SimStation.Agent;
import SimStation.SimStation;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Prisoners extends SimStation {
    private final int numberOfAgents = 50;

    @Override
    public void populate() {
        agents = new ArrayList<Agent>();
        int cnt = 0;
        for (int i = 0; i < numberOfAgents; i++) {
            Agent agent = new Agent();
            // todo
            agent = new PrisonerAgent(this);
            if (cnt == 0) {
                ((PrisonerAgent) agent).setStrategy(new PrisonerAlwaysCooperate());
            } else if (cnt == 1) {
                ((PrisonerAgent) agent).setStrategy(new PrisonerAlwaysCheat());

            } else if (cnt == 2) {
                ((PrisonerAgent) agent).setStrategy(new PrisonerRandomCooperate());

            } else {
                ((PrisonerAgent) agent).setStrategy(new PrisonerCooperateWithCondition());
            }
            cnt++;
            cnt %= 4;
            agents.add(agent);
            agent.start();
        }
    }

    @Override
    protected void do100ClockStuff() {
        String[] stats =   getStats();
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i]);
        }
    }

    private double[] countPrisoners() {
        int[] cnt = new int[4];
        int[] avg = new int[4];
        double[] ret = new double[4];
        for (Agent agent : agents) {
            if (((PrisonerAgent) agent).strategy.getClass().getName() == "Prisoner.PrisonerAlwaysCooperate") {
                cnt[0]++;
                avg[0] += ((PrisonerAgent) agent).fitness;

            } else if (((PrisonerAgent) agent).strategy.getClass().getName() == "Prisoner.PrisonerAlwaysCheat") {
                cnt[1]++;
                avg[1] += ((PrisonerAgent) agent).fitness;

            } else if (((PrisonerAgent) agent).strategy.getClass().getName() == "Prisoner.PrisonerRandomCooperate") {
                cnt[2]++;
                avg[2] += ((PrisonerAgent) agent).fitness;

            } else {
                cnt[3]++;
                avg[3] += ((PrisonerAgent) agent).fitness;

            }
        }
        for (int i = 0; i < 4; i++) {
            ret[i] = avg[i] * 1.0 / cnt[i] * 1.0;
        }
        return ret;
    }

    @Override
    public String[] getStats() {
        String[] stats = new String[3];
        stats[0] = "#Prisoners = " + agents.size();
        stats[1] = "clock = " + clock;
        double[] ret = countPrisoners();
        DecimalFormat df = new DecimalFormat("#.00");
        stats[2] = "#Prisoners Fitness Average:\nPrisonerAlwaysCooperate: " + df.format(ret[0]) + "\nPrisonerAlwaysCheat: " + df.format(ret[1])
                + "\nPrisonerRandomCooperate: " + df.format(ret[2]) + "\nPrisonerCooperateWithCondition: " + df.format(ret[3]) + "\n";
        return stats;
    }

}
