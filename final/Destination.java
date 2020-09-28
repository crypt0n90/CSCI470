/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 7        Summer 2020  *
 *                                                          *
 *  Class Name:  Java Summer 2020                           *
 *                                                          *
 *  Programmer:  Adam Page z1859276                         *
 *  Purpose:  Destination                                   *
 *                                                          *
 ************************************************************/
public class Destination
{
	private String city;
	private int normalMiles;
	private int cheapMiles;
	private int additionalMile;
	private int beginMonth;
	private int endMonth;

	public Destination(final String s, final String s2, final String s3, final String s4, final String s5) {
		//Assign input variables to the respective fields
		city = s;
		normalMiles = Integer.parseInt(s2);
		cheapMiles = Integer.parseInt(s3);
		additionalMile = Integer.parseInt(s4);
		//For months, we split last string by dash
		String[] ms = s5.split("-");
		beginMonth = Integer.parseInt(ms[0]);
		endMonth = Integer.parseInt(ms[1]);
	}

	//Getters for all variables
	public String getCity() {
		return city;
	}

	public int getNormalMiles() {
		return normalMiles;
	}

	public int getCheapMiles() {
		return cheapMiles;
	}
	
	public int getAdditionalMile() {
		return additionalMile;
	}

	public int getbeginMonth() {
		return beginMonth;
	}

	public int getendMonth() {
		return endMonth;
	}
}