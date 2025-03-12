package utilities;
import com.github.javafaker.Faker;

public class Fakerutility {
	Faker faker=new Faker();
	public String generateFirstName()
	{
		return faker.name().firstName();
		
	}
	public String generateLastName()
	{
		return faker.name().lastName();
		
	}
	public String generateAddress()
	{
		return faker.address().fullAddress();
		
		
	}
	public String generatePhoneNumber()
	{
		return faker.phoneNumber().toString();
		
	}
	public long generaterandomNumber()
	{
		return faker.number().randomNumber();
		
	}
	public String generateJob()
	{
		return faker.job().field();
		
	}
	public String generateemail()
	{
		return faker.internet().emailAddress();
		
	}
	public long generaterandomDigit()
	{
		return faker.number().randomDigit();
		
	}
	

}
