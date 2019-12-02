package Uppgift5;

import java.util.ArrayList;

public class Personregister {
	
	private ArrayList<Person> personer = new ArrayList<Person>();
	
	public ArrayList<Person> getPersoner(){
		return personer;
	}
	
	public void setPersoner(ArrayList<Person> personer) {
		this.personer = personer;
	}
	
	public void addPerson(Person person) {
		personer.add(person);
	}
	public Person findPerson(String pNbr) {
		for(Person tmp: personer) {
			if(tmp.getpNbr().equals(pNbr)) {
				return tmp;
				}
			}
		return null;
		}
	public Person removePerson(String pNbr) {
		Person person = findPerson(pNbr);
		personer.remove(person);
		return person;
		}
}

