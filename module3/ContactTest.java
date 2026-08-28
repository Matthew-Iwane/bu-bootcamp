import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 

  private Contact contact; 
  private Contact contact2; 
  private Contact contact3; 
 
  @BeforeEach
  void setUp() {
    contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    contact2 = new Contact("Grace Hopper", "+1 070555-0001");
    contact3 = new Contact("Alan Turing", "234 0382");
  } 

  @Test 
  void constructor_setsNameCorrectly() { 
    assertEquals("Ada Lovelace", contact.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    assertEquals("+1 617 555 0101", contact.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    assertEquals("Grace Hopper", contact2.getName());
  } 
 
  @Test
  void toString_containsName() { 
    assertTrue(contact3.toString().contains("Alan Turing"));
  } 
 
  @Test
  void toString_containsPhone() {
    assertTrue(contact2.toString().contains("555-0001"));
  }

  @Test
  void contactsWithSameName_areIndependentObjects() {
    Contact first = new Contact("Ada Lovelace", "+1 617 555 0101");
    Contact second = new Contact("Ada Lovelace", "+1 415 555 0199");

    assertNotSame(first, second);
    assertEquals("+1 617 555 0101", first.getPhone());
    assertEquals("+1 415 555 0199", second.getPhone());
  }
}
