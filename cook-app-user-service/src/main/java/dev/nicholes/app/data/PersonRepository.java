package dev.nicholes.app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.nicholes.app.beans.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	public Person findByUsername(String username);
}
