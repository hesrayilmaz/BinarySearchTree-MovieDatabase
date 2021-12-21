
public class MovieDatabase {

	BST<String,Movie> movieTree=new BST<String,Movie>();
	//BST<String,Cast> cast=new BST<String,Cast>();
	
	//Movie[] movieList=new Movie[100];
	//int index=0;
	
	
	public void addMovie(String movieTitle, String directorFirstName, String directorLastName, int releaseDay,
			int releaseMonth, int releaseYear) {
		
		Movie movie=new Movie(movieTitle, directorFirstName, directorLastName, releaseDay, releaseMonth, releaseYear);
		
		if(movieTree.get(movieTitle)==null) {
		movieTree.put(movieTitle, movie);
		//movieList[index]=new Movie(movieTitle,directorFirstName,directorLastName,releaseDay,releaseMonth,releaseYear);
		//index++;

		System.out.println("INFO: Movie "+movieTitle+" has been added");
		}
		else
			System.out.println("ERROR: Movie "+movieTitle+" overwritten");
	}
	
	public void removeMovie(String movieTitle) {
		
		if(movieTree.get(movieTitle)!=null) {
			movieTree.delete(movieTitle);
			System.out.println("INFO: Movie "+movieTitle+" has been removed");
		}
		else
			System.out.println("ERROR: Movie "+movieTitle+" does not exist");

			}
	
	public void addActor(String movieTitle, String actorFirstName, String actorLastName, String actorRole) {
		
		Cast actor=new Cast(movieTitle, actorFirstName, actorLastName, actorRole);
		movieTree.get(movieTitle).actorTree.put(actorRole, actor);
		
	}
	
	public void removeActor(String movieTitle, String actorFirstName, String actorLastName) {
		
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
