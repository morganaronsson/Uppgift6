package Uppgift5;

	import java.awt.EventQueue;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
	import javax.swing.SwingConstants;

	import Uppgift5.Account;
	import Uppgift5.Person;
	import Uppgift5.Personregister;

	public class PersonApplication {

			private JFrame frame;
			private final ButtonGroup buttonGroup = new ButtonGroup();
			private JTextField textField;
			private JTextField textField_1;
			private JTextField textField_2;
			private JTextField txtBalance;
			
			private Controller controller;
			private Personregister personRegister;

			/**
			 * Launch the application.
			 */
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PersonApplication window = new PersonApplication();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			/**
			 * Create the application.
			 */
			public PersonApplication() {
				initialize();
			}
		///////
			/**
			 * Initialize the contents of the frame.
			 */
			private void initialize() {
				frame = new JFrame();
				frame.setBounds(700, 300, 400, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setColumns(2);
				textArea.setRows(10);
				textArea.setBounds(94, 276, 192, 136);
				frame.getContentPane().add(textArea);
				
				
			
				JButton btnAddPerson = new JButton("Add Person");
				btnAddPerson.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					String name = textField.getText();
					String id = textField_1.getText();
					controller.addPerson(id, name);
					txtBalance.setText("Person added");
					
					
					}
					
				});
				// Add Person
				
				
				JButton btnRemovePerson = new JButton("Remove Person");
				btnRemovePerson.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name = textField.getText();
						String id = textField_1.getText();
						Person tmp = personRegister.findPerson(id);
						
						if(tmp== null) {
							txtBalance.setText("Person doesn't exist");
						}
						else  {
						controller.removePerson(id);
						txtBalance.setText("Person removed");
						}
						
					}
				});
				//Remove Person

				
				
			
				JButton btnAddAccount = new JButton("Add Account");
				btnAddAccount.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name = textField.getText();
						String id = textField_1.getText();
						String nbr = textField_2.getText();
						
						Person tmp = controller.findPerson(id);
						
						if(tmp.getpNbr().equals(id) ) {
							Account account = new Account();
							account.setNbr(nbr);
							account.setBalance(0);
							
							tmp.addAccount(account);
							txtBalance.setText("Account added to " + tmp.getName() + " " + tmp.getpNbr());
						}
						else {
							txtBalance.setText("Person doesn't exist");
						}
						
						
					}
					
				});
				// Add Account
				
				
				
				
				JButton btnFindPerson = new JButton("Find Person");
				btnFindPerson.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name = textField.getText();
						String id = textField_1.getText();
						Person tmp =personRegister.findPerson(id);
						
						if(tmp != null) {
							txtBalance.setText("Person found");
							txtBalance.setText(tmp.getName() + " " + tmp.getpNbr());
						}
						else {
							txtBalance.setText("Person doesn't exist");
									
						}
						
					}
					
				}); // Find a Person
			
				JButton btnFindAllYourAccounts = new JButton("Find all your accounts");
				btnFindAllYourAccounts.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textArea.setText("");
						String name = textField.getText();
						String id = textField_1.getText();
						
						Person person = personRegister.findPerson(id);
						ArrayList<String> strings = new ArrayList<String>();
			
						if (person == null) {
							txtBalance.setText("Person doesn't exist");
						} else {
							String responseText = "\n"; 
							
							for(Account account: person.getBankaccounts()) {
								responseText = "\r\n" + account.getNbr() + "         " + account.getBalance() + " kr";
								textArea.append(responseText);
							}
							

						}
						
					}
				
					// Find all your accounts
				});
					
				btnAddPerson.setBounds(6, 99, 115, 29);
				buttonGroup.add( btnAddPerson);
				frame.getContentPane().add( btnAddPerson);
				
				
				btnRemovePerson.setBounds(243, 99, 139, 29);
				buttonGroup.add(btnRemovePerson);
				frame.getContentPane().add(btnRemovePerson);
				
				
				btnAddAccount.setBounds(100, 170, 125, 29);
				buttonGroup.add(btnAddAccount);
				frame.getContentPane().add(btnAddAccount);
			
				btnFindPerson.setBounds(125, 99, 117, 29);
				buttonGroup.add(btnFindPerson);
				frame.getContentPane().add(btnFindPerson);
				
				
				btnFindAllYourAccounts.setBounds(100, 211, 164, 29);
				buttonGroup.add(btnFindAllYourAccounts);
				frame.getContentPane().add(btnFindAllYourAccounts);
				
				// alla buttons, add till buttomgroup
				
				JLabel lblNewUser = new JLabel("New User:");
				lblNewUser.setBounds(5, 6, 92, 16);
				frame.getContentPane().add(lblNewUser);
				
				JLabel name = new JLabel("Name:");
				name.setBounds(16, 34, 61, 16);
				frame.getContentPane().add(name);
				
				JLabel id = new JLabel("ID nbr:");
				id.setBounds(16, 59, 61, 16);
				frame.getContentPane().add(id);
			
				
				JLabel balance = new JLabel("|    Balance");
				balance.setBounds(181, 258, 83, 16);
				frame.getContentPane().add(balance);
				
				JLabel AccountNbr = new JLabel("Account nbr");
				AccountNbr.setBounds(94, 258, 83, 16);
				frame.getContentPane().add(AccountNbr);
				
				// alla JLabel
				
				textField = new JTextField();
				textField.setBounds(100, 29, 120, 26);
				frame.getContentPane().add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setBounds(100, 64, 120, 26);
				frame.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setBounds(100, 135, 120, 26);
				frame.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				// Textfield
				
				txtBalance = new JTextField();
				txtBalance.setEditable(false);
				txtBalance.setHorizontalAlignment(SwingConstants.LEFT);
				txtBalance.setBounds(63, 424, 331, 32);
				frame.getContentPane().add(txtBalance);
				txtBalance.setColumns(100);
				
				JLabel lblPerson = new JLabel("Person:");
				lblPerson.setBounds(16, 432, 61, 16);
				frame.getContentPane().add(lblPerson);
				
				JLabel lblAccount = new JLabel("Account:");
				lblAccount.setBounds(36, 140, 61, 16);
				frame.getContentPane().add(lblAccount);
				
				// txtBalance
				
				personRegister = new Personregister();
				controller = new Controller(personRegister, frame);
				
			}
		}
