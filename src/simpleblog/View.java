package simpleblog;

import java.util.List;

public interface View {
	public void writeBlogPost(String outputDirectory, Blog blog);
	public void writeSite(String outputDirectory, List<Blog> blogs);
}
