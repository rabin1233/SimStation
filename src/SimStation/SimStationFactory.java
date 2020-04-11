package SimStation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;

public abstract class SimStationFactory implements AppFactory {

    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    public String getTitle() {
        return "SimStation";
    }

    public String[] getHelp() {
        return new String[]{"This program runs the simulation of something"};
    }

    public String about() {
        return "SimStation version 1.0. Copyright 2020 by Cyberdellic Designs";
    }

    public Command makeEditCommand(Model model, String type) {


        if (type.equals("Start"))
            return new StartCommand(model);

        if (type.equals("Suspend"))
            return new SuspendCommand(model);

        if (type.equals("Resume")) {
            return new ResumeCommand(model);
        }
         if (type.equals("Stop")) {
                    return new StopCommand(model);
                }

        if (type.equals("Stats"))
            return new StatsCommand(model);


        return null;

    }

}
