import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Menu {
	public Menu() throws IOException, InterruptedException{

	Scanner input = new Scanner(System.in);
	System.out.println("<<Битва дроїдів>>");
	System.out.println("Виберіть:провести просто бій в консолі(1), записати бій у файл(2), відтворити бій з файлу(3)\n");
	int choice1 = input.nextInt();
	int choice2 = 0;
	
	
	switch (choice1) {
	case 2:
		System.out.println("Виберіть режим гри. 1-один на один, 2 - команда на команду(3 на 3)");
		choice2 = input.nextInt();
		File f = new File("battle.txt");
	    PrintStream out = new PrintStream(f);
	    out.printf("%d ",choice2);
		if(choice2 == 2) {
		Battle battle = new Battle(3,input,out);}
		else {
			Battle battle = new Battle(1,input,out);}
		out.close();
		break;
	case 1:
		System.out.println("Виберіть режим гри. 1-один на один, 2 - команда на команду(3 на 3)");
		choice2 = input.nextInt();
		if(choice2 == 2) {
			Battle battle = new Battle(3,input,null);}
			else {
				Battle battle = new Battle(1,input,null);}
		break;
	case 3:
		File file = new File("battle.txt");
		Scanner in = new Scanner(file);
		System.out.println("Виберіть режим гри. 1-один на один, 2 - команда на команду(3 на 3)");
		choice2 = in.nextInt();
		if(choice2 == 2) {
			Battle battle = new Battle(3,in,System.out);}
			else {
				Battle battle = new Battle(1,in,System.out);}
		break;
	}		
	}
}
	