package Prisoner;

import java.io.Serializable;
import java.util.Random;

public class PrisonerRandomCooperate implements IPrisoner, Serializable {
    @Override
    public boolean cooperate(boolean lastCoaporation) {
        Random random = new Random();
        int num = random.nextInt(1000);
        return num %2 == 0;

    }
}
