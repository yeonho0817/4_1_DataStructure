package B_SimpleLinkedList;

import java.io.*;
import java.util.Scanner;

public class Linked_StudentListTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		if (args.length != 0)
		{
			Linked_StudentList<Linked_Student> student = new Linked_StudentList<>();
			
			readStudent(student, args[0]);
			
			System.out.println(args[0].toString() + "\n" + 
					"===========================================\n" +
					"(1) 새 학생 입력\n(2) 학생 삭제\n(3) 학번 순으로 전체 출력\n(4) 파일에 저장하고 종료\n" +
					"===========================================\n");
			while (true)
			{
				System.out.print("원하는 기능을 선택하세요 : ");
				int select = scanner.nextInt();
				scanner.nextLine();
				if (select == 1)
				{
					System.out.print("학번과 이름, 동아리들을 입력하세요 : ");
					String newest = scanner.nextLine();
					
					addStudent(student, newest);
				} else if (select == 2)		// 삭제
				{
					System.out.print("학번을 입력하세요 :");
					String studentID = scanner.nextLine();

					student.deleteNode(studentID);
				} else if (select == 3)		// 출력
				{
					System.out.println(student.toString());;
				} else if (select == 4) 		// 4 저장 및 종료
				{
					writeStudent(student, args[0]);
					break;
				} else
				{
					System.out.println("잘못입력했습니다.");
				}
			} 
		}
	}
	
	private static void addStudent(Linked_StudentList<Linked_Student> student, String line)
	{
		String[] splitStudent = line.split(" ", 3);
		String[] splitClub = null;
		
		Linked_StudentClubList<Linked_StudentClub> club = new Linked_StudentClubList<>();
		
		if (splitStudent.length != 2)	// 동아리가 없는 것
		{
			splitClub = splitStudent[2].split("/");
			
			for (int i=0; i<splitClub.length; i++)
			{
				club.add(new Linked_StudentClub(splitClub[i]));
			}
		}
		
		student.addNode(new Linked_Student(splitStudent[0], splitStudent[1], club));
	}
	
	private static void readStudent(Linked_StudentList<Linked_Student> student, String fileName)
	{
//		File file = new File("C:\\Users\\82102\\eclipse-workspace\\4_1 DataStructure\\src\\HW_210404\\11.txt");
		File file = new File(fileName);
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line = "";
			while ((line = br.readLine()) != null)
			{
				addStudent(student, line);
			}
			
			br.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private static void writeStudent(Linked_StudentList<Linked_Student> student, String fileName)
	{
		//File file = new File("C:\\Users\\82102\\eclipse-workspace\\4_1 DataStructure\\src\\HW_210404\\11.txt");
		File file = new File(fileName);
		try
		{
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			
			String str = student.toString();
			
			bw.write(str);
			
			bw.flush();
			bw.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
