package simpleblog;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TextModel implements Model {

	@Override
	public List<Blog> readBlogs(String directory) {
		// TODO Auto-generated method stub
		
		List<String> directoryContent 	= getDirectoryContent(directory);
		List<Blog> blogs				= new ArrayList<Blog>();
		for(String blogFileName : directoryContent) {
			Blog blog = readBlog(directory, blogFileName);
			blogs.add(blog);
		}
		
		return blogs;
	}

	private List<String> getDirectoryContent(String directory) {
		
		List<String> contents = new ArrayList<String>();
		File folder = new File(directory);
		
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            continue;
	        } else {
	        	if(fileEntry.getName().endsWith(".txt")) {
	        		contents.add(fileEntry.getName());
	        	}
	        }
	    }
		return contents;
	}

	@Override
	public Blog readBlog(String directory, String blogFileName) {
		Path p = FileSystems.getDefault().getPath(directory, blogFileName);
		Blog b = new Blog();
		String blogTitle = blogFileName.replace(".txt", "");
		b.setTitle(blogTitle);
		try {
			FileTime modifiedDate = Files.getLastModifiedTime(p);
			Date date = new Date(modifiedDate.toMillis());
			List<String> contents = Files.readAllLines(p, Charset.defaultCharset());
			b.setDate(date);
			b.setContents(contents);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}
