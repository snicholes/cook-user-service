package dev.nicholes.app.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.nicholes.app.beans.Person;
import dev.nicholes.app.beans.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, String>{
	public Token findByPerson(Person person);
}
