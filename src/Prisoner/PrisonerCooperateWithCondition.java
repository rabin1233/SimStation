package Prisoner;

import java.io.Serializable;

public class PrisonerCooperateWithCondition implements IPrisoner, Serializable {
    @Override
    public boolean cooperate( boolean lastCoaporation) {
        return lastCoaporation;
    }
}
