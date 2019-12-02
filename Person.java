package Uppgift5;

import java.util.ArrayList;

public class Person {
	
	private String pNbr;
	private String name;
	private ArrayList<Account> bankaccounts = new ArrayList<Account>();
	
		public void addAccount(Account a) {
			bankaccounts.add(a);
		}
		public String getpNbr() {
			return pNbr;
		}
		public void setpNbr(String pNbr) {
			this.pNbr = pNbr;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public ArrayList<Account> getBankaccounts(){
			return bankaccounts;
		}
		public void setBankaccounts(ArrayList<Account> bankaccounts){
			this.bankaccounts = bankaccounts;
		}
}
