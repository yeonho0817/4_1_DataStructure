package B_CircularLinkedList;

import java.io.*;
import java.util.Scanner;

public class Circular_StudentListTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		if (args.length != 0)
		{
			File file = new File(args[0]);
			Circular_StudentList<Circular_Student> student = new Circular_StudentList<>();
			try
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				String line = "";
				while ((line = br.readLine()) != null)
				{
					inputStudent(student, line);
				}
				
				br.close();
//				System.out.println(student.toString());
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			
			System.out.println(file.toString() + "\n" + 
					"===========================================\n" +
					"(1) 새 학생 입력\n(2) 학생 삭제\n(3) 학번 순으로 전체 출력\n"
					+ "(4) 학번 역순으로 전체 출력\n(5) 특정 학번부터 전체 출력\n(6) 파일에 저장하고 종료\n" +
					"===========================================\n");
			while (true)
			{
				System.out.print("원하는 기능을 선택하세요 : ");
				int select = scanner.nextInt();
				scanner.nextLine();
				if (select == 1)
				{
					System.out.print("학번과 이름을 입력하세요 : ");
					String newest = scanner.nextLine();
					
					inputStudent(student, newest);
				} else if (select == 2)		// 삭제
				{
					System.out.print("학번을 입력하세요 :");
					String studentID = scanner.nextLine();

					student.deleteNode(studentID);
				} else if (select == 3)		// 학번 순
				{
					System.out.println(student.toString());;
				} else if (select == 4) 		// 학번 역순
				{
					System.out.println(student.printReverse());
				} else if (select == 5)			// 특정 학번 순
				{
					System.out.print("학번을 입력하세요 :");
					String studentID = scanner.nextLine();
					
					System.out.println(student.printSpecific(studentID));
				} else if (select == 6)			// 파일에 저장 후 종료
				{
					outputStudent(student, args[0]);
					break;
				} else
				{
					System.out.println("잘못입력했습니다.");
				}
			} 
		}
	}
	
	private static void inputStudent(Circular_StudentList<Circular_Student> student, String line)
	{
		String[] splitStudent = line.split(" ");
		
		
		student.addNode(new Circular_Student(splitStudent[0], splitStudent[1]));
	}
	
	private static void outputStudent(Circular_StudentList<Circular_Student> student, String args)
	{
		File file = new File(args);
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
