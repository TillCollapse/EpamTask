package myconsole;

public interface ObservableInterface {
	void addObserver(ObserverInterface observer);

	// void deleteObserver(ObserverInterface observer);
	
	void notifyObservers();
}
