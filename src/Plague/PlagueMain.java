package Plague;

import SimStation.SimStationPanel;

public class PlagueMain {
    public static void main(String[] args){
        PlagueFactory factory = new PlagueFactory();
        SimStationPanel panel = new SimStationPanel(factory);
        panel.display();

    }
}
