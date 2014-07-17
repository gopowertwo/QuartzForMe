QuartzForMe
===========

Sample Java DSL for Quartz

### Description

This is a simple Domain Specific Language for Quartz(http://quartz-scheduler.org/). It provides both internal and external DSL capabilities and allows users to express simple crons in a more intuitive way. 

### Internal Domain Specific Language 

For each field in the "cron expression", the user can specify single, multiple, range, and/or increments of values. 

1. Seconds
	..* setSeconds()
	..* setIntervalSeconds()
	..* setIncrementSeconds()
2. Minutes
	..* setMinutes()
	..* setIntervalMinutes()
	..* setIncrementMinutes()
3. Hours
	..* setHours()
	..* setIntervalHours()
	..* setIncrementHours()
4. Day of month
	..* setDays()
	..* setIntervalDays()
	..* setIncrementDays
5. Month
	..* setMonths()
	..* setIntervalMonths()
	..* setIncrementMonths()
6. Day of week
	..* setDaysOfWeek()
	..* setIntervalDayOfWeek()
	..* setIncrementDayOfWeek()
7. Year
	..* setYears()
	..* setIntervalYears()
	..* setIncrementYears()

## Example

`String expr = quartzExpression()
				.setIncrementSeconds(0,15)
				.setSeconds(10)
				.setMinutes(10)
				.setHours(23)
				.setMonths(FEB)
				.setDaysOfWeek(Monday)
				.setYears(2000)
				.generate();`


### External Domain Specific Language

Following a JSON approach, the external DSL requires the user to create an input file with keywords, specifying "cron expression" field and type of values, and the desired values. The two are divided by a colon (:).

1. *seconds*

## Example

cron.txt
`
seconds : 10,20,30
`