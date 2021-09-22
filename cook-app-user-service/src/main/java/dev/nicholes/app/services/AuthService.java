package dev.nicholes.app.services;

import dev.nicholes.app.beans.Person;

public interface AuthService {
	public String createToken(Person person);
	public Person checkToken(String tokenId);
	public void invalidateToken(Person person);
}
