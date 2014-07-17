package dsl.quartz;



public class Quartz {

	private String[] expression = {"*", "*", "*", "*", "*", "*", "*"};
	private String[] regex = {"[0-5]?\\d", "[0-5]?\\d", "[01]?\\d|2[0-3]", "0?[1-9]|[12]\\d|3[01]", "[1-9]|1[012]", "[1-7]", "\\d{4}"};

	public static Quartz set() {	
		return new Quartz();
	}

	/*
	 * Run every time in that interval
	 */

	public Quartz setTimeInterval(int startSeconds, int endSeconds, String error, int pos)
			throws InvalidInput {

		String s = Integer.toString(startSeconds);
		String e = Integer.toString(endSeconds);

		if (s.matches(regex[pos]) && e.matches(regex[pos])) {
			if (this.expression[pos].equals("*")) {
				this.expression[pos] = s + "-" + e;
			} else {
				this.expression[pos] += "," + s + "-" + e;
			}
		} else {
			throw new InvalidInput(error);
		}

		return this;
	}

	/*
	 * Run every given second
	 */

	public Quartz setTimes(String error, int pos, int firstSecond,
			int... otherSeconds) throws InvalidInput {

		String f = Integer.toString(firstSecond);
		if (f.matches(regex[pos])) {
			if (this.expression[pos].equals("*")) {
				this.expression[pos] = f + ",";
			} else {
				this.expression[pos] += "," + f + ",";
			}
		} else {
			throw new InvalidInput(error);
		}

		for (int second : otherSeconds) {
			String sec = Integer.toString(second);
			if (sec.matches(regex[pos])) {
				this.expression[pos] += sec + ",";
			} else {
				throw new InvalidInput(error);
			}
		}

		this.expression[pos] = this.expression[pos].replaceAll(",$", "");

		return this;
	}
	
	/*
	 * Run in increments starting from specific time
	 */

	public Quartz setTimeIncrement(int startSecond, int incrementBy, String error, int pos)
			throws InvalidInput {

		String s = Integer.toString(startSecond);
		String inc = Integer.toString(incrementBy);
		
		if (s.matches("[0-5]?\\d") && inc.matches("[0-5]?\\d")) {
			if (this.expression[pos].equals("*")) {
				this.expression[pos] = s + "/" + inc;
			} else {
				this.expression[pos] += "," + s + "/" + inc;
			}
		} else {
			throw new InvalidInput(error);
		}

		return this;
	}
	
	/*
	 *  Seconds
	 */

	public Quartz setIntervalSeconds(int startSeconds, int endSeconds)
			throws InvalidInput {
		return setTimeInterval(startSeconds, endSeconds,
				Definitions.seconds_error, 0);
	}

	public Quartz setSeconds(int firstSecond, int... otherSeconds)
			throws InvalidInput {
		return setTimes(Definitions.seconds_error, 0, firstSecond,
				otherSeconds);
	}

	public Quartz setIncrementSeconds(int startSecond, int incrementBy)
			throws InvalidInput {
		return setTimeIncrement(startSecond, incrementBy, Definitions.seconds_error, 0);
	}
	
	/*
	 * Minutes
	 */
	
	public Quartz setIntervalMinutes(int startMinute, int endMinute)
			throws InvalidInput {
		return setTimeInterval(startMinute, endMinute,
				Definitions.minutes_error, 1);
	}

	public Quartz setMinutes(int firstMinute, int... otherMinutes)
			throws InvalidInput {
		return setTimes(Definitions.minutes_error, 1, firstMinute,
				otherMinutes);
	}

	public Quartz setIncrementMinutes(int startMinute, int incrementBy)
			throws InvalidInput {
		return setTimeIncrement(startMinute, incrementBy, Definitions.minutes_error, 1);
	}
	
	/*
	 * Hours
	 */
	
	public Quartz setIntervalHours(int startHour, int endHour)
			throws InvalidInput {
		return setTimeInterval(startHour, endHour,
				Definitions.hours_error, 2);
	}

	public Quartz setHours(int firstHour, int... otherHours)
			throws InvalidInput {
		return setTimes(Definitions.hours_error, 2, firstHour,
				otherHours);
	}

	public Quartz setIncrementHours(int startHour, int incrementBy)
			throws InvalidInput {
		return setTimeIncrement(startHour, incrementBy, Definitions.hours_error, 2);
	}
	
	/*
	 * Days
	 */
	
	public Quartz setIntervalDays(int startDay, int endDay)
			throws InvalidInput {
		
		if (!this.expression[5].equals("*")) {
			throw new InvalidInput(
					"Cannot have both day and day of the week set.");
		} else {
			this.expression[5] = "?";
		}
		
		return setTimeInterval(startDay, endDay,
				Definitions.days_error, 3);
	}

	public Quartz setDays(int firstDay, int... otherDays)
			throws InvalidInput {
		
		if (!this.expression[5].equals("*")) {
			throw new InvalidInput(
					"Cannot have both day and day of the week set.");
		} else {
			this.expression[5] = "?";
		}
		
		return setTimes(Definitions.days_error, 3, firstDay,
				otherDays);
	}

	public Quartz setIncrementDays(int startDay, int incrementBy)
			throws InvalidInput {
		
		if (!this.expression[5].equals("*")) {
			throw new InvalidInput(
					"Cannot have both day and day of the week set.");
		} else {
			this.expression[5] = "?";
		}
		
		return setTimeIncrement(startDay, incrementBy, Definitions.days_error, 3);
	}
	
	/*
	 * Months
	 */
	
	public Quartz setIntervalMonths(int startMonth, int endMonth)
			throws InvalidInput {
		return setTimeInterval(startMonth, endMonth,
				Definitions.months_error, 4);
	}

	public Quartz setMonths(int firstMonth, int... otherMonth)
			throws InvalidInput {
		return setTimes(Definitions.months_error, 4, firstMonth,
				otherMonth);
	}

	public Quartz setIncrementMonths(int startMonth, int incrementBy)
			throws InvalidInput {
		return setTimeIncrement(startMonth, incrementBy, Definitions.months_error, 4);
	}
	
	/*
	 * Day of the week
	 */

	public Quartz setIntervalDayOfWeek(int startDay, int endDay)
			throws InvalidInput {
		
		if (!this.expression[3].equals("*")) {
			throw new InvalidInput(
					"Cannot have both day and day of the week set.");
		} else {
			this.expression[3] = "?";
		}
		
		return setTimeInterval(startDay, endDay,
				Definitions.dayofweek_error, 5);
	}

	public Quartz setDaysOfWeek(int firstDay, int... otherDays)
			throws InvalidInput {
		
		if (!this.expression[3].equals("*")) {
			throw new InvalidInput(
					"Cannot have both day and day of the week set.");
		} else {
			this.expression[3] = "?";
		}
		
		return setTimes(Definitions.dayofweek_error, 5, firstDay,
				otherDays);
	}

	public Quartz setIncrementDayOfWeek(int startDay, int incrementBy)
			throws InvalidInput {
		
		if (!this.expression[3].equals("*")) {
			throw new InvalidInput(
					"Cannot have both day and day of the week set.");
		} else {
			this.expression[3] = "?";
		}
		
		return setTimeIncrement(startDay, incrementBy, Definitions.dayofweek_error, 5);
	}
	
	/*
	 * Years
	 */
	
	public Quartz setIntervalYears(int startYear, int endYear)
			throws InvalidInput {
		return setTimeInterval(startYear, endYear,
				Definitions.year_error, 6);
	}

	public Quartz setYears(int firstYear, int... otherYear)
			throws InvalidInput {
		return setTimes(Definitions.year_error, 6, firstYear,
				otherYear);
	}

	public Quartz setIncrementYears(int startYear, int incrementBy)
			throws InvalidInput {
		return setTimeIncrement(startYear, incrementBy, Definitions.year_error, 6);
	}

	public String generate() {
		
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < this.expression.length; i++) {
		   result.append(this.expression[i]);
		   result.append(" ");
		}

		return result.toString().replaceAll(" $", "");
		
	}

}
