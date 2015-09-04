package simon.is.learning;
import java.util.*;

public interface DbData {
	public void insert(Object o);
	public void update(Object o);
	public void delete(Object o);
	public List<Movie> getAllMovies();
	public List<Movie> sqlWhereClause(String s);
}
