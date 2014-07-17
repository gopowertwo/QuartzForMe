QuartzForMe
===========

Sample Java DSL for Quartz

### Description

This is a simple Domain Specific Language for Quartz(http://quartz-scheduler.org/). It provides both internal and external DSL capabilities and allows users to express simple crons in a more intuitive way. 

### Internal Domain Specific Language 

For each field in the "cron expression", the user can specify single, multiple, range, and/or increments of values. If a specific field is not specified, it will match all possible values by default (equivalent to '*' in quartz)

1. Seconds - supports the values from 0 to 59
	* **setSeconds(first, second, third...)** 		- Run every given second
	* **setIntervalSeconds(start, end)**			- Run every second in the given interval
	* **setIncrementSeconds(start, incrementBy)**  	- Run every second from the initial value and the subsequent increments
2. Minutes - supports the values from 0 to 59 
	* **setMinutes(first, second, third...)**  		- Run every given minute
	* **setIntervalMinutes(start, end)**  			- Run every minute in the given interval
	* **setIncrementMinutes(start, incrementBy)**   - Run every minute from the initial value and the subsequent increments
3. Hours - supports the values from 0 to 23
	* **setHours(first, second, third...)**  		- Run every given hour
	* **setIntervalHours(start, end)**  			- Run every hour in the given interval
	* **setIncrementHours(start, incrementBy)**  	- Run every hour from the initial value and the subsequent increments 
4. Day of month - supports the values from 1 to 31
	* **setDays(first, second, third...)**  		- Run every given day of the month
	* **setIntervalDays(start, end)**  				- Run every day of the month in the given interval
	* **setIncrementDays(start, incrementBy)**  	- Run every day from the initial value and the subsequent increments
5. Month - supports the values from 1 to 12 and first-three letter representation of the month name e.g. JAN, FEB, MAR
	* **setMonths(first, second, third...)**  		- Run every given month
	* **setIntervalMonths(start, end)**  			- Run every month in the given interval
	* **setIncrementMonths(start, incrementBy)**  	- Run every month from the initial value and the subsequent increments
6. Day of week - supports the values from 1 to 7 starting from Sunday and first-three letter representation of the weekday name e.g. MON, TUE, WED
	* **setDaysOfWeek(first, second, third...)**  	- Run every given weekday
	* **setIntervalDayOfWeek(start, end)**  		- Run every weekday in the given interval
	* **setIncrementDayOfWeek(start, incrementBy)** - Run every weekday from the initial value and the subsequent increments
7. Year - supports values from 1000 to 9999
	* **setYears(first, second, third...)**  		- Run every given year
	* **setIntervalYears(start, end)** 			- Run every year in the given interval
	* **setIncrementYears(start, incrementBy)**     - Run every year from the initial value and the subsequent increments

## Example

	String expr = quartzExpression()  	
				.setIncrementSeconds(0,15)  
				.setSeconds(10)  
				.setMinutes(10)  
				.setHours(23)  
				.setIntervalMonths(FEB-OCT)  
				.setDaysOfWeek(Monday)  
				.setYears(2015)  
				.generate();  



### External Domain Specific Language

Following a JSON approach, the external DSL requires the user to create an input file with keywords, specifying "cron expression" field and type of values, and the desired values. The two are divided by a colon ":".

1. *seconds*

## Example

cron.txt



	seconds : 10,20,30
