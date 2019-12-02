package Uppgift5;

public class Account {
	
	private String nbr;
	private double balance;
	private Person person;
	
	public String getNbr() {
		return nbr;
		}
	public void setNbr(String nbr) {
		this.nbr = nbr;
		}
	public double getBalance() {
		return balance;
		}
	public void setBalance(double balance) {
		this.balance = balance;
		}
	public void credit(double amount) {
		balance += amount;
		}
	public void withdraw(double amount) {
		balance -= amount;
		}
	public Person getPerson() {
		return person;
		}
	public void setPerson(Person person) {
		this.person = person;
		}

}
