package cse.web.bean;

public class Courses {
	
	private String course_id;
	private String course_name;
	private String course_teacher;
	
	
	
	public Courses(String course_id, String course_name, String course_teacher) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_teacher = course_teacher;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_teacher() {
		return course_teacher;
	}
	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}
	
	

}
