package ru.academits.phonebookflyway.converter;

import org.springframework.stereotype.Service;
import ru.academits.phonebookflyway.dto.ContactDto;
import ru.academits.phonebookflyway.entity.Contact;

@Service
public class ContactToContactDtoConverter implements Converter<Contact, ContactDto> {
    @Override
    public ContactDto convert(Contact source) {
        ContactDto contactDto = new ContactDto();

        contactDto.setId(source.getId());
        contactDto.setSurname(source.getSurname());
        contactDto.setName(source.getName());
        contactDto.setPhone(source.getPhone());

        return contactDto;
    }
}