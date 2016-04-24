package myconsole;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CdCommand extends Command implements ObservableInterface {
	String state;
	private List<ObserverInterface> observers;
	public CdCommand() throws Exception {
		observers = new ArrayList<ObserverInterface>();
	}

	@Override
	public void execute(String path) {
		if (path.equals("..") && getPath().getParent() != null) {
			directoryUp();
		} else {
			moveToDirectory(path);
		}
	}

	private void directoryUp() {
		setPath(getPath().getParentFile());
		state = getPath().getAbsolutePath() + ">";
		System.out.println(state);
		notifyObservers();
	}

	private void moveToDirectory(String path) {
		File file = new File(getPath() + "/" + path);
		if (file.exists() && file.isDirectory()) {
			setPath(file);
			state = getPath().getAbsolutePath() + ">";
			System.out.println(state);
			notifyObservers();
		} else {
			System.out.println("Directory does not exist");
		}
	}

	@Override
	public void addObserver(ObserverInterface observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		for (ObserverInterface ob : observers) {
			ob.actualize(state);
		}
	}

}