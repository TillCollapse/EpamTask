import java.io.File;
import java.io.IOException;

public class Console implements ConsoleInterface {
	private File path = null;

	public Console() throws IOException, SecurityException {
		this.path = new File(".").getCanonicalFile();
	}

	public void cwd() {
		if (path.exists())
			try {
				System.out.print(path.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		else {
			System.out.print("This directory does not exist");
		}
	}

	public void reset() {

	}

	public void dir() {
		System.out.println("Content of " + path.getAbsolutePath());
		File[] list = path.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				System.out.println("DIR \t" + list[i].getName());
			} else {
				System.out.println("FILE \t" + list[i].getName());
			}
		}

		System.out.print(this.path.getAbsolutePath() + ">");
	}

	public void target() {

	}

	public void cd(String path) {
		if (path.equals("..") && this.path.getParent() != null) {
			this.path = this.path.getParentFile();
			System.out.print(this.path.getAbsolutePath() + ">");
		} else {
			File file = new File(this.path + "/" + path);
			if (file.exists() && file.isDirectory()) {
				this.path = file;
				System.out.print(this.path.getAbsolutePath() + ">");
			} else {
				System.out.println("Directory does not exist");
			}
		}
	}

	public void tree() {
		try {
			System.out.println(path.getCanonicalFile().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

		treeTraversal(path, 0);
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

	public void exit() {
		System.out.println("Bye");
	}
}
