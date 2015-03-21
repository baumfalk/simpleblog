package simpleblog;

import java.util.List;

public interface Model {
	public List<Blog> readBlogs(String directory);
	public Blog readBlog(String directory, String name);
}
