package E_SortAlgorithm;

public class Operation {
	
	public void sort(Sort sort)
	{
		System.out.println("-------------------- " + sort.toString() + " --------------------");
		
		for (int i=0; i<5; i++)
		{
			System.out.println("\n---------- " + 10000*(i+1) + "짜리 배열");
			CreateInput createInput = new CreateInput(10000*(i+1));
			
			createInput.createRandom();
			System.out.println("----- Random");
			
			sort.sort(createInput.intInput);
			System.out.println("- Integer 정렬 시간 : " + sort.getTime());
			
			sort.sort(createInput.doubleInput);
			System.out.println("- Double 정렬 시간 : " + sort.getTime());
			
			sort.sort(createInput.stringInput);
			System.out.println("- String 정렬 시간 : " + sort.getTime());
			
			sort.sort(createInput.studentInput);
			System.out.println("- Student 정렬 시간 : " + sort.getTime());
			
//			createInput.createIncrease();
			// random 으로 정렬한 걸 그대로 정렬 (오름차순)
			System.out.println("\n----- Increase");
			
			sort.sort(createInput.intInput);
			System.out.println("- Integer 정렬 시간 : " + sort.getTime());
			
			sort.sort(createInput.doubleInput);
			System.out.println("- Double 정렬 시간 : " + sort.getTime());
			
			sort.sort(createInput.stringInput);
			System.out.println("- String 정렬 시간 : " + sort.getTime());
			
			sort.sort(createInput.studentInput);
			System.out.println("- Student 정렬 시간 : " + sort.getTime());
			
			
			
			System.out.println("\n----- Decrease");
			createInput.createDecrease();
			
			sort.sort(createInput.intInput);
			System.out.println("- Integer 정렬 시간 : " + sort.getTime());
			
			sort.sort(createInput.doubleInput);
			System.out.println("- Double 정렬 시간 : " + sort.getTime());
			
			sort.sort(createInput.stringInput);
			System.out.println("- String 정렬 시간 : " + sort.getTime());
			
			sort.sort(createInput.studentInput);
			System.out.println("- Student 정렬 시간 : " + sort.getTime());
			
			/*
			 * // 값 확인할 때 
			 * System.out.println("----- Random");
			 * System.out.println("-- int\n정렬 전 : " +
			 * createInput.toString(createInput.intInput)); sort.sort(createInput.intInput);
			 * System.out.println("정렬 후 : " + createInput.toString(createInput.intInput));
			 * System.out.println("- Integer 정렬 시간 : " + sort.getTime());
			 * 
			 * System.out.println("정렬 후 : " +
			 * createInput.toString(createInput.doubleInput));
			 * sort.sort(createInput.doubleInput); System.out.println("정렬 후: " +
			 * createInput.toString(createInput.doubleInput));
			 * System.out.println("- Double 정렬 시간 : " + sort.getTime());
			 * 
			 * System.out.println("-- String\n정렬 전 : " +
			 * createInput.toString(createInput.stringInput));
			 * sort.sort(createInput.stringInput); System.out.println("정렬 후 : " +
			 * createInput.toString(createInput.stringInput));
			 * System.out.println("- String 정렬 시간 : " + sort.getTime());
			 * 
			 * System.out.println("-- Student\n정렬 전 : " +
			 * createInput.toString(createInput.studentInput));
			 * sort.sort(createInput.studentInput); System.out.println("정렬 후 : " +
			 * createInput.toString(createInput.studentInput));
			 * System.out.println("- Student 정렬 시간 : " + sort.getTime());
			 * 
			 * // createInput.createIncrease(); // random 으로 정렬한 걸 그대로 정렬 (오름차순)
			 * System.out.println("\n----- Increase");
			 * 
			 * System.out.println("-- int\n정렬 전 : " +
			 * createInput.toString(createInput.intInput)); sort.sort(createInput.intInput);
			 * System.out.println("정렬 후 : " + createInput.toString(createInput.intInput));
			 * System.out.println("- Integer 정렬 시간 : " + sort.getTime());
			 * 
			 * System.out.println("-- double\n정렬 후 : " +
			 * createInput.toString(createInput.doubleInput));
			 * sort.sort(createInput.doubleInput); System.out.println("정렬 후: " +
			 * createInput.toString(createInput.doubleInput));
			 * System.out.println("- Double 정렬 시간 : " + sort.getTime());
			 * 
			 * System.out.println("-- String\n정렬 전 : " +
			 * createInput.toString(createInput.stringInput));
			 * sort.sort(createInput.stringInput); System.out.println("정렬 후 : " +
			 * createInput.toString(createInput.stringInput));
			 * System.out.println("- String 정렬 시간 : " + sort.getTime());
			 * 
			 * System.out.println("-- Student\n정렬 전 : " +
			 * createInput.toString(createInput.studentInput));
			 * sort.sort(createInput.studentInput); System.out.println("정렬 후 : " +
			 * createInput.toString(createInput.studentInput));
			 * System.out.println("- Student 정렬 시간 : " + sort.getTime());
			 * 
			 * 
			 * // random으로 정렬한 것을 반대로 배열에 넣음 System.out.println("\n----- Decrease");
			 * createInput.createDecrease(); System.out.println("-- int\n정렬 전 : " +
			 * createInput.toString(createInput.intInput)); sort.sort(createInput.intInput);
			 * System.out.println("정렬 후 : " + createInput.toString(createInput.intInput));
			 * System.out.println("- Integer 정렬 시간 : " + sort.getTime());
			 * 
			 * System.out.println("-- double\n정렬 wjs : " +
			 * createInput.toString(createInput.doubleInput));
			 * sort.sort(createInput.doubleInput); System.out.println("정렬 후: " +
			 * createInput.toString(createInput.doubleInput));
			 * System.out.println("- Double 정렬 시간 : " + sort.getTime());
			 * 
			 * System.out.println("-- String\n정렬 전 : " +
			 * createInput.toString(createInput.stringInput));
			 * sort.sort(createInput.stringInput); System.out.println("정렬 후 : " +
			 * createInput.toString(createInput.stringInput));
			 * System.out.println("- String 정렬 시간 : " + sort.getTime());
			 * 
			 * System.out.println("-- Student\n정렬 전 : " +
			 * createInput.toString(createInput.studentInput));
			 * sort.sort(createInput.studentInput); System.out.println("정렬 후 : " +
			 * createInput.toString(createInput.studentInput));
			 * System.out.println("- Student 정렬 시간 : " + sort.getTime());
			 */
			
		}
	}
}
