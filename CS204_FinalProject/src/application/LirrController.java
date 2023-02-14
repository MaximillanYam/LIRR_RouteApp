package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LirrController {

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private TextArea branchesTextArea;
    
    // Instance variable for array of arrays
    private ArrayList<ArrayList<String>> arrayOfBranches = new ArrayList<ArrayList<String>>();
    
    
    // Instance variable for end locations 
    private final  ArrayList<String> babylon = new ArrayList<String>();
    private final ArrayList<String> belmontPark = new ArrayList<String>();
    private final ArrayList<String> farRockaway = new ArrayList<String>();
    private final ArrayList<String> hempstead = new ArrayList<String>();
    private final ArrayList<String> longBeach = new ArrayList<String>();
    private final ArrayList<String> montauk = new ArrayList<String>();
    private final ArrayList<String> oysterBay = new ArrayList<String>();
    private final ArrayList<String> portJefferson = new ArrayList<String>();
    private final ArrayList<String> portWashington = new ArrayList<String>();
    private final ArrayList<String> ronkonkoma = new ArrayList<String>();
    private final ArrayList<String> westHempstead = new ArrayList<String>();
    
	private void setStation() {
		babylon.clear();
		
		BufferedReader input = null;
		try 
		{
			// Reading the xml files into the ArrayLists
			
			input = Files.newBufferedReader(Paths.get("Babylon.xml"));
			Branch stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
			input = Files.newBufferedReader(Paths.get("Belmont Park.xml"));
			stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
			input = Files.newBufferedReader(Paths.get("Far Rockaway.xml"));
			stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
			input = Files.newBufferedReader(Paths.get("Hempstead.xml"));
			stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
			input = Files.newBufferedReader(Paths.get("Long beach.xml"));
			stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
			input = Files.newBufferedReader(Paths.get("Montauk.xml"));
			stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
			input = Files.newBufferedReader(Paths.get("Oyster Bay.xml"));
			stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
			input = Files.newBufferedReader(Paths.get("Port Jefferson.xml"));
			stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
			input = Files.newBufferedReader(Paths.get("Port Washington.xml"));
			stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
			input = Files.newBufferedReader(Paths.get("Ronkonkoma.xml"));
			stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
			input = Files.newBufferedReader(Paths.get("West Hempstead.xml"));
			stationList = JAXB.unmarshal(input, Branch.class);
			
			arrayOfBranches.add((ArrayList<String>)stationList.getStations());
			
		} 
		
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				input.close();
			} 
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
    
	public void initialize() 
	{
		setStation();
	}
	
    @FXML
    void searchButtonPressed(ActionEvent event)
    {	
    	branchesTextArea.clear();
    	branchesTextArea.setText("");
    	String text = searchTextField.getText();
    	String res = "";
    	int count = 1;
    	
    	for(int i = 0; i < arrayOfBranches.size(); i++)
    	{	
    		for(int j = 0; j < arrayOfBranches.get(i).size(); j++)
    		{
    			if(arrayOfBranches.get(i).get(j).contains(text))
    			{
    				int last = arrayOfBranches.get(i).size() - 1;
    				res = res + String.format("Option%d: ", count) + arrayOfBranches.get(i).get(last) + "\n";
					count++;
    				
    				for(int current = j; current < arrayOfBranches.get(i).size(); current++)
    				{
    					res = res + "---" + arrayOfBranches.get(i).get(current) + "\n";
    				}
    				
    				res = res + "\n";
    			}
    		}	
    		
    	}
    	branchesTextArea.setText(res);
    }
    
    
}
