package myconsole;

import java.io.File;

public class DirCommand extends Command {
	public DirCommand() throws Exception {

	}

	public void execute() {
		System.out.println("Content of " + getPath().getAbsolutePath());
		File[] list = getPath().listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				System.out.println("DIR \t" + list[i].getName());
			} else {
				System.out.println("FILE \t" + list[i].getName());
			}
		}
	}

}
