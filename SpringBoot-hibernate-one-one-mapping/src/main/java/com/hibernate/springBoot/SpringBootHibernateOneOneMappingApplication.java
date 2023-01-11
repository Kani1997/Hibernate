
package com.hibernate.springBoot;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.springBoot.entity.Gender;
import com.hibernate.springBoot.entity.User;
import com.hibernate.springBoot.entity.UserProfile;
import com.hibernate.springBoot.repository.UserRepository;

@SpringBootApplication
public class SpringBootHibernateOneOneMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateOneOneMappingApplication.class, args);
	}
	@Autowired
	private UserRepository userProfileRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		user.setName("Kani");
		user.setEmail("kani@gmail.com");
	
		UserProfile userProfile=new UserProfile();
		userProfile.setAddress("Chennai");
		userProfile.setBirthOfDate(LocalDate.of(1997, 05,10));	
		userProfile.setGender(Gender.FEMALE);
		userProfile.setPhoneNumber("6384034921");
		
		
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		
		userProfileRepository.save(user);
	}

}
