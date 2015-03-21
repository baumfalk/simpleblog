package simpleblog;

import java.util.List;

public class SimpleController implements Controller {

	private Model m;
	private View v;
	private List<Blog> blogs;

	@Override
	public void addModel(Model m) {
		this.m = m;
	}

	@Override
	public void addView(View v) {
		this.v = v;
	}

	@Override
	public void readInput(String inputDirectory) {
		blogs = m.readBlogs(inputDirectory);
	}

	@Override
	public void writeOutput(String outputDirectory) {
		v.writeSite(outputDirectory, blogs);
	}

}
