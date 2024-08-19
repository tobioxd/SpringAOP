package com.example.SpringAOP;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.SpringAOP.dao.AccountDAO;
import com.example.SpringAOP.dao.MembershipDAO;
import com.example.SpringAOP.dao.service.TrafficFortuneService;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService) {

		return runner -> {

			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			// demoTheAfterReturningAdvice(theAccountDAO); 
			// demoTheAfterThrowingAdvice(theAccountDAO);
			// demoTheAfterAdvice(theAccountDAO);
			// demoTheAroundAdvice(theTrafficFortuneService);
			// demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethowException(theTrafficFortuneService);

		};
	}

	private void demoTheAroundAdviceRethowException(TrafficFortuneService theTrafficFortuneService) {
		
		System.out.println("\n\nMain Program: demoTheAroundAdviceRethowException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("\nFinished");

	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		
		System.out.println("\n\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("\nFinished");

	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		
		System.out.println("\n\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("\nFinished");

	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		
		// call the method to find accounts
		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate an exception
			boolean tripWire = true;
			accounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}

		// display the accounts
		System.out.println("\n\nMain Program: AfterDemoApp");
		System.out.println("----");

		System.out.println(accounts);

		System.out.println("\n");

	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		
		// call the method to find accounts
		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate an exception
			boolean tripWire = true;
			accounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}

		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("----");

		System.out.println(accounts);

		System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		// call the method to find accounts
		List<Account> accounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");

		System.out.println(accounts);

		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("tobioxd");
		myAccount.setLevel("diamond");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("bananakong");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}
