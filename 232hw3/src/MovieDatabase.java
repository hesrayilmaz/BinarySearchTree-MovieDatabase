import java.util.Arrays;
//-----------------------------------------------------
//Title: MovieDatabase Class
//Author: Hatice Esra Yılmaz
//ID: 
//Section: 1
//Assignment: 3
//Description: This class creates a movie tree and does operations such as adding, deleting, printing
//-----------------------------------------------------
public class MovieDatabase {

	//creates a movie tree
	BST<Movie, String> movieTree = new BST<Movie, String>();
	
	//creates a movie
	Movie movie;

	public void addMovie(String movieTitle, String directorFirstName, String directorLastName, int releaseDay,
			int releaseMonth, int releaseYear) {	
	//--------------------------------------------------------
 	// Summary: This method creates the wanted movie and adds it to the movie tree 
	// Precondition: String movieTitle, directorFirstName, directorLastName; 
	//				 integer releaseDay,releaseMonth,releaseYear are given as parameters
	// Postcondition: If there is no same movie, adds movie to the movie tree and prints appropriate message
	//--------------------------------------------------------

		movie = new Movie(movieTitle, directorFirstName, directorLastName, releaseDay, releaseMonth, releaseYear);

		//traversals the movie tree to check the movie
		for(Movie m: movieTree.levelOrder()) {
			if(m.title.equals(movieTitle)) {
				System.out.println("ERROR: Movie " + movieTitle + " overwritten");
				return;
			}	
		}
			movieTree.putMovie(movie, movieTitle);
			System.out.println("INFO: Movie " + movieTitle + " has been added");
		

	}

	public void removeMovie(String movieTitle) {
		//--------------------------------------------------------
	 	// Summary: This method is used to remove the wanted movie from the movie tree 
		// Precondition: String movieTitle is given as parameter
		// Postcondition: If the movie exists, deletes it from the movie tree and prints appropriate message
		//--------------------------------------------------------
		
		//traversals the movie tree to check the movie
		for(Movie m: movieTree.levelOrder()) {
			if(m.title.equals(movieTitle)) {
			movieTree.delete(m);
			System.out.println("INFO: Movie " + movieTitle + " has been removed");
			return;}
		}
			System.out.println("ERROR: Movie " + movieTitle + " does not exist");
	}

	public void addActor(String movieTitle, String actorFirstName, String actorLastName, String actorRole) {
		//--------------------------------------------------------
	 	// Summary: This method creates the wanted actor and adds it to the actor tree 
		// Precondition: String movieTitle, actorFirstName, actorLastName, actorRole are given as parameters
		// Postcondition: If the movie exists, adds actor to the actor tree and prints appropriate message
		//--------------------------------------------------------
		
		//traversals the movie tree to check the movie
		for (Movie key : movieTree.levelOrder()) {
			if (key.title.equals(movieTitle)) {
				Cast actor=new Cast(movieTitle, actorFirstName, actorLastName, actorRole);
				key.actorTree.putActor(actorFirstName+" "+actorLastName, actor);
				System.out.println("INFO : " + actorFirstName + " " + actorLastName + " has been added to the movie " + movieTitle);
				return;
			}
		}
		System.out.println("ERROR: Movie " + movieTitle + " does not exist");

	}

	public void removeActor(String movieTitle, String actorFirstName, String actorLastName) {
		//--------------------------------------------------------
	 	// Summary: This method is used to remove the wanted actor from the actor tree 
		// Precondition: String movieTitle, actorFirstName, actorLastName are given as parameters
		// Postcondition: If the movie and the actor exist deletes the actor from the actor tree and prints appropriate message
		//--------------------------------------------------------
		
		//traversals the movie tree to check the movie
		for (Movie key : movieTree.levelOrder()) {
			if (key.title.equals(movieTitle)) {
				//traversals the actor tree to check the actor
				for (String actor : key.actorTree.levelOrder()) {
					if(actor.equals(actorFirstName+" "+actorLastName)) {
					key.actorTree.delete(actorFirstName+" "+actorLastName);
					System.out.println("INFO : " + actorFirstName + " " + actorLastName + " has been removed from the movie " + movieTitle);
					return;
				}
				}
			}
		}
		
		System.out.println("INFO: Actor " + actorFirstName + " " + actorLastName + " does not exist in Movie " + movieTitle);
	}

	public void showAllMovies() {
		//--------------------------------------------------------
	 	// Summary: This method is used to show the all movies' information.
		// Precondition: -
		// Postcondition: If there is a movie prints its title, year, direc_fname, direc_lname
		//--------------------------------------------------------

		//traversals the movie tree 
		for (Movie key : movieTree.levelOrder()) {
			if (key.title!=null) {
				System.out.println(key.title+", "+key.year+", "+key.direc_fname+" "+key.direc_lname);
			}
			else 
				System.out.println("---none---");
			}

	}

	public void showMovie(String movieTitle) {
		//--------------------------------------------------------
	 	// Summary: This method is used to show a specific movie's information.
		// Precondition: String movieTitle is given as parameter
		// Postcondition: If there is a movie prints its title, year, direc_fname, direc_lname
		//--------------------------------------------------------

		//traversals the movie tree 
		for (Movie key : movieTree.levelOrder()) {
			if (key.title.equals(movieTitle)) {
				System.out.println(key.title+"\n"+key.day+"/"+key.month+"/"+key.year+
						"\n"+key.direc_fname+" "+key.direc_lname);
				for (String actor : key.actorTree.levelOrder()) {
					if(key.actorTree.get(actor).movieTitle.equals(movieTitle)) {
						
						System.out.println(key.actorTree.get(actor).fname+" "+key.actorTree.get(actor).lname
								+", "+key.actorTree.get(actor).role);
				}
				}
				return;
			}
		}
		
		System.out.println("---none---");
	}

	public void showActorRoles(String actorFirstName, String actorLastName) {
		//--------------------------------------------------------
	 	// Summary: This method is used to show the given actor's information.
		// Precondition: String actorFirstName, actorLastName are given as parameter.
		// Postcondition: If there is the actor, prints its role, movie title, release year
		//--------------------------------------------------------

		System.out.println(actorFirstName+" "+actorLastName);
		
		//traversals the movie tree 
		for (Movie key : movieTree.levelOrder()) {
			//traversals the actor tree
				for (String actor : key.actorTree.levelOrder()) {
					if(key.actorTree.get(actor).fname.equals(actorFirstName)&&
							key.actorTree.get(actor).lname.equals(actorLastName)) {
						System.out.println(key.actorTree.get(actor).role+", "+
								key.title+", "+key.year);
					}
				}
		}
		System.out.println();
	}

	public void showDirectorMovies(String directorFirstName, String directorLastName) {
		//--------------------------------------------------------
	 	// Summary: This method is used to show the given director's information.
		// Precondition: String directorFirstName, directorLastName are given as parameter
		// Postcondition: If there is the director, prints its movie's title and release date
		//--------------------------------------------------------
		
		System.out.println(directorFirstName+" "+directorLastName);
		
		//traversals the movie tree 
		for (Movie key : movieTree.levelOrder()) {
			if (key.direc_fname.equals(directorFirstName)&&key.direc_lname.equals(directorLastName)) {
				System.out.println(key.title+" "+key.day+"/"+key.month+"/"+key.year);
				}
			
			}
		System.out.println();
		}
		
		
		
	}

