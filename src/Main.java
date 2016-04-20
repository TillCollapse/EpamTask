import java.io.IOException;
import java.util.Scanner;

public class Main {
	private enum Commands {
		$cwd, reset, dir, cd, tree, exit, unknown;
	}

	static public void main(String[] args) {
		Console console = null;
		try {
			console = new Console();hhhh
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		Scanner input = new Scanner(System.in);  
		String commandVal = null;
		Commands c;
		System.out.print("[MyShell] $>");
		while (true) {
			if (checkPrompt(input.next())) {
				commandVal = input.next();
				c = checkCommand(commandVal);
				switch (c) {
				case $cwd:
					System.out.print("[MyShell] ");
					console.cwd();
					System.out.print(">");
					break;
				case reset:
					System.out.print("[MyShell] $>");
					break;
				case dir:
					System.out.print("[MyShell] ");
					console.dir();
					break;
				case cd:
					System.out.print("[MyShell] ");
					console.cd(input.next());
					break;
				case tree:
					console.tree();
					System.out.print("[MyShell] $>");
					break;
				case exit:
					console.exit();
					input.close();
					System.exit(0);
					break;
				default:
					System.out.print("[MyShell] " + commandVal + ">");
				}
			} else {
				input.nextLine();
			}
		}
	}

	static private Commands checkCommand(String commandVal) {
		Commands command = Commands.unknown;
		for (Commands c : Commands.values()) {
			if (c.name().equalsIgnoreCase(commandVal)) {
				command = c;
				break;
			}
		}

		return command;
	}

	static private boolean checkPrompt(String promptVal) {
		if (promptVal.equals("prompt")) {
			return true;
		} else {
			System.out.println(promptVal + " :" + " unknown command");
			return false;
		}
	}

}
