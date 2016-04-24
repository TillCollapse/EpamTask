package myconsole;

import java.io.File;
import java.io.IOException;

public class TreeCommand extends Command {

	public TreeCommand() throws Exception {

	}

	@Override
	public void execute() {
		try {
			System.out.println(getPath().getCanonicalFile().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

		treeTraversal(getPath(), 0);
	}

	private void treeTraversal(File file, int c) {
		int count = c + 1;
		for (File item : file.listFiles()) {
			for (int i = 0; i < count; i++) {
				System.out.print("-");
			}

			if (item.isDirectory()) {
				System.out.println(item.getName());
				treeTraversal(item, count);
			} else {
				System.out.println(item.getName());
			}
		}
	}
}
