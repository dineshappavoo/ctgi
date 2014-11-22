/**
 * 
 */
package com.ctgi.google.problems;

/**
 * @author Dany
 *
 */
public class FindAngleBetweenHourAndMinute {

	/**
	 * @param args
	 * 
	 * DESCRIPTION:
	 * - Given a time in the format hh:mm, find the angle between the hour and minute
	 *   for example 4.45,  the angle should be 127.5 degrees
	 *   
	 * ALGORITHM:
	 * - Get the input time
	 * - split the hour and minute. The angle of a minute = 6 degree i.e (360/60)
	 *   Angle of hour = 30 degree i.e (360/12)
	 *   Angle of minute made by hour pin = .5 degree i.e (60minutes = 30 degree => 1 minute = .5 degree) 
	 * - Total angle of hour = (hour * 30) + (minute * .5)
	 * - Total angle of minute = (minute * 6)
	 * - Angle difference = abs(total hour angle - total minute angle)
	 * - return the angle difference
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		float angle = new FindAngleBetweenHourAndMinute().findAngle("4:45"); 
		System.out.println(angle);
	}
	
	public float findAngle(String time)
	{
		if(time == null)
			return (float) 0;
		if(time == "")
			return (float) 0;
		int hour = Integer.parseInt(time.substring(0, time.indexOf(":")));
		int minute = Integer.parseInt(time.substring(time.indexOf(":")+1,time.length()));
		
		float total_hour = (float) ((float) (hour * 30) + (minute * .5));
		float total_minute = (minute * 6);
		
		
		float angle_diff = Math.abs(total_hour - total_minute);

		return angle_diff;

	}

}
