import java.util.Arrays;

public class MovieDatabase {

	BST<Integer,Movie> movieTree=new BST<Integer,Movie>();
	//BST<String,Cast> cast=new BST<String,Cast>();
	Movie movie;
	Movie[] movieList=new Movie[100];
	Movie[] movieListCopy=new Movie[100];
	int index=0;
	
	
	public void addMovie(String movieTitle, String directorFirstName, String directorLastName, int releaseDay,
			int releaseMonth, int releaseYear) {
		
		movie=new Movie(movieTitle, directorFirstName, directorLastName, releaseDay, releaseMonth, releaseYear);
		
		//KONTROL ET!!!!!
		if(!movieTree.get(releaseYear).title.equals(movieTitle)) {
		movieTree.put(releaseYear, movie);
		movieList[index]=new Movie(movieTitle,directorFirstName,directorLastName,releaseDay,releaseMonth,releaseYear);
		index++;

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
		
		//KONTROL ET!!!!!!!!!!!!
		Cast actor=new Cast(movieTitle, actorFirstName, actorLastName, actorRole);
		
		Integer key=movieTree.search(movieTitle);
		
		if(key!=null) {
			movieTree.get(key).actorTree.put(actorFirstName, actor);
		}
		
		
	}
	
	public void removeActor(String movieTitle, String actorFirstName, String actorLastName) {
		
	}
	
	public void showAllMovies() {
		
	for(int i=0,j=0;i<movieList.length;i++) {
		 
		if(movieList[i]!=null) {
			movieListCopy[j]=movieList[i];
			j++;
		}
	}
		
	Arrays.sort(movieListCopy);
	int i=0;
	
	while(movieListCopy[i]!=null) {
		System.out.println(movieListCopy[i].title+", "+movieListCopy[i].year+", "+movieListCopy[i].direc_fname+" "+movieListCopy[i].direc_lname);
	}
	
	}
	
	public void showMovie(String movieTitle) {
		
		//BAKKK
		Integer key=movieTree.search(movieTitle);
		
		if(key!=null) {
			System.out.println(movieTree.get(key).toString());
		}
	}
	
	public void showActorRoles(String actorFirstName, String actorLastName) {
		
	}
	
	public void showDirectorMovies(String directorFirstName, String directorLastName) {
		
	}
}
