package com.javaexpress;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javaexpress.models.User;
import com.javaexpress.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception 
	{
		var context = SpringApplication.run(Application.class, args);
		var userRepository = context.getBean(UserRepository.class);
		
		//saveUserInfo(userRepository);
		
		//fetchAllRecords(userRepository);
		
		Optional<User> optional = findUserInfo(userRepository);
		
		//update the existing record in db
		//updateUserInfo(userRepository, optional);
		
		//deleteById(userRepository, optional);
		
		//saveAllUsers(userRepository);

		
		//recordCount(userRepository);
		
		//checkUserExist(userRepository);
		
		
	}



	private static void saveAllUsers(UserRepository userRepository) {
		User user = new User();

		user.setEmailId("Aadi@gmail.com");
		user.setUsername("Aadesh");
		user.setPhone("96643684845");
		user.setPassword("12345677");

		User user1 = new User();

		user1.setEmailId("Mahi@gmail.com");
		user1.setUsername("Mahesh");
		user1.setPhone("96643684845");
		user1.setPassword("12345676");
		
		User user2 = new User();

		user2.setEmailId("Sidhi@gmail.com");
		user2.setUsername("Sidhesh");
		user2.setPhone("96643684845");
		user2.setPassword("12345675");
		
        // save multiple products at once
		userRepository.saveAll(List.of(user, user1,user2));
	}



	private static void checkUserExist(UserRepository userRepository) {
		// check user exists by id
         boolean hasExist = userRepository.existsById(3);
         System.out.println(hasExist);
	}



	private static void recordCount(UserRepository userRepository) {
		long recordCount = userRepository.count();
		System.out.println(recordCount);
	}



	private static void deleteById(UserRepository userRepository, Optional<User> optional) {
		if(optional.isPresent())
		{
		  userRepository.delete(optional.get());
		}
	}



	private static void updateUserInfo(UserRepository userRepository, Optional<User> optional) {
		if(optional.isPresent())
		{
			User  existingUser =optional.get();
			System.out.println(existingUser);
			existingUser.setPassword("India@12345");
			existingUser.setPhone(null);
			userRepository.save(existingUser);
			System.out.println("existingUser: -->"+existingUser);
		}
	}



	private static Optional<User> findUserInfo(UserRepository userRepository) throws Exception {
		Optional<User> optional = userRepository.findById(6);
		if(optional.isPresent())
		{
			System.out.println(optional.get());
		}
		else
		{
			throw new Exception("User not exist in DB");
		}
		return optional;
	}



	private static void fetchAllRecords(UserRepository userRepository) {
		var userlist = userRepository.findAll();
		userlist.forEach(System.out::println);
	}
	
	

	private static void saveUserInfo(UserRepository userRepository) {
		User user = new User();
		
		user.setEmailId("yogi@gmail.com");
		user.setUsername("yogi");
		user.setPhone("96643684845");
		user.setPassword("12345678");
		
		userRepository.save(user);
	}

}
