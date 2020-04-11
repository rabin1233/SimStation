package Plague;

import SimStation.SimStationFactory;
import mvc.Model;

public class PlagueFactory extends SimStationFactory {
    @Override
    public Model makeModel() {
        return  new Plague();
    }
}
