package Prisoner;

import SimStation.SimStationFactory;
import mvc.Model;

public class PrisonerFactory extends SimStationFactory {
    @Override
    public Model makeModel() {
        return new Prisoners();
    }
}
