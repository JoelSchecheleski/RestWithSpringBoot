package br.com.uppertools.data.vo;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import lombok.Getter;
import lombok.Setter;


@JsonPropertyOrder({"id", "adress", "first_name", "last_name", "genger"})
public class PersonVO extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Mapping("id")
	@JsonProperty("id")
	@Getter @Setter
	private Long key;
	
	@Getter @Setter
	@JsonProperty("first_name")
	private String firstName;
	
	@Getter @Setter
	@JsonProperty("last_name")
	private String lastName;
	
	@Getter @Setter
	private String adress;
	
	@Getter @Setter
	@JsonIgnore
	private String genger;
	
	public PersonVO() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((genger == null) ? 0 : genger.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (genger == null) {
			if (other.genger != null)
				return false;
		} else if (!genger.equals(other.genger))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}


}
