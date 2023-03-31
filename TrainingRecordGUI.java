// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    
    private JTextField terrain = new JTextField(6);
    private JTextField tempo = new JTextField(6);
    private JTextField repetitions = new JTextField(3);
    private JTextField recovery = new JTextField(2);
    private JTextField where = new JTextField(5);
    
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    
    private JLabel labterrain = new JLabel(" Terrain:");
    private JLabel labtempo = new JLabel(" Tempo:");
    private JLabel labrepetitons = new JLabel(" Rounds:");
    private JLabel labrecoveryTime = new JLabel(" Recovery Time:");
    private JLabel labwhere = new JLabel(" Swimming Location:");
    
    private JButton addR = new JButton("Add Entry");
    private JButton Remove = new JButton("Remove");
    private JButton lookUpByDate = new JButton("Look Up Entry");
    private JButton FindAllByDate = new JButton("Find All By Date");
    private JButton FindAllByName = new JButton("Find All");
    private JButton weeklyDistance = new JButton("Weekly Distance");
    
    private String[] activity = {"Select Activity: ", "Cycle", "Sprint", "Swim"};
    private JComboBox menu = new JComboBox<String>(activity);
    
    private String[] tempoState = {"Select Tempo: ", "slow", "moderate", "fast"}; //this is passed into the tempo combo box
    private JComboBox tempostate = new JComboBox<String>(tempoState);
     
    private String[] whereSwimLocation = {"Select Swim Location: ", "outdoor", "indoor pool"}; //this is passed into the where swim combo box
    private JComboBox whereToSwim = new JComboBox<String>(whereSwimLocation);
    
    

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(menu);
        menu.addActionListener(this);
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labterrain);
        add(terrain);
        terrain.setEditable(true);
        labterrain.setVisible(true);
        terrain.setVisible(true);
        add(labtempo);
        add(tempo);
        tempo.setEditable(true);
        labtempo.setVisible(false);
        tempo.setVisible(false);
        add(labrepetitons);
        add(repetitions);
        repetitions.setEditable(true);
        labrepetitons.setVisible(true);
        repetitions.setVisible(false);
        add(labrecoveryTime);
        add(recovery);
        recovery.setEditable(true);
        labrecoveryTime.setVisible(true);
        repetitions.setVisible(true);
        add(labwhere);
        add(where);
        labwhere.setVisible(false);
        where.setVisible(false);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(Remove);
        Remove.addActionListener(this);
        Remove.setEnabled(true);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);
        FindAllByDate.setEnabled(true);
        add(FindAllByName);
        FindAllByName.addActionListener(this);
        FindAllByName.setEnabled(true);
        add(weeklyDistance);
        weeklyDistance.addActionListener(this);
        weeklyDistance.setEnabled(true);
        add(outputArea);
        outputArea.setEditable(false);
        add(labtempo);
        add(tempostate);
        tempostate.enable(false);
        add(labwhere);
        add(whereToSwim);
        whereToSwim.enable(false);
        
       
        
        setSize(720, 300);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor
    
    

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry();
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == FindAllByDate) {
            message = FindAll();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

public String addEntry()
    {
        String selectedActivity = (String)menu.getSelectedItem(); //To initiate the chosen activity in the combobox 
        String message = "Entry added to Record\n";
        System.out.println("Adding " + selectedActivity + " entry to the records");
        
    	if(name.getText().trim().equals("")) //if there is no name input
    	{
    		return "Please enter a valid name";
    	}
    	
        String n = name.getText().trim();
        
        try
        {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            
            //Checks for the selected acitivty chosen in the menu combobox 
            if(selectedActivity.equals("Cycle"))
            {
            	String ter = terrain.getText();
            	String tem = tempostate.getSelectedItem().toString();
            	
            	
                    CycleEntry eCycle = new CycleEntry(n, d, m, y, h, mm, s, km, ter, tem);
                    myAthletes.addCycleEntry(eCycle); 
                    blankDisplay();
                    Remove.setEnabled(true);
                    FindAllByName.setEnabled(true);
                    FindAllByDate.setEnabled(true);
                    return message;
           
            }
            else if(selectedActivity.equals("Sprint"))
            {
            	int recov = Integer.parseInt(recovery.getText());
            	int reps = Integer.parseInt(repetitions.getText());
            	
            	
                    SprintEntry eSprint = new SprintEntry(n, d, m, y, h, mm, s, km, recov, reps);
                    myAthletes.addSprintEntry(eSprint); 
                    blankDisplay();
                    Remove.setEnabled(true);
                    FindAllByName.setEnabled(true);
                    FindAllByDate.setEnabled(true);
                    return message;

            }
            else 
            {
            	String wh = whereToSwim.getSelectedItem().toString();
            	
            	
                    SwimEntry eSwim = new SwimEntry(n, d, m, y, h, mm, s, km, wh);
                    myAthletes.addSwimEntry(eSwim); //add the new entry
                    blankDisplay();
                    Remove.setEnabled(true);
                    FindAllByName.setEnabled(true);
                    FindAllByDate.setEnabled(true);
                    return message;
            	
            }
        }
        catch(Exception e) //catches if invalid details are entered or not all text boxes have data in them
        {
        	return "Please input valid date detail format";
        }
    }
    
    public String FindAll() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    
    

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

