package simpleblog;

public interface Controller {

	void addModel(Model m);

	void addView(View v);

	void readInput(String inputDirectory);

	void writeOutput(String outputDirectory);

}
