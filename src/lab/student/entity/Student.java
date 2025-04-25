package lab.student.entity;


public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student(String name, String major, int grade) {
		this.name = name;
		this.major = major;
		setGrade(grade);
	}
	
	
	
	public String getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if(grade > 4 || grade < 1) {
			System.out.println("학년은 1~4 사이여야합니다.");
		}
		this.grade = grade;
	}
	

}
