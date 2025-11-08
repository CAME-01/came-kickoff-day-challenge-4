package lk.pubudu.app.util;

import lk.pubudu.app.dto.PersonDTO;
import lk.pubudu.app.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    public Person toPersonEntity(PersonDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .language(personDTO.getLanguage())
                .bio(personDTO.getBio())
                .version(String.valueOf(personDTO.getVersion()))
                .build();
    }

    public PersonDTO toPersonDTO(Person person) {
        return PersonDTO.builder()
                .id(String.valueOf(person.getId()))
                .name(person.getName())
                .language(person.getName())
                .bio(person.getBio())
                .version(Double.valueOf(person.getVersion()))
                .build();
    }

}
