package dev.nicholes.app.services;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import dev.nicholes.app.CookUserApp;
import dev.nicholes.app.beans.Person;
import dev.nicholes.app.data.TokenRepository;

@SpringBootTest(classes=CookUserApp.class)
public class AuthServiceTest {
	@Autowired
	public AuthService authServ;
	
	@MockBean
	public TokenRepository tokenDao;
	
	@Test
	public void tokenHasCorrectCharacters() {
		when(tokenDao.save(ArgumentMatchers.any())).thenReturn(null);
		String tknId = authServ.createToken(new Person());
		
		for (char ch : tknId.toCharArray()) {
			assertTrue(ch >= '!' && ch <= '~');
		}
	}
}
