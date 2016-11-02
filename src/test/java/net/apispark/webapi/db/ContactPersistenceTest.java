package net.apispark.webapi.db;

import net.apispark.webapi.representation.Contact;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by timrault on 2016-10-26.
 */
public class ContactPersistenceTest {

    @Test
    public void added_contact_is_correct() throws Exception {
        //Given
        Contact contact = new Contact(null, "Tim", "Rault", "svg-1", "Male");
        //When
        Contact result = ContactPersistence.INSTANCE.addContact(contact);
        //Then
        Assert.assertNotNull(contact.getId());
    }

    @Test
    public void added_contact_is_well_retrieved_by_id() throws Exception {
        //Given
        Contact contact = new Contact(null, "Tim", "Rault", "svg-1", "Male");
        Contact added = ContactPersistence.INSTANCE.addContact(contact);
        //When
        Contact retrieved = ContactPersistence.INSTANCE.getContact(added.getId());
        //Then
        Assert.assertEquals(added, retrieved);

    }

    @Test
    public void failing_added_contact_is_well_retrieved_by_id() throws Exception {
        Contact contact = new Contact(null, "Zinedine", "Zidane", "svg-1", "Male");
        Contact added = ContactPersistence.INSTANCE.addContact(contact);
        Contact retrieved = ContactPersistence.INSTANCE.getContact(added.getId());
        Assert.assertNotEquals(added, retrieved);

    }

}