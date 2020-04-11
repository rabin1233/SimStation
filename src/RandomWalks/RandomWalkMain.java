package RandomWalks;

import SimStation.SimStationPanel;

public class RandomWalkMain {
    public static void main(String[] args){
        RandomWalkFactory factory = new RandomWalkFactory();
        SimStationPanel panel = new SimStationPanel(factory);
        panel.display();

    }
}
