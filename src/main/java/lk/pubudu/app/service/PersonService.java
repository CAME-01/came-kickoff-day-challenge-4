package lk.pubudu.app.service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lk.pubudu.app.dto.PersonDTO;
import lk.pubudu.app.entity.Person;
import lk.pubudu.app.repository.PersonRepository;
import lk.pubudu.app.util.Transformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final Transformer transformer;
    private final PersonRepository personRepository;
    @Value("${person.data.url}")
    private String url;

    @PostConstruct
    @Transactional(rollbackOn = Throwable.class)
    public void init() {
        System.out.println("Loaded URL from properties: " + url);

        // Delete all existing records before inserting new ones
        personRepository.deleteAll();
        System.out.println("Cleared existing records in the database.");

        System.out.println("Initial fetch on startup...");
        List<PersonDTO> personDTOS = fetchJsonData();
        persistToMySql(personDTOS);
    }

    @Scheduled(fixedRate = 5000)
    public List<PersonDTO> fetchJsonData() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PersonDTO[]> response = restTemplate.getForEntity(url, PersonDTO[].class);
        assert response.getBody() != null;
        List<PersonDTO> persons = Arrays.asList(response.getBody());

        System.out.println("Fetched " + persons.size() + " persons");
        // print first three records
        persons.stream().limit(3).forEach(System.out::println);

        return persons;
    }

    @Transactional(rollbackOn = Throwable.class)
    public void persistToMySql(List<PersonDTO> persons) {
        // Delete all existing records before inserting new ones
        personRepository.deleteAll();
        System.out.println("Cleared existing records in the database.");

        // Transform and save all new records
        List<Person> personList = persons.stream()
                .map(transformer::toPersonEntity)
                .toList();

        personRepository.saveAll(personList);
        System.out.println("Inserted " + personList.size() + " new records into the database.");
    }

}
