import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Droid {
	protected int cycle = 0;
	protected String name;
	protected int health;
	protected int damage;
	protected int ulta;
	
	public Droid() {
	this.name = "Droid";
	this.health = 10;
	this.damage = 2;
	this.ulta = 0;
	this.cycle = 1;
	}
	
	//get##################
	
	
	public int get_health() {
		return this.health;
	}
	
	public int get_damage() {
		return this.damage;
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
			return this.get_damage()+1;
			}
		}
		this.set_ulta(get_ulta()+1);
		return this.get_damage();
	}
	
	public int get_ulta() {
		return this.ulta;
	}
	
	//set###################
	
	protected void set_health(int health) {
		this.health = health;
	}
	
	protected void set_ulta(int ulta) {
		if(ulta<=10&&this.ulta<=10)
		this.ulta = ulta;
	}
	
	//functions#############
	
	protected void get_attacked(int damage) {
		this.set_health(this.get_health()-damage);
	}
	
	public void attack(Droid enemy, Scanner input,PrintStream out) throws IOException {
		enemy.get_attacked(this.get_attack_damage(input,out));
	}
		
	
	public boolean is_alive() {
		return this.health > 0;
	}
	
	protected boolean has_ulta() {
		return this.get_ulta()>=10;
	}
	
	public String toString() {
		return "[Common] Health: "+health+" Ulta: "+ulta+ " Damage: "+damage;
	}
	public String get_name() {
		return this.name;
	}
	protected int get_cycle() {
		return this.cycle;
	}
	public void increase_cycle() {
		this.cycle++;
	}
	
	public boolean can_attack() {
		return this.cycle>=1;
	}
	
	public void reset_cycle() {
		this.cycle = 0;
	}
}

