package simon.is.learning;

public class Movie{
	private int id;
	private String title,desc;
	Movie(int id, String title, String desc){
		this.id=id;
		this.title=title;
		this.desc=desc;
	}
	public String[] getAllInfo(){
		return new String[]{String.valueOf(id),title,desc};
	}
	public String getId(){
		return String.valueOf(id);
	}
	public String getTitle(){
		return title;
	}
	public String getDesc(){
		return desc;
	}
}
