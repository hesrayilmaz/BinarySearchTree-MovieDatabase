import java.util.Arrays;

public class MovieDatabase {

	BST<Movie, String> movieTree = new BST<Movie, String>();
	Movie movie;

	public void addMovie(String movieTitle, String directorFirstName, String directorLastName, int releaseDay,
			int releaseMonth, int releaseYear) {

		movie = new Movie(movieTitle, directorFirstName, directorLastName, releaseDay, releaseMonth, releaseYear);

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

		for(Movie m: movieTree.levelOrder()) {
			if(m.title.equals(movieTitle)) {
			movieTree.delete(m);
			System.out.println("INFO: Movie " + movieTitle + " has been removed");
			return;}
		}
			System.out.println("ERROR: Movie " + movieTitle + " does not exist");
	}

	public void addActor(String movieTitle, String actorFirstName, String actorLastName, String actorRole) {

		
		for (Movie key : movieTree.levelOrder()) {
			if (key.title.equals(movieTitle)) {
				Cast actor=new Cast(movieTitle, actorFirstName, actorLastName, actorRole);
				key.actorTree.putActor(actorFirstName+" "+actorLastName, actor);
				System.out.println("INFO : " + actorFirstName + " " + actorLastName + " has been added to the movie " + movieTitle);
				return;
			}
		}
		System.out.println("INFO: Movie " + movieTitle + " does not exist");

	}

	public void removeActor(String movieTitle, String actorFirstName, String actorLastName) {

		for (Movie key : movieTree.levelOrder()) {
			if (key.title.equals(movieTitle)) {
				for (String actor : key.actorTree.levelOrder()) {
					if(actor.equals(actorFirstName+" "+actorLastName)) {
					key.actorTree.delete(actorFirstName+" "+actorLastName);
					System.out.println("INFO : " + actorFirstName + " " + actorLastName + " has been added to the movie " + movieTitle);
					return;
				}
				}
			}
		}
		
		System.out.println("INFO: Actor " + actorFirstName + " " + actorLastName + " does not exist in Movie " + movieTitle);
	}

	public void showAllMovies() {

		for (Movie key : movieTree.levelOrder()) {
			if (key.title!=null) {
				System.out.println(key.title+" "+key.year+" "+key.direc_fname+" "+key.direc_lname);
			}
			else 
				System.out.println("---none---");
			}

	}

	public void showMovie(String movieTitle) {

		for (Movie key : movieTree.levelOrder()) {
			if (key.title.equals(movieTitle)) {
				System.out.println(key.title+"/n"+key.day+"/"+key.month+"/"+key.year+
						"/n"+key.direc_fname+" "+key.direc_lname);
				for (String actor : key.actorTree.levelOrder()) {
					if(key.actorTree.get(actor).movieTitle.equals(movieTitle)) {
						
						System.out.println(key.actorTree.get(actor).fname+" "+key.actorTree.get(actor).lname
								+" "+key.actorTree.get(actor).role);
				}
				}
				return;
			}
		}
		
		System.out.println("---none---");
	}

	public void showActorRoles(String actorFirstName, String actorLastName) {

	}

	public void showDirectorMovies(String directorFirstName, String directorLastName) {

	}
	
	
	
	
}
