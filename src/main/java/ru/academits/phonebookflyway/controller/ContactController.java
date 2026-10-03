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
    public BaseResponse createContact(@Valid @RequestBody ContactDto contactDto) {
        contactService.create(contactDtoToContactConverter.convert(contactDto));
        return BaseResponse.ok();
    }

    @PutMapping("/{id}")
    public BaseResponse updateContact(@PathVariable int id, @Valid @RequestBody ContactDto contactDto) {
        contactService.update(id, contactDtoToContactConverter.convert(contactDto));
        return BaseResponse.ok();
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteContact(@PathVariable int id) {
        contactService.delete(id);
        return BaseResponse.ok();
    }

    @DeleteMapping
    public BaseResponse deleteContacts(@RequestBody List<Integer> contactIds) {
        contactService.delete(contactIds);
        return BaseResponse.ok();
    }
}