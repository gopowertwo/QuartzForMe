package dsl.quartz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Parser {

	private Scanner s;
	private HashMap<String, String> data = new HashMap<String, String>();

	Map<String, ServiceMethod> serviceMethodMap = new HashMap<>();

	public Parser(String filename) throws FileNotFoundException {
		
		setService();
		
		s = new Scanner(new File(filename));
		String[] line;

		while (s.hasNextLine()) {
			line = s.nextLine().split(":");
			data.put(line[0], line[1]);
		}

	}

	/*
	 * Set Map for matching keywords to methods
	 */
	
	public void setService() {

		serviceMethodMap.put("seconds", new ServiceMethod() {
			public Quartz execute(Quartz quartz, int... values) {
							
				try {
					return quartz.setSeconds(values[0], Arrays.copyOfRange(values, 1, values.length));
				} catch (InvalidInput e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
			}
		});

	}

	public Map<String, ServiceMethod> getService() {
		return this.serviceMethodMap;
	}

	public Map<String, String> getData() {
		return this.data;
	}

}
