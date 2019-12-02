package Uppgift5;

public class Test {

	public static void main(String[] args) {
		Account b = new Account();
		Account b2 = new Account();
		b.setBalance(200000);
		b.setNbr("007070");
		b2.setBalance(500000);
		b2.setNbr("006060");
		
		Account ba = new Account();
		Account ba2 = new Account();
		ba.setBalance(200000);
		ba.setNbr("007070");
		ba2.setBalance(500000);
		ba2.setNbr("006060");
		
		Personregister reg = new Personregister();
		Person p = new Person();
		p.setName("Roger");
		p.setpNbr("9702043127");
		p.addAccount(b);
		p.addAccount(b2);
		reg.addPerson(p);
		
		Person p1 = new Person();
		p1.setName("Teddy");
		p1.setpNbr("9702040040");
		p1.addAccount(ba);
		p1.addAccount(ba2);
		reg.addPerson(p1);
		
		b.setPerson(p);
		b2.setPerson(p);
		ba.setPerson(p1);
		ba2.setPerson(p1);
		
		System.out.println("Användaren " + reg.removePerson(p1.getpNbr()).getName() + " är borttagen");
		System.out.println("Användaren " + reg.findPerson("9702040040"));
		System.out.println("Användaren " + reg.findPerson(p.getpNbr()).getName() + " har hittats");
		
		System.out.println("Din nuvarande saldo är: " + ba2.getBalance());
		ba2.credit(200.0);
		System.out.println("Ditt saldo efter intag på 200 SEK: " + ba2.getBalance());
		ba2.withdraw(400.0);
		System.out.println("Ditt saldo efter utag på 400 SEK: " + ba2.getBalance());
		
	}


	}
