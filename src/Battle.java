
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class Battle {
	private Team team1;
	private Team team2;
	
	public Battle(int option,Scanner input,PrintStream out) throws IOException {
		
		this.team1 = new Team(1,option, input,out);
		this.team2 = new Team(2,option,input,out);
		this.team1.add_opponents(this.team2.team);
		this.team2.add_opponents(this.team1.team);
		
	while(true) {
		this.team1.increase_cycle();
		this.team2.increase_cycle();
		if(this.team1.can_continue() && this.team2.can_continue()) {
			print_teams();
			if(!this.team1.can_continue()){
				System.out.printf("!!!Команда номер 2 перемогла!!!");
				break;
			}
			System.out.printf("Атакує команда номер 1");
			
			this.team1.attack(input, out);
			print_teams();
			if(!this.team2.can_continue()){
				System.out.printf("!!!Команда номер 1 перемогла!!!");
				break;
			}
			System.out.printf("Атакує команда номер 2");
			this.team2.attack(input,out);
			if(!this.team1.can_continue()){
				System.out.printf("!!!Команда номер 2 перемогла!!!");
				break;
			}
		}
	}
	}
	
	public void print_teams() {
		System.out.printf("\nКоманда 1\t\t\t\t\tМоже атакувати\t\t\t\t\t\tКоманда 2	\t\t\t\t\tМоже атакувати\n");
		for(int i = 0; i < this.team1.team.length; i++) {
			System.out.printf("%d) ",i+1);
			if(this.team1.team[i].is_alive()) {
			System.out.print(this.team1.team[i]);
			if(this.team1.team[i].can_attack())
				System.out.print("\t\t\t\tТак");
			else
				System.out.print("\t\t\t\tНі");
			}
			else
				System.out.print("dead\t\t\t\t\t\t");
			System.out.print("					");
			if(this.team2.team[i].is_alive()) {
			System.out.print(team2.team[i]);
			if(this.team2.team[i].can_attack())
				System.out.print("\t\t\t\t\tТак");
			else
				System.out.print("\t\t\t\t\tНі");}
			else
				System.out.print("dead\t\t\t\t\t\t");
			System.out.print("\n");
		}
	}
	
}