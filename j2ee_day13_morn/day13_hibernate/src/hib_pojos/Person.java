package hib_pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dac_persons")
public class Person {
	private Integer id;
	private String name;
	private List<Address> addresses = new ArrayList<>();
	private List<String> hobbies = new ArrayList<String>();

	public Person() {
		System.out.println("in person constr");
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "my_gen", sequenceName = "my_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_gen")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ElementCollection
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	//def fetching policy = LAZY
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "dac_per_hobbies", 
	joinColumns = @JoinColumn(name = "per_id"))
	@Column(length = 100)
	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Person id=" + id + ", name=" + name + " Hobbies  " + hobbies
				+ " adr=" + addresses;

	}

}
