package viewPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import mainPackage.Data;
import mainPackage.UniSystem;
import userPackage.Admin;
import userPackage.Faculty;
import userPackage.Librarian;
import utilPackage.Book;

/**
 * @generated
 */
public class LibrarianMenu extends EmployeeMenu {

	public void show() throws IOException, ClassNotFoundException {
		// ...
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1.giveBook || 2.Books || 3.view news || 4.view mail || 5.out");
			int input = Integer.parseInt(inp.readLine());
			Data data = Data.getInstance();
			if (input == 4) {
				System.out.println("Logging out...");
				break;
			} else if (input == 1) {
				System.out.println("Not implemented yet");
			} else if (input == 2) {
				System.out.println("|| BOOKS ||");
				System.out.println("1.view all || 2.add new || 3.delete");
				try {
					input = Integer.parseInt(inp.readLine());
					if (input == 1) {
						Vector<Book> bl = data.getLibrary();
						System.out.println("―".repeat(70));
						int cnt = 1;
						for (Book b : bl) {
							System.out.print(cnt + ". ");
							System.out.println(b);
							System.out.println("―".repeat(70));
							cnt += 1;
						}
					} else if (input == 2) {
						System.out.print("Enter name: ");
						String name = inp.readLine();
						System.out.print("Enter author: ");
						String author = inp.readLine();
						System.out.print("Enter description ");
						String description = this.enterLongText();
						System.out.print("Enter text: ");
						String text = this.enterLongText();
						Book newbook = new Book(name, author, description, text);
						data.addBook(newbook);
					} else if (input == 3) {
						Vector<Book> bl = data.getLibrary();
						System.out.println("―".repeat(70));
						int cnt = 1;
						for (Book b : bl) {
							System.out.print(cnt + ". ");
							System.out.println(b);
							System.out.println("―".repeat(70));
							cnt += 1;
						}
						Librarian lib = (Librarian) UniSystem.getUser();
						while (true) {
							System.out.print("WHICH ONE TO DELETE?: (0 to exit)");
							try {
								int num = Integer.parseInt(inp.readLine());
								if (num == 0) {
									break;
								}
								try {
									lib.deleteBook(bl.get(num - 1));
									break;
								} catch (Exception e) {
									e.printStackTrace();
									System.out.println("!OUT OF RANGE!");
								}
							} catch (Exception e) {
								System.out.println("!NOT A NUMBER!");
							}
						}
					}

				} catch (Exception e) {
					System.out.println("!WRONG FORMAT!");
				}
			} else if (input == 3) {
				viewNews();
			} else if (input == 4) {
				System.out.println("1.view all || 2.send new");
				input = Integer.parseInt(inp.readLine());
				if (input == 1) {
					this.viewMessages();
				} else if (input == 2) {
					this.sendMessage();
				}
			} else if (input == 5) {
				System.out.println("Logging out...");
				break;
			} else {
				System.out.println("WHY( you!!!");
			}
		}
	}
}
