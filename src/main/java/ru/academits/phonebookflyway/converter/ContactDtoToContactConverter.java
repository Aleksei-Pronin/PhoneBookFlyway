package ru.academits.phonebookflyway.converter;

import org.springframework.stereotype.Service;
import ru.academits.phonebookflyway.dto.ContactDto;
import ru.academits.phonebookflyway.entity.Contact;

@Service
public class ContactDtoToContactConverter implements Converter<ContactDto, Contact> {
    @Override
    public Contact convert(ContactDto source) {
        Contact contact = new Contact();

        contact.setId(source.getId());
        contact.setSurname(source.getSurname().trim());
        contact.setName(source.getName().trim());
        contact.setPhone(source.getPhone().trim());

        return contact;
    }
}