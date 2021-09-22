package dev.nicholes.app.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.nicholes.app.beans.Person;
import dev.nicholes.app.beans.Token;
import dev.nicholes.app.data.TokenRepository;

@Service
public class AuthServiceImpl implements AuthService {
	private TokenRepository tokenDao;

	@Autowired
	public AuthServiceImpl(TokenRepository tokenDao) {
		this.tokenDao = tokenDao;
	}

	@Override
	public String createToken(Person person) {
		if (person != null) {
			Random rand = new Random();
			char[] tokenChar = new char[10];
			for (int i = 0; i < tokenChar.length; i++) {
				// 33 to 126
				int ch = rand.nextInt(126 - 33) + 33;
				tokenChar[i] = (char) ch;
			}
			System.out.println(tokenChar);

			Token tkn = new Token();
			tkn.setTokenId(tokenChar.toString());
			tkn.setAssociatedPerson(person);

			tokenDao.save(tkn);

			return tkn.getTokenId();
		} else {
			return null;
		}
	}

	@Override
	public Person checkToken(String tokenId) {
		Token tkn = tokenDao.getOne(tokenId);
		if (tkn != null) {
			return tkn.getAssociatedPerson();
		}
		return null;
	}

	@Override
	public void invalidateToken(Person person) {
		Token tkn = tokenDao.findByPerson(person);
		tokenDao.delete(tkn);
	}
}
