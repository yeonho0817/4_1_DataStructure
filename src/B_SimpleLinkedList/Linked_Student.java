package B_SimpleLinkedList;



public class Linked_Student {
	private String studentID;
	private String studentName;
	private Linked_StudentClubList<Linked_StudentClub> studentClub;
	
	public Linked_Student(String studentID, String studentName, Linked_StudentClubList<Linked_StudentClub> club)
	{
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentClub = club;
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
	public void setStudentClub(Linked_StudentClub club)
	{
		studentClub.add(club);
	}
	public String getStudentClub()
	{
		return studentClub.toString();
	}
}
