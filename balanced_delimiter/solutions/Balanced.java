import java.util.*;
import java.io.*;

public class Balanced {

	public static void main(String[] args) throws Exception {
		/* java file directory code found from stack overflow  http://stackoverflow.com/questions/1844688/read-all-files-in-a-folder */
		String userDir = System.getProperty("user.dir");
		userDir += "/..";
		userDir += "/tests";
		File folder = new File(userDir);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				if (file.getName().equals(".DS_Store") || file.getName().charAt(0) == 'o') {
					continue;
				}
				File testFile = new File(userDir + "/" + file.getName());
				Scanner fileReader = new Scanner(testFile);
				while (fileReader.hasNextLine()) {
					String testString = fileReader.nextLine();
					System.out.println(file.getName() + ": " + balanced(testString));
				}

			}
		}
	}
	/*
		Create an algorithm that returns whether a given expression is balanced. My own method by using 2 stacks.
	*/
	public static boolean balanced(String expression) {
		Stack<String> left = new Stack<String>();
		Stack<String> right = new Stack<String>();
		for (int i = 0; i < expression.length(); i++) {
				char value = expression.charAt(i);
				switch (value) {
				case '(':
					left.push("(");
					break;
				case '{':
					left.push("{");
					break;
				case '[':
					left.push("[");
					break;
				case ')':
					if (left.peek().equals("("))	{
						left.pop();
					} else {
						return false;
					}
					break;
				case '}':
					if (left.peek().equals("{"))	{
						left.pop();
					} else {
						return false;
					}
					break;
				case ']':
					if (left.peek().equals("["))	{
						left.pop();
					} else {
						return false;
					}
					break;
				default:
					System.out.println("Invalid character");
				}
		}
		if (!left.empty()) {
			return false;
		}
		return true;
	}
}