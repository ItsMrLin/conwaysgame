import java.util.Random;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		int mapSize = 10;
		Map map;
		Random ran = new Random();
		String[] s = new String[mapSize];
		for (int i = 0; i<mapSize; i++){
			s[i] = "";
			for (int j=0; j<mapSize; j++)
				if (ran.nextDouble()<.4)
					s[i]+="*";
				else
					s[i]+="0";
		}
		map = new Map(s);
		Scanner reader = new Scanner(System.in);
		System.out.println(map);
		while (map.getSteps()<1000){
			reader.nextLine();
			System.out.println('\u000C');
			map.step();
			System.out.println(map);
		}
	}

}
