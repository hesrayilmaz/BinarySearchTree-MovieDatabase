import java.util.Arrays;

public class MovieDatabase {

	BST<Movie, String> movieTree = new BST<Movie, String>();
	// BST<String,Cast> cast=new BST<String,Cast>();
	Movie movie;
	Movie[] movieList = new Movie[100];
	Movie[] movieListCopy = new Movie[100];
	int index = 0;

	public void addMovie(String movieTitle, String directorFirstName, String directorLastName, int releaseDay,
			int releaseMonth, int releaseYear) {

		movie = new Movie(movieTitle, directorFirstName, directorLastName, releaseDay, releaseMonth, releaseYear);

		for(Movie m: movieTree.levelOrder()) {
			if(m.title.equals(movieTitle)) {
				System.out.println("ERROR: Movie " + movieTitle + " overwritten");
				return;
			}	
		}
			movieTree.put(movie, movieTitle);
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
				key.actorTree.put(actorFirstName+" "+actorLastName, actor);
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

		

	}

	public void showMovie(String movieTitle) {

		
	}

	public void showActorRoles(String actorFirstName, String actorLastName) {

	}

	public void showDirectorMovies(String directorFirstName, String directorLastName) {

	}
	
	
	
	
}
