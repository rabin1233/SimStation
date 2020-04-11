package SimStation;

import mvc.Command;
import mvc.Model;


public class StopCommand extends Command {

	public StopCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		SimStation simStation = (SimStation) model;
		simStation.stop();
	}

}
