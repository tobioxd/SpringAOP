package com.tobioxd.springboot.thymeleafdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobioxd.springboot.thymeleafdemo.entities.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();

}
