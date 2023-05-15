package viewPackage;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

import mainPackage.Data;
import mainPackage.UniSystem;
import userPackage.*;
import utilPackage.*;

/**
 * @generated
 */
public class Menu {

	/**
	 * @generated
	 */
	private Vector<String> language;

	/**
	 * @generated
	 */
	public Vector<String> getLanguage() {
		return this.language;
	}

	/**
	 * @generated
	 */
	public void changeLang(String lang) {
		this.language = Language.getLanguage(lang);
	}

	protected void viewInfo() {
		System.out.println("   ⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣠⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n" + "      ⠀⠀⣀⣤⡶⠟⠛⠉⠉⠉⠉⠉⠉⠛⠻⢷⣦⣄⠀⠀⠀⠀⠀⠀⠀\n"
				+ "  ⠀⠀⠀⣠⡾⠋⠁⠀⠀⢀⣠⣤⣤⣤⣤⣀⠀⠀⠀⠈⠙⢷⣦⡀⠀⠀ ⠀⠀\n" + " ⠀⠀⢠⡾⠋⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠙⢷⣄⠀⠀⠀\n"
				+ " ⠀⢠⡿⠁⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⢻⣆⠀⠀\n" + " ⢠⣿⠁⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⢿⡄⠀\n"
				+ " ⢸⡇⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡅⠀⠀⠀⠀⠀⠀⢸⣇⠀\n" + " ⢸⡇⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⢸⣿⠀\n"
				+ " ⢸⡇⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⢸⡏⠀\n" + " ⠘⣿⡀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⣾⠃⠀\n"
				+ " ⠀⠹⣷⡀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⣼⠏⠀⠀\n" + " ⠀⠀⠙⢷⣄⢀⣠⣴⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⣀⢠⣾⠋⠀⠀⠀\n"
				+ " ⠀⠀⠀⠈⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀\n" + " ⠀⠀⠀⠀⠀⠀⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⠀⠀\n"
				+ " ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠙⠛⠛⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
	}

	protected void viewOrganizations() throws ClassNotFoundException, IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		Vector<Organization> ors = Data.getInstance().getAllOrganizations();
		System.out.println("||  ORGANIZATIONS  ||");
		System.out.println("1.view all || 2.view own");
		while (true) {
			try {
				int input = Integer.parseInt(inp.readLine());
				if (input == 1) {
					Collections.sort(ors);
					System.out.println("―".repeat(70));
					int cnt = 1;
					for (Organization o : ors) {
						try {
							System.out.println(cnt + ". " + o.getName() + " || " + o.countMembers() + " || "
									+ o.getHead().simpleToString());
						} catch (Exception e) {
							System.out.println(cnt + ". " + o.getName() + " || " + o.countMembers() + " || NO HEAD");
						}
						System.out.println("―".repeat(70));
						cnt += 1;
					}
					System.out.print("WHICH ONE TO JOIN(0 to exit): ");
					while (true) {
						try {
							int or = Integer.parseInt(inp.readLine());
							if (or == 0) {
								break;
							}
							try {
								System.out.println(ors.get(or - 1));
								System.out.println("WANT TO JOIN?: 1.YES || 2.NO");
								input = Integer.parseInt(inp.readLine());
								if (input == 1) {
									UniSystem.getUser().joinOrganization(ors.get(or - 1));
								}
								break;
							} catch (Exception e) {
								System.out.println("!OUT OF RANGE!");
							}

						} catch (Exception e) {
							System.out.println("!WRONG FORMAT!");
						}
					}
				} else if (input == 2) {
					HashMap<Organization, Status> oNs = UniSystem.getUser().getOrganizationsAndStatus();
					System.out.println("―".repeat(70));
					int cnt = 1;
					for (Entry<Organization, Status> e : oNs.entrySet()) {
						System.out.println(
								cnt + ". " + e.getKey() + " " + e.getKey().countMembers() + " " + e.getValue());
						System.out.println("―".repeat(70));
						cnt += 1;
					}
					System.out.print("WHICH ONE TO LEAVE(0 to exit): ");
					while (true) {
						try {
							int or = Integer.parseInt(inp.readLine());
							if (or == 0) {
								break;
							}
							try {
								System.out.println(ors.get(or - 1));
								System.out.println("WANT TO LEAVE?: 1.YES || 2.NO");
								input = Integer.parseInt(inp.readLine());
								if (input == 1) {
									UniSystem.getUser().leaveOrganization(ors.get(or - 1));
								}
								break;
							} catch (Exception e) {
								System.out.println("!OUT OF RANGE!");
							}

						} catch (Exception e) {
							System.out.println("!WRONG FORMAT!");
						}
					}

				}
				break;
			} catch (Exception e) {
				System.out.println("!WRONG FORMAT!");
			}
		}
	}

	protected void viewNews() throws ClassNotFoundException, IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		User u = UniSystem.getUser();
		Vector<News> news = u.getNews();
		System.out.println("||  NEWS  ||");
		System.out.println("―".repeat(70));
		int cnt = 1;
		for (News s : news) {
			System.out.println(cnt + ". " + s.getTitle());
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
					System.out.println(news.get(input - 1));
					break;
				} catch (Exception e) {
					System.out.println("!OUT OF RANGE!");
				}

			} catch (Exception e) {
				System.out.println("!WRONG FORMAT!");
			}
		}
	}

	/**
	 * @generated
	 */
	public boolean changePassword() {
		// TODO
		return false;
	}

	public void show() throws IOException, ClassNotFoundException {

	}

	public int uniStart() throws IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" ╒══════════════════════════════════════════╕\n"
				+ "██╗░░░██╗███╗░░██╗██╗░██████╗██╗░░░██╗░██████╗\n"
				+ "██║░░░██║████╗░██║██║██╔════╝╚██╗░██╔╝██╔════╝\n"
				+ "██║░░░██║██╔██╗██║██║╚█████╗░░╚████╔╝░╚█████╗░\n"
				+ "██║░░░██║██║╚████║██║░╚═══██╗░░╚██╔╝░░░╚═══██╗\n"
				+ "╚██████╔╝██║░╚███║██║██████╔╝░░░██║░░░██████╔╝\n"
				+ "░╚═════╝░╚═╝░░╚══╝╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░\n ╘══════════╛⁽ⁿᵒᵗ ʷˢᵖ⁾   v.0.0.1 ╘══════════╛\n");
		while (true) {
			System.out.println("1.log in || 2.exit");
			try {
				int input = Integer.parseInt(inp.readLine());
				if (input == 1) {
					return 1;
				}
				if (input == 2) {
					return 2;
				}
				System.out.println("  !NO SUCH OPTIONS!  ");
			} catch (Exception e) {
				System.out.println("  !WRONG FORMAT!  ");
			}

		}

	}

	protected String enterLongText() throws IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("(you may write with enters, to end writing enter '-END-' without ''");
		String longText = "";
		while (true) {
			String line = inp.readLine();
			if (line.equals("-END-")) {
				break;
			}
			longText += "\n" + line;
		}
		return longText;
	}

	public String getLogin() throws IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter your login ");
		return inp.readLine();
	}

	public String getPassword() throws IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter your password ");
		return inp.readLine();
	}

}
