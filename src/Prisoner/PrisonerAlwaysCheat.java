package Prisoner;

import java.io.Serializable;

public class PrisonerAlwaysCheat implements IPrisoner, Serializable {

    @Override
    public boolean cooperate(boolean lastCoaporation ) {
        return false;
    }
}
