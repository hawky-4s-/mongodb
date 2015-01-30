package hello;

import com.mongodb.MongoClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Update.*;

@EnableAutoConfiguration
public class Application implements CommandLineRunner {

	public static final String DATABASE = "mydatabase";
	//	@Autowired
	private MongoOperations mongoOps;
//	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient("camunda-ci0"), DATABASE));

		mongoOps.dropCollection(Customer.class);

		mongoOps.insert(new Customer("Alice", "Smith"));
		mongoOps.insert(new Customer("Bob", "Smith"));

		for (Customer customer : mongoOps.findAll(Customer.class)) {
			System.out.println(customer);
		}

		mongoOps.updateFirst(query(where("firstName").is("Alice")), update("age", 33), Customer.class);

		Customer customer = mongoOps.findOne(query(where("age").is(33)), Customer.class);
		System.out.println(customer);

	}

}
