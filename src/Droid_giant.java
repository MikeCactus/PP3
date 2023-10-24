import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Droid_giant extends Droid_tank{

	public Droid_giant() {
		this.name = "Giant";
		this.health = 20;
		this.damage = 5;
		this.ulta = 0;//damage * 2
		this.cycle = 0;
		}

	public int get_attack_damage(Scanner input,PrintStream out) throws IOException {
		int choice = 0;
		this.reset_cycle();
		if(this.has_ulta()) {
			System.out.println("Атака: 1    Ульта:2   - ");
			choice = input.nextInt();
			if(out!=null)
				out.printf("%d ",choice);
			if(choice == 2) {
			this.set_ulta(0);
			return this.get_damage()*2;
			}
		}
		this.set_ulta(get_ulta()+1);
		return this.get_damage();
	}
	
	
	public boolean can_attack() {
		return this.cycle>=3;
	}
	public String toString() {
		return "[Giant] Health: "+health+" Ulta: "+ulta+" Damage: "+damage;
	}
}
