package test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.tutorial.spring.config.AppConfig;
import com.test.tutorial.spring.entity.User;
import com.test.tutorial.spring.service.UserService;

/**
 * @author feelcard
 *
 */
public class MainApp {
//	@Autowired
//	UserService userService;
	
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService userService = context.getBean(UserService.class);

		// Add Users
		userService.add(new User("Sunil", "Bora", "suni.bora@example.com","1234"));
		userService.add(new User("David", "Miller", "david.miller@example.com","1234"));
		userService.add(new User("Sameer", "Singh", "sameer.singh@example.com","1234"));
		userService.add(new User("Paul", "Smith", "paul.smith@example.com","1234"));

		// Get Users
		List<User> users = userService.listUsers();
		for (User user : users) {
			System.out.println("Id = " + user.getId());
			System.out.println("First Name = " + user.getFirstName());
			System.out.println("Last Name = " + user.getLastName());
			System.out.println("Email = " + user.getEmail());
			System.out.println();
		}

	

		
	}

//      AnnotationConfigApplicationContext context = 
//            new AnnotationConfigApplicationContext(AppConfig.class);
//
//      PersonService personService = context.getBean(PersonService.class);
//
//      // Add Persons
//      personService.add(new Person("Sunil", "Bora", "suni.bora@example.com"));
//      personService.add(new Person("David", "Miller", "david.miller@example.com"));
//      personService.add(new Person("Sameer", "Singh", "sameer.singh@example.com"));
//      personService.add(new Person("Paul", "Smith", "paul.smith@example.com"));
//
//      // Get Persons
//      List<Person> persons = personService.listPersons();
//      for (Person person : persons) {
//         System.out.println("Id = "+person.getId());
//         System.out.println("First Name = "+person.getFirstName());
//         System.out.println("Last Name = "+person.getLastName());
//         System.out.println("Email = "+person.getEmail());
//         System.out.println();
//      }

//      context.close();
//}
}