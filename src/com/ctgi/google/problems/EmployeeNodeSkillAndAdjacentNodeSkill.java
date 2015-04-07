/**
 * 
 */
package com.ctgi.google.problems;

import java.util.HashMap;

/**
 * @author Dany
 *
 */

/**
 * Each software engineer at Symantec has a skill ranking from 1 to 10 and a group of software engineer friends (also Symantec employees who each also have a skill ranking from 1 to 10). You want to find which employee has the highest combined skill level at Symantec (their own plus all his co-worker friends).
    Provide an implementation of the above using Java. A driver class or a unit test should be provided which builds a list of employees with various skill levels, their friends, and the employee with the highest combined skill level.
    Example:
        Jack (4 skill level) and friends with Jane.
        Jane (1 skill level) and friends with Jack and Tina.
        Tina (7 skill level) and friends with Jane.
        Bob (10 skill level) and has no friends

        Jack has a total points of 4 + 1 = 5
        Jane has total points of 1 + 4 + 7 = 12
        Tina has total points of 7 + 1 = 8
        Bob has total points of 10

    So Jane is the superstar software engineer! 
 */
public class EmployeeNodeSkillAndAdjacentNodeSkill {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	public String findEmployeeAndAdjacentSkills(HashMap<String, SymantecEmployee> empMap)
	{
		HashMap<String, Integer> skillMap = new HashMap<String, Integer>();
		SymantecEmployee employee;
		int totalSkill = 0;
		for(String emp : empMap.keySet())
		{
			employee = empMap.get(emp);
			totalSkill += employee.skill;
			for(String colleague : employee.colleagueList)
			{
				totalSkill += empMap.get(colleague).skill;
			}
			skillMap.put(emp, totalSkill);
		}
		String superStar ="";
		int maxSkill = Integer.MIN_VALUE;
		int skill = 0;
		for(String empl : skillMap.keySet())
		{
			skill = skillMap.get(empl);
			if(skill>maxSkill)
			{
				maxSkill = skill;
				superStar = empl;
			}
		}
			
		return superStar;
		
	}

}
