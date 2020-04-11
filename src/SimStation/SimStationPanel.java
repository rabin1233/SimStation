package SimStation;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class SimStationPanel extends AppPanel {


	public SimStationPanel(AppFactory factory) {
		super(factory);
		SimulationView view = new SimulationView((SimStation) model);
		//addView(view);
		this.setLayout(new GridLayout(1, 2));
		//this.setLayout(new BorderLayout());

		JButton start = new JButton("Start");
		start.addActionListener(this);


		JButton suspend = new JButton("Suspend");
		suspend.addActionListener(this);

		JButton resume = new JButton("Resume");
		resume.addActionListener(this);


		JButton stop = new JButton("Stop");
		stop.addActionListener(this);

		JButton stats = new JButton("Stats");
		stats.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		

		buttonPanel.add(start) .setLocation(2,2);
		buttonPanel.add(suspend).setLocation(5,5);;
		buttonPanel.add(resume);
		buttonPanel.add(stop);
		buttonPanel.add(stats);
		
//		suspend.setLayout(new GridLayout(4,5));
		
		add(buttonPanel, "West");
		add(view, "East");

	}



}
