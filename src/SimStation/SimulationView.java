package SimStation;

import mvc.View;

import java.awt.*;

public class SimulationView extends View {


    public SimulationView(SimStation light) {
        super(light);

    }

    public void paintComponent(Graphics gc) {
        SimStation simStation = (SimStation) model;
        Graphics2D g2 = (Graphics2D) gc;
        Color oldColor = gc.getColor();
        if(simStation.agents != null) {
            for (Agent agent : simStation.agents) {
                g2.setColor(agent.color);
                g2.fillRect(agent.xc, agent.yc, 4, 4);
            }
        }
        g2.setColor(oldColor);
    }

}
