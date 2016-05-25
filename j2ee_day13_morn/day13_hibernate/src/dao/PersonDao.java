package dao;

import java.util.Date;
import java.util.List;

import hib_pojos.Book;
import hib_pojos.Person;

public interface PersonDao {
	Person addPerson(Person p) throws Exception;
	Person deletePerson(Person p) throws Exception;
	Person getPersonById(Integer id) throws Exception;
	

}
