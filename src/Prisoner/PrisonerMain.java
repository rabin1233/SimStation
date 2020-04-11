package Prisoner;

import SimStation.SimStationPanel;

public class PrisonerMain {
    public static void main(String[] args){
        PrisonerFactory factory = new PrisonerFactory();
        SimStationPanel panel = new SimStationPanel(factory);
        panel.display();

    }
}
