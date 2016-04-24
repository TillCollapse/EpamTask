package myconsole;

public class ExitCommand extends Command {

	public ExitCommand() throws Exception {

	}

	@Override
	public void execute() {
		System.out.println("Bye");
		System.exit(0);
	}

}
