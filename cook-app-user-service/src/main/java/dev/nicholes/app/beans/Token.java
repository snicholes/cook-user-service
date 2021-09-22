package dev.nicholes.app.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Token {
	@Id
	private String tokenId;
	@OneToOne
	@JoinColumn(name="person_id")
	private Person associatedPerson;
	
	public Token() {
		tokenId = "";
		associatedPerson = null;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public Person getAssociatedPerson() {
		return associatedPerson;
	}

	public void setAssociatedPerson(Person associatedPerson) {
		this.associatedPerson = associatedPerson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associatedPerson == null) ? 0 : associatedPerson.hashCode());
		result = prime * result + ((tokenId == null) ? 0 : tokenId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (associatedPerson == null) {
			if (other.associatedPerson != null)
				return false;
		} else if (!associatedPerson.equals(other.associatedPerson))
			return false;
		if (tokenId == null) {
			if (other.tokenId != null)
				return false;
		} else if (!tokenId.equals(other.tokenId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Token [tokenId=" + tokenId + ", associatedPerson=" + associatedPerson + "]";
	}
}
