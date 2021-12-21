
public class Movie {

	String title,direc_fname, direc_lname;
	int day, month, year;
	
	public Movie(String title, String direc_fname, String direc_lname, int day, int month, int year) {

		this.title = title;
		this.direc_fname = direc_fname;
		this.direc_lname = direc_lname;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString() {
		return title+" "+year+" "+direc_fname+" "+direc_lname;
	}
	
	
	
}
