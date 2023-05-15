package viewPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import mainPackage.UniSystem;
import userPackage.Attendance;
import userPackage.Course;
import userPackage.Student;
import userPackage.Teacher;

/**
 * @generated
 */
public class TeacherMenu extends EmployeeMenu {

	public void show() throws IOException, ClassNotFoundException {
		// ...
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			Teacher t = (Teacher) UniSystem.getUser();
			System.out.println("||   𝕋𝔼𝔸ℂℍ𝔼ℝ   ||");
			System.out.println("1.view own couses  2.view schedule  3.smth || 4.out");
			int input = Integer.parseInt(inp.readLine());
			if (input == 1) {
				Vector<Course> ctt = t.getCoursesToTeach();
				if (ctt.isEmpty()) {
					System.out.println("YOU HAVE NO COURSES TO TEACH");
					continue;
				}
				int cnt = 0;
				for (Course c : ctt) {
					cnt++;
					System.out.println(cnt + ". " + c.getName());
				}

				while (true) {
					try {
						System.out.println("Choose Course: (0 - exit)");
						input = Integer.parseInt(inp.readLine());
						if (input == 0) {
							break;
						}

						if (input >= 1 && input <= cnt) {
							System.out.println(
									"1.Put the Mark  2.Put attendance  3.Get Attendance List  4.Put attestation || 5.back");
							Course cur = ctt.get(input - 1);
							Vector<Student> s = t.getStudentsList(cur);
							input = Integer.parseInt(inp.readLine());
							if (s.size() == 0) {
								System.out.println("There no students");
								break;
							}
							cnt = 0;
							for (Student student : s) {
								cnt++;
								System.out.println(cnt + ". " + student.getName() + " " + student.getSurname());

							}
							System.out.println("Choose student");
							if (input == 1) {
								input = Integer.parseInt(inp.readLine());

								if (input > 0 && input <= s.size()) {
									System.out.println("Which Mark");
									double mark = Double.parseDouble(inp.readLine());
									t.putMark(cur, s.get(input - 1), mark);
									break;
								} else {
									System.out.println("Somthing wrong");
									break;
								}

							} else if (input == 2) {
								input = Integer.parseInt(inp.readLine());
								System.out.println("1-Present || 2-Absent");
								int attend = Integer.parseInt(inp.readLine());
								if (attend == 1)
									t.putAttendance(cur, s.get(input - 1), Attendance.PRESENT);
								else
									t.putAttendance(cur, s.get(input - 1), Attendance.ABSENT);
								break;
							}

							else if (input == 3) {
								input = Integer.parseInt(inp.readLine());
								System.out.println(String.format("Attendance list for %s  %s, Course: %s",
										s.get(input - 1).getName(), s.get(input - 1).getSurname(), cur.getName()));
								t.getAttendanceList(cur, s.get(input - 1));
							}

							else if (input == 4) {
								input = Integer.parseInt(inp.readLine());
								System.out.println(
										"1. Put First Attestation  2. Put Second Attestation  3.Put Final Attestation");
								int att = Integer.parseInt(inp.readLine());
								System.out.println("Which Mark");
								double mark = Double.parseDouble(inp.readLine());
								t.putAttestation(cur, s.get(input - 1), mark, att);
							}

							else if (input == 5) {
								break;
							}
						} else
							System.out.println("Out of Range");
					} catch (Exception e) {
						System.out.println("Sorry please try again");
					}

				}
			} else if (input == 2) {
				System.out.println("|| SCHEDULE ||");
				System.out.println(t.getSchedule());
			} else if (input == 4) {
				System.out.println("Logging out...");
				break;
			} else {
				System.out.println("WHY( you!!!");
			}
		}
	}
}