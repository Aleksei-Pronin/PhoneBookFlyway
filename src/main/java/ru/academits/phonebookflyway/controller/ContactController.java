package ru.academits.phonebookflyway.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.academits.phonebookflyway.converter.ContactDtoToContactConverter;
import ru.academits.phonebookflyway.converter.ContactToContactDtoConverter;
import ru.academits.phonebookflyway.dto.BaseResponse;
import ru.academits.phonebookflyway.dto.ContactDto;
import ru.academits.phonebookflyway.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;
    private final ContactToContactDtoConverter contactToContactDtoConverter;
    private final ContactDtoToContactConverter contactDtoToContactConverter;

    @GetMapping
    public List<ContactDto> getContacts(@RequestParam(required = false) String term) {
        return contactToContactDtoConverter.convert(contactService.get(term));
    }

    @PostMapping
    public BaseResponse createContact(@Valid @RequestBody ContactDto contact) {
        return contactService.create(contactDtoToContactConverter.convert(contact));
    }

    @PutMapping("/{id}")
    public BaseResponse updateContact(@Valid @RequestBody ContactDto contact, @PathVariable int id) {
        return contactService.update(contactDtoToContactConverter.convert(contact), id);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteContact(@PathVariable int id) {
        return contactService.delete(id);
    }

    @DeleteMapping
    public BaseResponse deleteContacts(@RequestBody List<Integer> contactIds) {
        return contactService.delete(contactIds);
    }
}