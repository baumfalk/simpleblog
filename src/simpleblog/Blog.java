package simpleblog;

import java.util.Date;
import java.util.List;

public class Blog implements Comparable<Blog>{
	private String title;
	private List<String> contents;
	private Date date;
	
	
	
	public Blog(String title, List<String> contents, Date date) {
		this.title = title;
		this.contents = contents;
		this.date = date;
	}
	
	public Blog() {
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getContents() {
		return contents;
	}
	public void setContents(List<String> contents) {
		this.contents = contents;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(Blog o) {
		return 0 - this.date.compareTo(o.getDate());
	}
	
	
}
