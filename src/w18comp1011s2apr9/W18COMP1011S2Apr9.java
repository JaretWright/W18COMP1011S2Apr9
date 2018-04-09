package w18comp1011s2apr9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author JWright
 */
public class W18COMP1011S2Apr9
{
    private static TreeMap<String, LinkedList> phoneBook;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Fred");
        arrayList.add("June");
        arrayList.addAll(Arrays.asList("Mary", "Bart"));
        arrayList.add(2, "Jack");
        
        System.out.println("ArrayList example");
        for (int i=0; i<arrayList.size();i++)
        {
            System.out.printf("Index: %d Name: %s%n", i, arrayList.get(i));
        }
        
        //using Streams to filter for names starting with "J"
        arrayList.stream()
                 .peek(name -> System.out.printf("%nname before filter: %s", name))
                 .filter(name ->name.substring(0, 1).equals("J"))
                 .peek(name -> System.out.printf(" name after filter: %s%n", name))
                 .forEach(name -> System.out.println());
        
        
        
                         
        
        System.out.println("\nLinkedList");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Fred");
        linkedList.add("June");
        linkedList.add("June");
        linkedList.addAll(Arrays.asList("Mary", "Bart"));
        
        for (int i=0; i<linkedList.size();i++)
        {
            System.out.printf("Index: %d Name: %s%n", i, linkedList.get(i));
        }        
        
        System.out.println("\nHashSet");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Jaret");
        hashSet.add("Jaret");  //not added because it is a duplicate
        hashSet.add("Frank");
        for (String name: hashSet)
        {
            System.out.println(name);
        }
        
        System.out.println("\nTreeSet - an ordered list with no duplicates");
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Fred");
        treeSet.add("June");
        treeSet.addAll(Arrays.asList("Mary", "Bart"));
        treeSet.add("Jack");
        
        for (String name: treeSet)
        {
            System.out.printf("Name: %s%n", name);
        }
        
        System.out.println("\nHashmap - this associates keys and values");
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("Fred", "705-555-1234");
        hashMap.put("Arnold", "705-555-1235");
        
        for (String key: hashMap.keySet())
        {
            System.out.printf("Key: %-8s %5s %-10s%n", key, "value:",hashMap.get(key));
        }
        
        //valid contact
        Contact newContact = new Contact("Oscar","the Grouch", "705 555 1234");
        Contact newContact2 = new Contact("Oscar","the Grouch", "705-555-1234");
        Contact newContact3 = new Contact("Oscar","the Grouch", "(705) 555-1234");
        Contact newContact4 = new Contact("Oscar","the Grouch", "705.555.1234");
        try{
            Contact invalidContact = new Contact("Bad","Contact", "a055551234");
        }catch (IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }
        
        System.out.println("\nTreeMap with LinkedLists");
        phoneBook = new TreeMap<>();
        addContact("Big","Bird","705 444 1234");
        addContact("Fred", "Astaire", ("(705) 222-7654"));
        addContact("Frank", "Abbit", "416-999-2222");
        addContact("Jaret", "Wright", "416-999-2222");
        
        for (String key: phoneBook.keySet())
        {
            //to remove the brackets from the LinkedList toString() method
            String contacts = phoneBook.get(key).toString();
            contacts = contacts.substring(1, contacts.length()-1);
            
            System.out.printf("Key: %s %5s %-10s%n", key, "value:",contacts);
        }
    }
    
    /**
     * This method will add a Contact to the phoneBook
     */
    public static void addContact(String firstName, String lastName, String phone)
    {
        Contact newContact = new Contact(firstName, lastName, phone);
        String firstLetter = lastName.substring(0, 1); //get's the first letter of the last name
        
        if (!phoneBook.containsKey(firstLetter))
        {
            LinkedList<Contact> linkedList = new LinkedList<>();
            linkedList.add(newContact);
            phoneBook.put(firstLetter, linkedList);
        }
        else
        {
            phoneBook.get(firstLetter).add(newContact);
        }
    }
}
