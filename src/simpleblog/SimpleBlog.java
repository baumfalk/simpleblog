package simpleblog;

public class SimpleBlog {
	public static void main(String [] args) {
		Controller c = new SimpleController();
		Model m = new TextModel();
		View v = new SimpleHTMLView();
		
		c.addModel(m);
		c.addView(v);
		
		c.readInput("blogs");
		c.writeOutput("output");
		
	}
}
