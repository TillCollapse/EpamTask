package myconsole;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private enum Commands {
		prompt, dir, cd, tree, exit, unknown;
	}

	static public void main(String[] args) {
		Console console = null;
		try {
			console = new Console();
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		Scanner input = new Scanner(System.in);
		String commandVal = null;
		Commands c = Commands.unknown;
		System.out.print("[MyShell] $>");
		while (true) {
			commandVal = input.next();
			try {
				c = Commands.valueOf(commandVal);
			} catch (Exception e) {
				c = Commands.unknown;
			}
			switch (c) {
			case prompt:
				String option = input.next();
				if (option.equals("$cwd")) {
					System.out.print("[MyShell] ");
					console.cwd();
					System.out.print(">");
				} else if (option.equals("reset")) {
					System.out.print("[MyShell] $>");
				} else {
					System.out.print("[MyShell] " + option + ">");
				}
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
				System.out.println(commandVal + " :" + " unknown command");
				System.out.print("[MyShell] $>");
			}
		}

	}

}
