
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Droid_tank extends Droid{
	public Droid_tank() {
		this.name = "Droid_tank";
		this.health = 20;
		this.damage = 1;
		this.ulta = 0;

		}
	
	public String toString() {
		return "[Tank] Health: "+health+ " Ulta: "+ulta+" Damage: "+damage;
	}
	
	protected void get_attacked(int damage) {
		this.set_health(this.get_health()-damage);
		this.set_ulta(this.get_ulta()+1);//отримує плюс до ульти від прийнятти удару
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
			return this.get_damage()*10;
			}
		}
		this.set_ulta(get_ulta()+1);
		return this.get_damage();
	}
}
