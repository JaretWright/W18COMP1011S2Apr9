package w18comp1011s2apr9;

/**
 *
 * @author JWright
 */
public class Contact
{
    private String firstName, lastName, phone;

    public Contact(String firstName, String lastName, String phone)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        //use regex to validate the phone number
        //   \\d means any digit between 0 to 9
        //   {2} means we expect 2 characters from the range of 0-9
        if (phone.matches("\\(?[2-9]\\d{2}\\)?[-\\s.]?[2-9]\\d{2}[-\\s.]?\\d{4}"))
            this.phone = phone;
        else 
            throw new IllegalArgumentException("Phone number must match "
                            + "the North American Dialing Plan");
        
    }
    
    @Override
    public String toString()
    {
        return String.format("%s %s", firstName, lastName);
    }
    
    
}
