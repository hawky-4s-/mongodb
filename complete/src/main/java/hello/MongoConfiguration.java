//package hello;
//
//import com.mongodb.Mongo;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.authentication.UserCredentials;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//
///**
// * Created by hawky4s on 30.01.15.
// */
//@Configuration
//public class MongoConfiguration {
//
//  public static final String DATABASE = "blub1";
//
//  public @Bean MongoDbFactory mongoDbFactory() throws Exception {
//      UserCredentials userCredentials = new UserCredentials("admin", "camunda");
//      return new SimpleMongoDbFactory(new Mongo("192.168.178.177", 27017), DATABASE, userCredentials);
//    }
//
//    public @Bean MongoTemplate mongoTemplate() throws Exception {
//      return new MongoTemplate(mongoDbFactory());
//    }
//
//}
