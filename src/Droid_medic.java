
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Droid_medic extends Droid  {
	private Droid[] team;
	public Droid_medic(Droid[]team) {
		this.name = "Medic";
		this.health = 6;
		this.damage = 2;
		this.ulta = 0;
		this.team = team;
		this.cycle = 0;
		}
	
	
	public int get_attack_damage(Scanner input,PrintStream out) throws IOException {
		int choice = 0;
		if(this.has_ulta()) {
			System.out.println("Атака: 1    Ульта:2   - ");
			choice = input.nextInt();
			if(out!=null)
				out.printf("%d ",choice);
			if(choice == 2) {
			this.set_ulta(0);
			this.heal(team);
			return 0;
			}
		}
		this.set_ulta(get_ulta()+5);
		return this.get_damage();
	}
	
	public void heal(Droid team[]) {
		for(int i = 0; i < team.length; i++)
			team[i].set_health(get_health()+3);
		;
	}
	public String toString() {
		return "[Medic] Health: "+this.get_health()+" Ulta: "+this.get_ulta()+" Damage: "+damage;
	}
}
