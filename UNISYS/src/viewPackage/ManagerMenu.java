package viewPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.stream.Collectors;

import mainPackage.Data;
import mainPackage.UniSystem;
import userPackage.*;
import utilPackage.*;


/**
* @generated
*/
public class ManagerMenu extends EmployeeMenu {
    
	public void createCourse(Faculty f) {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("WANT TO ADD COURSES? 1.YES || 2.NO");
			try {
				int input = Integer.parseInt(inp.readLine());
				if(input == 1) {
					System.out.print("Enter name(short, ex: 'OOP'): ");
					String name = inp.readLine();
					System.out.print("Enter description ");
					String description = this.enterLongText();
					System.out.println("Enter number of credits: ");
					int credits = 0;
					while(true) {
    					try {
    						credits = Integer.parseInt(inp.readLine());
    						break;
    					}
    					catch(Exception e) {
    						System.out.println("!NOT A NUMBER!");
    					}
					}
					CourseType ct;
					System.out.println("What type? 1.MAJOR || 2.ELECTIVE");
					while(true) {
    					try {
    						int type = Integer.parseInt(inp.readLine());
    						if(type == 1) {
    							ct = CourseType.MAJOR;
    						}
    						else {
    							ct = CourseType.ELECTIVE;
    						}
    						break;
    					}
    					catch(Exception e) {
    						System.out.println("!NOT A NUMBER!");
    					}
					}
					System.out.print("Enter code(ex: 'CSCI2106'): ");
					String code = inp.readLine();
					Course newC = new Course(name, description, credits, ct, code);
					System.out.println(newC);
					System.out.println("Add this course to " + f+ " ? 1.YES || 2.NO");
					input = Integer.parseInt(inp.readLine());
					if(input == 1) {
						f.addCourse(newC);
					}
				}else break;
			}
			catch(Exception e) {
				System.out.println("!NOT A NUMBER!");
			}
		}
	}
    
	public void show() throws IOException, ClassNotFoundException {
    	//...
    	BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    	while(true) {
    		System.out.println("||   𝕄𝔸ℕ𝔸𝔾𝔼ℝ   ||");
    		System.out.println("1.manage requests || 2.manage faculties || 3.view news || 4.view mail || 5.manage lessons || 6.out");
    		int input = Integer.parseInt(inp.readLine());
    		Data data = Data.getInstance();
    		if(input == 1) {
    			Vector<Request> rqs = data.getAllRequests();
    			Vector<Request> tmp_rqs = (Vector<Request>) rqs.clone();
    			System.out.println("|| REQUESTS ||");
    			for(Request r : tmp_rqs) {
    				System.out.println(r + " COMPLITE?: 1.YES || 2.NO");
    				try {
    					input = Integer.parseInt(inp.readLine());
    					if(input == 1) {
    						r.complete();
    						System.out.println("DONE! ");
    						
    					}
    					rqs.remove(r);
    					System.out.println("NEXT->");
    				}
    				catch(Exception e) {
    					System.out.println("!WRONG FORMAT!");
    				}
    				
    			}
    			System.out.println("NO MORE REQUESTS");
    		}
    		else if(input == 2) {
    			System.out.println("||  FACULTIES  ||");
    			System.out.println("1.view all || 2.add new || 3.delete");
    			try {
    				input = Integer.parseInt(inp.readLine());
    				if(input == 1) {
	    				Vector<Faculty> fl = data.getFaculties();
	    				System.out.println("―".repeat(70)); int cnt = 1;
						for(Faculty f : fl) {
							System.out.print(cnt + ". ");
							System.out.println(f);
							System.out.println("―".repeat(70));
							cnt += 1;
						}
						System.out.println("WHICH ONE?(0 to exit)");
						try {
							input = Integer.parseInt(inp.readLine());
							try {
								Faculty f = fl.get(input-1);
								System.out.println("WHAT TO DO WITH THIS FACULTY? 1.view courses || 2.change info");
								input = Integer.parseInt(inp.readLine());
								if(input == 1) {
									Vector<Course> crs = f.getCourses(); cnt = 1;
									System.out.println("―".repeat(70));
									for(Course c : crs) {
										System.out.println(cnt + ". " + c);
										System.out.println("―".repeat(70));
									}
									System.out.print("1.add new || 2.delete || 3.view info || 4.change info");
									input = Integer.parseInt(inp.readLine());
									if(input == 1) {
										createCourse(f);
									}
									else if(input == 2) {
										cnt = 1;
										if(f.getCourses().isEmpty()) {
											System.out.println("NO COURSES");
											continue;
										}
										for(Course c : f.getCourses()) {
											System.out.println(cnt + ". " + c);
											cnt += 1;
										}
										System.out.println("WHICH ONE TO DELETE?(0 to exit)");
										input = Integer.parseInt(inp.readLine());
										if(input == 0) continue;
										f.getCourses().remove(input-1);
									}
									else if(input == 3) {
										cnt = 1;
										if(f.getCourses().isEmpty()) {
											System.out.println("NO COURSES");
											continue;
										}
										for(Course c : f.getCourses()) {
											System.out.println(cnt + ". " + c);
											cnt += 1;
										}
										System.out.println("WHICH ONE?(0 to exit)");
										input = Integer.parseInt(inp.readLine());
										if(input == 0) continue;
										System.out.println(f.getCourses().get(input -1)); 
									}
									else if(input == 4) {
										cnt = 1;
										if(f.getCourses().isEmpty()) {
											System.out.println("NO COURSES");
											continue;
										}
										System.out.println("1.assign teacher || 2.manage lessons");
										input = Integer.parseInt(inp.readLine());
										if(input == 1) {
											for(Course c : f.getCourses()) {
												System.out.println(cnt + ". " + c);
												cnt += 1;
											}
											System.out.println("WHERE TO ADD TEACHER?(0 to exit)");
											input = Integer.parseInt(inp.readLine());
											if(input == 0) continue;
											Vector<Teacher> tl = data.getUserList().stream().filter(u -> u instanceof Teacher).map(u -> (Teacher)u).collect(Collectors.toCollection(Vector::new));
											cnt = 1;
											if(tl.isEmpty()) {
												System.out.println("NO TEACHERS");
												continue;
											}
											for(Teacher t: tl) {
												System.out.println(cnt + ". " + t);
												cnt += 1;
											}
											Course c = f.getCourses().get(input-1);
											System.out.println("WHAT TEACHER TO ADD TO " + c.getName()+ "?(0 to exit)");
											input = Integer.parseInt(inp.readLine());
											if(input == 0) continue;
											tl.get(input-1).addCourseToTeach(c);
										}
										else if(input == 2) {
											for(Course c : f.getCourses()) {
												System.out.println(cnt + ". " + c);
												cnt += 1;
											}
											System.out.print("WHAT COURSE?");
											input = Integer.parseInt(inp.readLine());
											Course c = f.getCourses().get(input-1);
											System.out.println("1.view lessons || 2.add lesson || 3.delete lesson");
											input = Integer.parseInt(inp.readLine());
											if(input == 1) {
												cnt = 1;
												for(Lesson l : c.getScheduledLessons()) {
													System.out.println(cnt + ". " + l);
													cnt += 1;
												}
											}
											else if(input ==2) {
												c.addLesson(new Lesson(LessonType.LECTURE, new Time(10,0,DayType.MONDAY), 50, new Room()));
												System.out.println("Not implemented yet");
											}
											else if(input == 3) {
												cnt = 1;
												for(Lesson l : c.getScheduledLessons()) {
													System.out.println(cnt + ". " + l);
													cnt += 1;
												}
												System.out.println("WHICH ONE TO DELETE?");
												input = Integer.parseInt(inp.readLine());
												c.removeLesson(c.getScheduledLessons().get(input-1));
											}
										}
									}
								}
								else {
									System.out.println("STILL IN PROCESS");
								}
							}
							catch(Exception e) {
								System.out.println("!OUT OF RANGE!");
								e.printStackTrace();
							}
						}
						catch(Exception e) {
							System.out.println("!WRONG FORMAT!");
						}
    				}
    				else if(input == 2) {
    					System.out.print("Enter name(short, ex: 'FIT'): ");
    					String name = inp.readLine();
    					System.out.print("Enter description ");
    					String description = this.enterLongText();
    					Faculty newF = new Faculty(name, description);
    					createCourse(newF);
    					data.addFaculty(newF);
    					
    				}
    				else if(input == 3) {
    					Vector<Faculty> fl = data.getFaculties();
	    				System.out.println("―".repeat(70)); int cnt = 1;
						for(Faculty f : fl) {
							System.out.print(cnt + ". ");
							System.out.println(f);
							System.out.println("―".repeat(70));
							cnt += 1;
						}
						Admin adm = (Admin) UniSystem.getUser();
						while(true) {
    						System.out.print("WHICH ONE TO DELETE?: (0 to exit)");
    						try {
    							int num = Integer.parseInt(inp.readLine());
    							if(num == 0) {
    								break;
    							}
    							try {
									adm.deleteFaculty(fl.get(num-1));
									break;
    							}
    							catch(Exception e) {
    								e.printStackTrace();
    								System.out.println("!OUT OF RANGE!");
    							}
    						}
    						catch(Exception e){
    							System.out.println("!NOT A NUMBER!");
    						}
    					}
    				}
    			}
    			catch(Exception e) {
    					
    			}
    		}
    		else if(input == 3) {
    			System.out.println("1.view all || 2.add new || 3.delete");
    			try {
    				input = Integer.parseInt(inp.readLine());
    				if(input == 1) {
    					this.viewNews();
    				}
    				else if(input == 2) {
    					System.out.print("Enter title: ");
    					String title = inp.readLine();
    					System.out.print("Enter text: ");
    					String text = this.enterLongText();
    					News news = new News(title, text);
    					data.addNews(news);
    				}
    				else if(input == 3) {
    					System.out.println("Not implemented yet");
    				}
    			}
    			catch(Exception e) {
    				System.out.println("!WRONG FORMAT!");
    			}
    		}
    		else if(input == 4) {
    			System.out.println("1.view all || 2.send new");
    			input = Integer.parseInt(inp.readLine());
    			if(input == 1) {
    				this.viewMessages();
    			}
    			else if(input == 2) {
    				this.sendMessage();
    			}
    		}
    		else if(input == 5) {
    			System.out.println("|| USERS WITH SCHEDULE ||");
    			Vector<User> users = data.getUserList().stream().filter(u -> (u instanceof Student || u instanceof Teacher)).collect(Collectors.toCollection(Vector:: new));int cnt = 1;
    			System.out.println("―".repeat(70));
    			for(User u : users) {
    				System.out.println(cnt + ". " + u.simpleToString());
    				cnt += 1;
    				System.out.println("―".repeat(70));
    			}
    			System.out.println("CHOOSE USER:");
    			int us = Integer.parseInt(inp.readLine());
    			try {
    				User u = users.get(us-1);
    				System.out.println("1.get current schedule || 2.add lesson || 3.remove lesson");
    				input = Integer.parseInt(inp.readLine());
    				if(input == 1) {
    					if(u instanceof Student) {
    						System.out.println(((Student)u).getSchedule());
        				}
        				else if(u instanceof Teacher) {
        					System.out.println(((Teacher)u).getSchedule());
        				}
    				}
    				else if(input == 2) {
    					Vector<Course> courses = new Vector<Course>();
    					if(u instanceof Student) {
    						courses = ((Student)u).getTranscript().getCurCourses().keySet().stream().collect(Collectors.toCollection(Vector::new));
        				}
        				else if(u instanceof Teacher) {
        					courses = ((Teacher)u).getCoursesToTeach();
        				}
    					System.out.println("CHOOSE COURSE:");
    					System.out.println("―".repeat(70)); cnt = 1;
    					for(Course c: courses) {
    						System.out.println(cnt + ". " + c);
    						System.out.println("―".repeat(70));
    					}
    					input = Integer.parseInt(inp.readLine());
    					Course course = courses.get(input -1);
    					System.out.println("CHOOSE LESSON:");
    					Vector<Lesson> lessons = course.getScheduledLessons();
    					System.out.println("―".repeat(70)); cnt = 1;
    					for(Lesson l : lessons) {
    						System.out.println(cnt + ". " + l);
    						System.out.println("―".repeat(70));
    					}
    					input = Integer.parseInt(inp.readLine());
    					if(u instanceof Student) {
    						((Student)u).getSchedule().addLesson(lessons.get(input-1));
        				}
        				else if(u instanceof Teacher) {
        					((Teacher)u).getSchedule().addLesson(lessons.get(input-1));
        				}
    				}
    			}
    			catch(Exception e) {
    				System.out.println("!OUT OF RANGE!");
    				e.printStackTrace();
    			}
    			
    		}
    		else if(input == 6) {
    			System.out.println("Logging out...");
    			break;
    		}
    		else {
    			System.out.println("WHY( you!!!");
    		}
    	}
    } 
}
