package application;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class Branch  // CLASS NAME MUST MATCH THE BRANCH TAG IN THE FILE
{
	@XmlElement(name = "station") // ELEMENT NAME MUST MATCH THE STATION TAG IN THE FILE
	private List<String> stations = new ArrayList<>();
	
	public List<String> getStations()
	{
		return stations;
	}
	
	
}
