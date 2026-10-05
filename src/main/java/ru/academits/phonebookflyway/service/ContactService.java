package ru.academits.phonebookflyway.service;


import ru.academits.phonebookflyway.dto.BaseResponse;
import ru.academits.phonebookflyway.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> get(String term);

    BaseResponse create(Contact contact);

    BaseResponse update(Contact contact, int contactId);

    BaseResponse delete(int contactId);

    BaseResponse delete(List<Integer> contactIds);
}