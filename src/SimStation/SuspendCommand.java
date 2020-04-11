package SimStation;

import mvc.Command;
import mvc.Model;


public class SuspendCommand extends Command {

	public SuspendCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		SimStation simStation = (SimStation) model;
		simStation.suspend();
	}

}
