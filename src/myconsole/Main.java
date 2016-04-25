package myconsole;

import java.io.File;
import java.io.IOException;

public class Main {

	static public void main(String[] args) {
		// Start path may be download by args parameter of main method in the
		// future
		File path = null;
		try {
			path = new File(".").getCanonicalFile();
		} catch (IOException e) {
			System.out.println("Wrong path");
			e.printStackTrace();
		}
		// default command builder
		// CommandBuilder commandBuilder = new CommandBuilder();
		CommandBuilder commandBuilder = new CommandBuilder(path);
		CommandLine cli = new CommandLine(commandBuilder);
		cli.initCli();
	}
}
