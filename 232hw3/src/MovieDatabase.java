
public class MovieDatabase {

	BST<Integer,Movie> movieTree=new BST<Integer,Movie>();
	//BST<String,Cast> cast=new BST<String,Cast>();
	Movie movie;
	//Movie[] movieList=new Movie[100];
	//int index=0;
	
	
	public void addMovie(String movieTitle, String directorFirstName, String directorLastName, int releaseDay,
			int releaseMonth, int releaseYear) {
		
		movie=new Movie(movieTitle, directorFirstName, directorLastName, releaseDay, releaseMonth, releaseYear);
		
		//KONTROL ET!!!!!
		if(!movieTree.get(releaseYear).title.equals(movieTitle)) {
		movieTree.put(releaseYear, movie);
		//movieList[index]=new Movie(movieTitle,directorFirstName,directorLastName,releaseDay,releaseMonth,releaseYear);
		//index++;

		System.out.println("INFO: Movie "+movieTitle+" has been added");
		}
		else
			System.out.println("ERROR: Movie "+movieTitle+" overwritten");
	}
	
	public void removeMovie(String movieTitle) {
		
		//KONTROL ET!!!!
		if(movieTree.get(movie.year).title.equals(movieTitle)) {
			movieTree.delete(movie.year);
			System.out.println("INFO: Movie "+movieTitle+" has been removed");
		}
		else
			System.out.println("ERROR: Movie "+movieTitle+" does not exist");

			}
	
	public void addActor(String movieTitle, String actorFirstName, String actorLastName, String actorRole) {
		
		//YANLIŞ OLDU KONTROL ET
		Cast actor=new Cast(movieTitle, actorFirstName, actorLastName, actorRole);
		movieTree.get(movie.year).actorTree.put(actorRole, actor);
		
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
