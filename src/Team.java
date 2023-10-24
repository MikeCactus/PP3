
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class Team {
	public Droid[] team;
	public Droid[] opponents;
	
	public Team(int num, int option, Scanner input,PrintStream out) throws IOException {
		this.team = this.create_team(num,option, input, out);
	}
	
	
	
	public Droid[] create_team(int num, int option, Scanner input, PrintStream out) throws IOException {
		Droid[] arr = new Droid[option];
		int[] set = new int[option];
			do {
			System.out.printf("\nВиберіть набір дроїдів(без повторів) у команду номер %d: 1-common, 2 - tank, 3 - giant, 4 - medic,наприклад 1 2 3, але щоб цифри не повторювалися: \n Кількість дроідів має дорівнювати %d: ",num,option);
			for(int j = 0; j < option; j++) {
				set[j] = input.nextInt();
				if(out!=null) out.printf("%d ", set[j]);
				}
			if(!check_unique_droid(set))
				System.out.printf("\nПрисутні повтори! Спробуйте ще\n");
			}while(!check_unique_droid(set));
			
		for(int i = 0; i < option; i++) {
		switch (set[i]) {
		case 1:
			arr[i] = new Droid();
			break;
		case 2:
			arr[i] = new Droid_tank();
			break;
		case 3:
			arr[i] = new Droid_giant();
			break;
		case 4:
			arr[i] = new Droid_medic(arr);
			break;
		}
		}
		return arr;
	}
	
	
	
	boolean check_unique_droid(int[] set) {
		for (int i = 0; i < set.length; i++) {
			for(int j = i+1; j<set.length;j++) {
				if (set[i] == set[j])
					return false;
			}
		}
		return true;
	}
	
	public boolean can_continue() {
		boolean check = false;
		for(int i = 0; i < team.length; i++) {
			if(this.team[i].is_alive())
				check = true;
			}
		return check;	
	}
	
	public void add_opponents(Droid[] opponents) {
		this.opponents = opponents;
	}
	
	public void attack(Scanner input,PrintStream out) throws IOException {
		int option1 = 0;
		int option2 = 0;
		if(!this.can_attack()) {
			System.out.printf("\nЦя команда не може атакувати в цьому раунді\n ");
			return;
		}
		do {
		System.out.printf("\nВиберіть свого дроїда для атаки(хто атакує)(цифру): ");
		option1 = input.nextInt();
		if(out!=null)
			out.printf("%d ", option1);
		if(!this.can_attack())
			System.out.printf("\nЦей дроїд не може атакувати зараз. Спробуйте ще\n");
		}while(!team[option1-1].can_attack());
		do{
			System.out.printf("\nВиберіть чужого дроїда для атаки(кого атакують)(цифру): ");
		option2 = input.nextInt();
		if(out!=null)
			out.printf("%d ", option2);
		if(!this.opponents[option2-1].is_alive())
			System.out.printf("\nЦей дроїд вже мертвий, виберіть іншого\n ");
		}while(!this.opponents[option2-1].is_alive());
		
		team[option1-1].attack(this.opponents[option2-1],input,out);
		}
	
	public boolean can_attack() {
		for(int i = 0; i < this.team.length; i++) {
			if(this.team[i].can_attack())
				return true;
		}
		return false;
	}
	public void increase_cycle() {
		for(int i = 0; i < this.team.length; i++)
			this.team[i].increase_cycle();
	}
}
