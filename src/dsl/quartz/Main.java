package dsl.quartz;

import java.io.FileNotFoundException;

public class Main extends QuartzDSL {

	public static void main(String[] args) throws InvalidInput, FileNotFoundException {
				
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

}
