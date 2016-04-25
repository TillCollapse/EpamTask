package myconsole;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PromptCommand extends Command implements ObservableInterface {
	private String state = "$>";
	private List<ObserverInterface> observers;

	public PromptCommand() throws Exception {
		observers = new ArrayList<ObserverInterface>();
	}

	public PromptCommand(File path) {
		super(path);
		observers = new ArrayList<ObserverInterface>();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	public void execute(String option) {
		if (option.equals("$cwd")) {
			try {
				changeState(getPath().getCanonicalPath() + ">");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (option.equals("reset")) {
			changeState("$>");
		} else {
			changeState(option + ">");
		}
	}

	private void changeState(String newState) {
		this.state = newState;
		notifyObservers();
	}

	@Override
	public void addObserver(ObserverInterface observer) {
		observers.add(observer);
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		for (ObserverInterface ob : observers) {
			ob.actualize(state);
		}
	}

}
