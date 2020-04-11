package RandomWalks;

import SimStation.SimStationFactory;
import mvc.Model;
public class RandomWalkFactory extends SimStationFactory {
    @Override
    public Model makeModel() {
        return  new RandomWalk();
    }
}
