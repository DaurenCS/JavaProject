package viewPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.stream.Collectors;
import mainPackage.UniSystem;
import userPackage.Course;
import userPackage.Student;

/**
 * @generated
 */
public class StudentMenu extends Menu {

	public void show() throws IOException, ClassNotFoundException {
		// ...
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			Student st = (Student) UniSystem.getUser();
			System.out.println("||   𝕊𝕋𝕌𝔻𝔼ℕ𝕋   ||");
			System.out.println(
					"1.view journal  2.view schedule  3.add/drop  4.view transcript  5.view news  6.view organizations  7.log OUT");
			int input = Integer.parseInt(inp.readLine());
			if (input == 1) {
				System.out.println("Choose course:");
				Vector<Course> course = (Vector<Course>) st.getTranscript().getCurCourses().keySet().stream()
						.collect(Collectors.toCollection(Vector::new));
				int cnt = 0;
				for (Course c : course) {
					cnt++;
					System.out.println(cnt + ". " + c.getName());
				}
				input = Integer.parseInt(inp.readLine());
				if (input <= cnt) {
					System.out.println(st.getJournal().getJournalForCourse(course.get(input - 1)));
				} else
					System.out.println("Out of Range");

			} else if (input == 2) {
				System.out.println(st.getSchedule());
			} else if (input == 3) {
				System.out.println("Here will be add/drop");
				System.out.println("Available courses: ");
				Vector<Course> crs = st.getFaculty().getCourses();
				int cnt = 1;
				for (Course c : crs) {
					System.out.print(cnt + ". " + c.getName() + " ");
					if (c.getStudents().contains(st)) {
						System.out.print("✅");
					} else {
						System.out.print("❌");
					}
					System.out.println();
					cnt += 1;
				}
				while (true) {
					try {
						int cr = Integer.parseInt(inp.readLine());
						if (cr == 0) {
							break;
						}
						try {
							System.out.println("Description: " + crs.get(cr - 1).getDescription()
									+ "\nWANT TO ADD? 1.YES || 2.NO");
							try {
								int ans = Integer.parseInt(inp.readLine());
								if (ans == 1) {
									if (crs.get(cr - 1).getStudents().contains(st)
											|| st.getTranscript().getDoneCourses().containsKey(crs.get(cr - 1))) {
										System.out.println("You already have this course!");
									} else {
										st.addCourse(crs.get(cr - 1));
									}
								}
								break;
							} catch (Exception e) {
								System.out.println("!WRONG FORMAT!");
							}
						} catch (Exception e) {
							System.out.println("!OUT OF RANGE!");
						}
					} catch (Exception e) {
						System.out.println("!WRONG FORMAT!");
					}

				}

			} else if (input == 4) {
				System.out.println(st.getTranscript().getTranscript());
			} else if (input == 5) {
				viewNews();
			} else if (input == 6) {
				viewOrganizations();
			} else if (input == 7) {
				System.out.println("Logging out...");
				break;
			} else {
				System.out.println("WHY( you!!!");
			}
		}
	}

}