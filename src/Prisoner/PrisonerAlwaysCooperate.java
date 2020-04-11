package Prisoner;

import java.io.Serializable;

public class PrisonerAlwaysCooperate implements IPrisoner , Serializable {
    @Override
    public boolean cooperate(boolean lastCoaporation) {
        return true;
    }
}
