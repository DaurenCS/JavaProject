package viewPackage;

import userPackage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import mainPackage.Data;
import mainPackage.UniSystem;

/**
 * @generated
 */
public class AdminMenu extends EmployeeMenu {

	public static String[] inputUserInfo() throws IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name: ");
		String name = inp.readLine();
		System.out.println("Enter surname: ");
		String surname = inp.readLine();
		System.out.println("Enter ID: ");
		String id = inp.readLine();
		String[] nsi = new String[3];
		nsi[0] = name;
		nsi[1] = surname;
		nsi[2] = id;
		return nsi;
	}

	public static double inputEmployeeInfo() throws IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter salary: ");
		double salary = Double.parseDouble((inp.readLine()));
		return salary;
	}

	public static void inputSudentInfo(Student s) throws IOException, ClassNotFoundException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Student type: 1.BACHELOR || 2.MASTER || 3.PHD");
		int type = Integer.parseInt((inp.readLine()));
		if (type == 1) {
			s.setType(StudentType.BACHELOR);
		} else if (type == 2) {
			s.setType(StudentType.MASTER);
		} else if (type == 3) {
			s.setType(StudentType.PHD);
		}
		Data data = Data.getInstance();
		Vector<Faculty> fl = data.getFaculties();
		System.out.print("Available faculties: ");
		int cnt = 1;
		for (Faculty f : fl) {
			System.out.print(cnt + ". " + f.getName() + " ");
			cnt += 1;
		}
		while (true) {
			type = Integer.parseInt((inp.readLine()));
			try {
				s.setFaculty(fl.get(type - 1));
				break;
			} catch (Exception e) {
				System.out.println("!OUT OF RANGE!");
			}
		}
	}

	public void show() throws IOException, ClassNotFoundException {
		// ...
		UserFactory userFactory = new UserFactory();
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("||   𝔸𝔻𝕄𝕀ℕ   ||");
			System.out.println("1.users || 2.faculties || 3.view info(test) ||4.view news || 5.view mail || 6.out");
			int input = Integer.parseInt(inp.readLine());
			if (input == 1) {
				System.out.println("|| USERS ||");
				System.out.println("1.add user || 2.view/delete user");
				try {
					input = Integer.parseInt(inp.readLine());
					if (input == 1) {
						System.out.println(
								"TYPE OF USER(0 to exit): 1.admin || 2.student || 3.teacher || 4.manager || 5.librarian");
						int type = Integer.parseInt(inp.readLine());
						if (type == 1) {
							Admin.addUser("admin");
						} else if (type == 2) {
							Admin.addUser("student");
						} else if (type == 3) {
							Admin.addUser("teacher");
						} else if (type == 4) {
							Admin.addUser("manager");
						} else if (type == 5) {
							Admin.addUser("librarian");
						}
					} else if (input == 2) {
						Data data = Data.getInstance();
						Vector<User> ul = data.getUserList();
						System.out.println("―".repeat(70));
						int cnt = 1;
						for (User u : ul) {
							System.out.print(cnt + ". ");
							System.out.println(u);
							System.out.println("―".repeat(70));
							cnt += 1;
						}
						while (true) {
							System.out.print("WHICH ONE TO DELETE?: (0 to exit)");
							try {
								int num = Integer.parseInt(inp.readLine());
								if (num == 0) {
									break;
								}
								try {
									Admin.deleteUser(ul.get(num - 1));
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
			} else if (input == 2) {
				System.out.println("||  FACULTIES  ||");
				System.out.println("1.view all || 2.add new || 3.delete");
				try {
					input = Integer.parseInt(inp.readLine());
					Data data = Data.getInstance();
					if (input == 1) {
						Vector<Faculty> fl = data.getFaculties();
						System.out.println("―".repeat(70));
						int cnt = 1;
						for (Faculty f : fl) {
							System.out.print(cnt + ". ");
							System.out.println(f);
							System.out.println("―".repeat(70));
							cnt += 1;
						}
					} else if (input == 2) {
						System.out.print("Enter name(short, ex: 'FIT'): ");
						String name = inp.readLine();
						System.out.print("Enter description ");
						String description = this.enterLongText();
						Faculty newF = new Faculty(name, description);
						while (true) {
							System.out.println("WANT TO ADD COURSES? 1.YES || 2.NO");
							try {
								input = Integer.parseInt(inp.readLine());
								if (input == 1) {
									System.out.print("Enter name(short, ex: 'OOP'): ");
									name = inp.readLine();
									System.out.print("Enter description ");
									description = this.enterLongText();
									System.out.println("Enter number of credits: ");
									int credits = 0;
									while (true) {
										try {
											credits = Integer.parseInt(inp.readLine());
											break;
										} catch (Exception e) {
											System.out.println("!NOT A NUMBER!");
										}
									}
									CourseType ct;
									System.out.println("What type? 1.MAJOR || 2.ELECTIVE");
									while (true) {
										try {
											int type = Integer.parseInt(inp.readLine());
											if (type == 1) {
												ct = CourseType.MAJOR;
											} else {
												ct = CourseType.ELECTIVE;
											}
											break;
										} catch (Exception e) {
											System.out.println("!NOT A NUMBER!");
										}
									}
									System.out.print("Enter code(ex: 'CSCI2106'): ");
									String code = inp.readLine();
									Course newC = new Course(name, description, credits, ct, code);
									System.out.println(newC);
									System.out.println("Add this course to " + newF + " ? 1.YES || 2.NO");
									input = Integer.parseInt(inp.readLine());
									if (input == 1) {
										newF.addCourse(newC);
									}
								} else
									break;
							} catch (Exception e) {
								System.out.println("!NOT A NUMBER!");
							}
						}
						data.addFaculty(newF);
					} else if (input == 3) {
						Vector<Faculty> fl = data.getFaculties();
						System.out.println("―".repeat(70));
						int cnt = 1;
						for (Faculty f : fl) {
							System.out.print(cnt + ". ");
							System.out.println(f);
							System.out.println("―".repeat(70));
							cnt += 1;
						}
						Admin adm = (Admin) UniSystem.getUser();
						while (true) {
							System.out.print("WHICH ONE TO DELETE?: (0 to exit)");
							try {
								int num = Integer.parseInt(inp.readLine());
								if (num == 0) {
									break;
								}
								try {
									adm.deleteFaculty(fl.get(num - 1));
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
				this.viewInfo();
				System.out.print("Enter old password: ");
				String oldP = inp.readLine();
				System.out.print("Enter new password: ");
				String newP = inp.readLine();
				Data.getInstance().changePassword(UniSystem.getUser(), oldP, newP);
			} else if (input == 4) {
				viewNews();
			} else if (input == 5) {
				System.out.println("1.view all || 2.send new");
				input = Integer.parseInt(inp.readLine());
				if (input == 1) {
					this.viewMessages();
				} else if (input == 2) {
					this.sendMessage();
				}
			} else if (input == 6) {
				System.out.println("Logging out...");
				break;
			} else {
				System.out.println("WHY you!!!");
			}
		}
	}
}
