package simpleblog;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleHTMLView implements View {

	@Override
	public void writeBlogPost(String outputDirectory, Blog blog) {
		Path p = FileSystems.getDefault().getPath(outputDirectory,blog.getTitle()+".txt");

		try {
			Files.write(p, blog.getContents(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void writeSite(String outputDirectory, List<Blog> blogs) {
		
		List<String> index = new ArrayList<String>();
		List<String> listOfBlogs = new ArrayList<String>();
		Collections.sort(blogs);
		int i = 0;
		for(Blog b : blogs) {
			writeBlogPost(outputDirectory, b);
			String blogLink = b.getDate().toString() + ": " + b.getTitle();
			listOfBlogs.add("<a  href = '" +b.getTitle()+".txt" +"'>"+ blogLink + "</a><br/>") ;
			if(++i == 5) {
				i=0;
				listOfBlogs.add("<br/>");
			}
		}
		
		index.add("<html>");
		index.add("<head>");
		index.add("<title>MyBlog</title>");
		index.add("</head>");
		index.add("<body>");
		index.addAll(listOfBlogs);
		index.add("</body>");
		index.add("</html>");
		Path p = FileSystems.getDefault().getPath(outputDirectory,"index.html");
		
		try {
			Files.write(p, index, Charset.defaultCharset());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
