package dsl.quartz;

import static dsl.quartz.Quartz.set;

/*
 * To be extended by user's class
 */

abstract class QuartzDSL implements Definitions {
	
	public static Quartz quartzExpression() {
		
		return set();
	}

}
