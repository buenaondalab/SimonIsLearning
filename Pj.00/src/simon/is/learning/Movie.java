package simon.is.learning;

public class Movie{
	
	private int id;
	private String title,desc;
	
	Movie(int id, String title, String desc){
		this.id=id;
		this.title=title;
		this.desc=desc;
	}
	
	// a che ti serve? una volta che hai l'oggetto Movie hai anche tutte le info...
	// se le metti in un vettore poi per leggerle devi scorrere il vettore...
	public String[] getAllInfo() {
		return new String[]{String.valueOf(id),title,desc};
	}
	
	//non puoi semplicemente ritornare un int? ... ok l'hai fatto per getAllInfo()...
	public String getId() {
		return String.valueOf(id);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDesc() {
		return desc;
	}
}
