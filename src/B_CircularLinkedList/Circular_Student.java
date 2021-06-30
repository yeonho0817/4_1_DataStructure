package B_CircularLinkedList;

public class Circular_Student {
	private String studentID;
	private String studentName;
	
	public Circular_Student(String studentID, String studentName)
	{
		this.studentID = studentID;
		this.studentName = studentName;
	}
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
