package myconsole;

import java.io.File;

abstract class Command {
	static private File path;

	public Command() throws Exception {
		setPath(new File(".").getCanonicalFile());
	}

	public void execute() {
		System.out.println("This command need option ");
	}

	public void execute(String option) {
		System.out.println("This command do not need option yet");
	}

	public File getPath() {
		return Command.path;
	}

	public void setPath(File path) {
		Command.path = path;
	}

}
