package mini_project;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
	
	private static int acc_no=1;
	static List<Account> accounts=new ArrayList<>();
	
	private static void validateAge(int age) throws AccountException {
		if (age < 18) {

			throw new AccountException("--------age is invalid---------");
		}
	}

	private static void validateEmail(String email) throws AccountException{
		String emailRegEx = "^[a-z][a-z0-9._-]*@[a-z]+\\.(com|org|net)$";
    	
    	if(!email.matches(emailRegEx)) {
    		throw new AccountException("---------email is invalid--------");
    	}
	}
	
	private static void uniqueEmail(String email) throws AccountException{
		for(Account ac1:accounts) {
			if(email.equals(ac1.email)) {
				throw new AccountException("------User with email already exists-------");
			}
		}
	}
	
	private static void validatePhno(long phno) throws AccountException {
		if(phno<0) {
			throw new AccountException("----- Contact number is invalid ------");
		}
	}
	
	public static void createAccount(String holder_name, String email, int age, long phno, Double balance) throws AccountException {
		
		validateAge(age);
		validateEmail(email);
		uniqueEmail(email);
		validatePhno(phno);
		
		Account acc=new Account(acc_no,holder_name, email, age, phno, balance);
		accounts.add(acc);
		acc_no++;
		
		System.out.println("-----Account created successfully-----");
	}
	
	public static List<Account> getAllDetails() {
		return accounts;
	}

}
