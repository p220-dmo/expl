package fr.htc.formation.files;
import static java.util.GregorianCalendar.YEAR;
import java.util.GregorianCalendar;
 
public class Person
{
    private String firstname, lastname;
    private GregorianCalendar birthdate;
    private int age;
 
    public Person (String first, String last, GregorianCalendar birthdate)
    {
        firstname = first;
        lastname = last;
        this.birthdate = birthdate;
        age = new GregorianCalendar().get (YEAR) - birthdate.get (YEAR);
    }
 
    public String getFirstname()
    {
        return firstname;
    }
 
    @Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate.getTime() + ", age=" + age
				+ "]";
	}

	public String getLastname()
    {
        return lastname;
    }
 
    public GregorianCalendar getBirthdate()
    {
        return birthdate;
    }
 
    public int getAge()
    {
        return age;
    }
}