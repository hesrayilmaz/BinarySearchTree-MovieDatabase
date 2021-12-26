//-----------------------------------------------------
//Title: Movie Class
//Author: Hatice Esra Yılmaz
//ID: 
//Section: 1
//Assignment: 3
//Description: This class creates a Movie that implements Comparable<Movie> which will be used in binary tree
//-----------------------------------------------------

public class Movie implements Comparable<Movie>{

	// a movie have title, director first name, director last name, release day, month, year
	String title,direc_fname, direc_lname;
	int day, month, year;
	
	// each movie has a actor tree
	BST <String,Cast>actorTree;
	
	// constructor for movie
	public Movie(String title, String direc_fname, String direc_lname, int day, int month, int year) {

		this.title = title;
		this.direc_fname = direc_fname;
		this.direc_lname = direc_lname;
		this.day = day;
		this.month = month;
		this.year = year;
		actorTree=new BST<String,Cast>();
	}
	
	//returns a string with title, year, director name 
	public String toString() {
		return title+" "+year+" "+direc_fname+" "+direc_lname;
	}

	//compares movie years
	@Override
	public int compareTo(Movie o) {
		if(this.year<o.year)
			return -1;
		else if (o.year<this.year)
			return 1;
		return 0;
	}
	
	
	
}
