package mini_project;

import java.util.List;
import java.util.Scanner;

public class TestAccount {

	public static void main(String[] args) {

		System.out.println("--------Menu-----------");
		System.out.println("\n1:Create account \n2:Show all accounts \n3:Withdraw \n4:Deposit \n5:Search email");

		Scanner sc = new Scanner(System.in);
		int ch;

		try {
			List<Account> myAccounts=AccountService.getAllDetails();

			do {

				System.out.println("\nEnter your choice");
				ch = sc.nextInt();

				switch (ch) {
				case 1:
					System.out.println("Enter holder name, email, age, phone number and balance");
					AccountService.createAccount(sc.next(), sc.next(), sc.nextInt(), sc.nextLong(), sc.nextDouble());
					break;
					
				case 2:
					if(myAccounts.isEmpty())
						System.out.println("No customers added yet");
					else {
						for(Account ac:myAccounts) {
							System.out.println(ac);
						}
					}
					break;
					
				case 3:
					System.out.println("Enter account number and amount to withdraw");
					int num=sc.nextInt();
					double amt=sc.nextDouble();
					for(Account ac:myAccounts) {
						if(ac.acc_no==num) {
							if(ac.balance>amt) {
								ac.balance=ac.balance-amt;
								System.out.println("Account withdrawn successfully");
							}
							else{
								System.out.println("Insufficient balance");
							}
						}
						else
							System.out.println("No such account exists");
					}
					break;
					
				case 4:
					System.out.println("Enter account number and amount to deposit");
					int num1=sc.nextInt();
					double amt1=sc.nextDouble();
					for(Account ac:myAccounts) {
						if(ac.acc_no==num1) {
							ac.balance=ac.balance+amt1;
							System.out.println("Account deposited successfully");
						}
						else
							System.out.println("No such account exists");
					}
					break;
					
				case 5:
					System.out.println("Enter email id to search");
					String email=sc.next();
					for(Account ac:myAccounts) {
						if(email.equals(ac.email)) {
							System.out.println(ac);
						}
						else
							System.out.println("Customer not found");
					}
					break;
					
				default:
					System.out.println("--------Invalid choice---------");

				}
			} while (ch != 0);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
