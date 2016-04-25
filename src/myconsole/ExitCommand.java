package myconsole;

import java.io.File;

public class ExitCommand extends Command {

	public ExitCommand() throws Exception {

	}

	public ExitCommand(File path) {
		super(path);
	}

	@Override
	public void execute() {
		System.out.println("Bye");
		System.exit(0);
	}

}
