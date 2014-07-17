package dsl.quartz;

import java.io.FileNotFoundException;
import java.util.Map;

public class Main extends QuartzDSL {

	public static void main(String[] args) throws InvalidInput, FileNotFoundException {
		
		//String fname = "cron";
		
		if(args.length == 1) {
			System.out.println(parseFile(args[0]));
		} else {
			// TODO
		}
		
		String quartz = quartzExpression()
				.setIncrementSeconds(0,15)
				.setSeconds(10)
				.setMinutes(10)
				.setHours(23)
				.setMonths(FEB)
				.setDaysOfWeek(Monday)
				.setYears(2000)
				.generate();
				
		System.out.println(quartz);
	}
	
	public static String parseFile(String filename) throws FileNotFoundException {
		
		Parser p = new Parser(filename);
		Map<String, ServiceMethod> map = p.getService();
		Map<String, String> data = p.getData();
		Quartz quartz = new Quartz();
		
		for(String str: data.keySet()) {
			ServiceMethod method = map.get(str);
			if(method != null) {	
				// Bad
				String[] val = data.get(str).replaceAll(" ",  "").split(",");
				int[] ints = new int[val.length];
				for(int i = 0; i < val.length; i++) {
					ints[i] = Integer.parseInt(val[i]);
				}
				
				quartz = method.execute(quartz, ints);
			} else {
				throw new IllegalArgumentException();
			}
		}	
		
		return quartz.generate();
		
	}

}
