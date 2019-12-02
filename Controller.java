package Uppgift5;

import javax.swing.JFrame;

public class Controller {
	
	Personregister persons;
	JFrame personFrame;
	Person person; 
	Account account;
	
	public Controller(Personregister personreg, JFrame personFrame) {
		this.persons = personreg;
		this.personFrame = personFrame;
		
	}
	
	public void addPerson(String pNbr, String name) {
		Person p = new Person();
		p.setpNbr(pNbr);
		p.setName(name);
		persons.addPerson(p);
		
	}
	
	public void addPerson(String pNbr, String name, String nbr, double balance) {
		Person tmpPerson = new Person();
		tmpPerson.setpNbr(pNbr);
		tmpPerson.setName(name);
		Account account = new Account();
		account.setNbr(nbr);
		account.setBalance(balance);
		
		tmpPerson.addAccount(account);
		account.setPerson(tmpPerson);
		persons.addPerson(tmpPerson);
		
	}
	
	public void removePerson(String pNbrRemove) {
		persons.removePerson(pNbrRemove);
		
	}
	public Person findPerson (String pNbr) {
		Person tmp = persons.findPerson(pNbr);
		if(tmp.getpNbr().equals(pNbr)) {
			return tmp;
		}
	
	 return null;
	}

		public void addAccount(Account a, Person p) {
			p.addAccount(a);
			a.setPerson(p);
		}
}
