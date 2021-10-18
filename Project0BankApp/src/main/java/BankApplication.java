import java.util.Scanner;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoDB;
import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoDB;
import com.example.models.Admin;
import com.example.models.Customer;
import com.example.models.Employee;
import com.example.models.Users;
import com.example.services.CustomerService;
import com.example.services.EmployeeService;

public class BankApplication {

	private static CustomerDao cDao = new CustomerDaoDB();
	private static CustomerService cServ = new CustomerService(cDao);
	private static EmployeeDao eDao = new EmployeeDaoDB();
	private static EmployeeService eServ = new EmployeeService(eDao);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		// This will be used to control our loop
		boolean done = false;

		Customer c = null;
		Employee e=null;
		Admin a=null;

		while (!done) {
			if (u == null) {
				System.out.println("currunt user? press 1 for login or new user? press 2 for sign up");
				int choice = Integer.parseInt(in.nextLine());
				if (choice == 1) {
					System.out.print("Please enter your username(email): ");
					String username = in.nextLine();
					System.out.print("Please enter you password: ");
					String password = in.nextLine();

					System.out.println("customer? press 1.. employee? press 2.. Admin? press 3");
					int choice1 = Integer.parseInt(in.nextLine());

					switch (choice) {
					case 1:
						try {
							u = cServ.signIn(email, password);
							System.out.println("Welcome " + u.getEmail());
							// u = pServ.loadUserPosts(u);
						} catch (Exception e) {
							System.out.println(
									"Username or password was incorrect, guess wrong again and you get pushed into the pit of misery");
						}
						break;

					case 2:
						try {
							u = eServ.signIn(username, password);
							System.out.println("Welcome " + u.getEmail());
							// u = pServ.loadUserPosts(u);
						} catch (Exception e) {
							System.out.println(
									"Username or password was incorrect, guess wrong again and you get pushed into the pit of misery");
						}
					case 3:
						try {
							u = uServ.signIn(username, password);
							System.out.println("Welcome " + u.getEmail());
							//u = pServ.loadUserPosts(u);
						} catch (Exception e) {
							System.out.println(
									"Username or password was incorrect, guess wrong again and you get pushed into the pit of misery");
						}
					default:
						System.out.println("customer? press 1.. employee? press 2.. Admin? press 3");
					}

				}
			}
		}
	}

}
