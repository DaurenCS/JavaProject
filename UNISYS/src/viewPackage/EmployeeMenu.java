package viewPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.stream.Collectors;

import mainPackage.Data;
import mainPackage.UniSystem;
import userPackage.Employee;
import utilPackage.Message;

/**
 * @generated
 */
public class EmployeeMenu extends Menu {
	/**
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @generated
	 */
	public void sendMessage() throws ClassNotFoundException, IOException {
		Vector<Employee> ems = Data.getInstance().getUserList().stream().filter(u -> u instanceof Employee)
				.map(u -> (Employee) u).collect(Collectors.toCollection(Vector::new));
		System.out.println("―".repeat(70));
		int cnt = 1;
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		for (Employee e : ems) {
			System.out.println(cnt + ". " + e.simpleToString());
			System.out.println("―".repeat(70));
			cnt += 1;
		}
		System.out.println("WHOM TO SEND?(0 to exit)");
		while (true) {
			try {
				int input = Integer.parseInt(inp.readLine());
				if (input == 0)
					break;
				try {
					Employee e = ems.get(input - 1);
					System.out.print("Enter title: ");
					String title = inp.readLine();
					System.out.print("Enter text: ");
					String text = this.enterLongText();
					Employee from = (Employee) UniSystem.getUser();
					from.sendMessage(e, title, text);
					break;
				} catch (Exception e) {
					System.out.println("!OUT OF RANGE!");
				}
			} catch (Exception e) {
				System.out.println("!WRONG FORMAT!");
			}
		}
	}

	public void viewMessages() {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		Employee e = (Employee) UniSystem.getUser();
		Vector<Message> mailBox = e.getMailBox();
		System.out.println("―".repeat(70));
		int cnt = 1;
		for (Message m : mailBox) {
			System.out.print(cnt + ". " + m);
			if (m.getStatus()) {
				System.out.println(" ✓");
			} else {
				System.out.println(" ☓");
			}
			System.out.println("―".repeat(70));
			cnt += 1;
		}
		System.out.println("WHICH ONE TO READ?(0 to exit)");
		while (true) {
			try {
				int input = Integer.parseInt(inp.readLine());
				if (input == 0) {
					break;
				}
				try {
					System.out.println(mailBox.get(input - 1).getText());
					mailBox.get(input - 1).setStatus(true);
					break;
				} catch (Exception ex) {
					System.out.println("!OUT OF RANGE!");
				}

			} catch (Exception ex) {
				System.out.println("!WRONG FORMAT!");
			}
		}
	}

	public void show() throws IOException, ClassNotFoundException {
		// ...
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1.smth || 2.smth || 3.smth || 4.out");
			int input = Integer.parseInt(inp.readLine());
			if (input == 4) {
				System.out.println("Logging out...");
				break;
			} else {
				System.out.println("WHY< you!!!");
			}
		}
	}

}
