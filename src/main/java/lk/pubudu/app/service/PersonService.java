package lk.pubudu.app.service;

import jakarta.annotation.PostConstruct;
import lk.pubudu.app.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private static final String URL = "https://microsoftedge.github.io/Demos/json-dummy-data/64KB.json";

    @PostConstruct
    public void init() {
        System.out.println("Initial fetch on startup...");
        fetchJsonData();
    }

    @Scheduled(fixedRate = 5000)
    public void fetchJsonData() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PersonDTO[]> response = restTemplate.getForEntity(URL, PersonDTO[].class);
        List<PersonDTO> persons = Arrays.asList(response.getBody());

        System.out.println("Fetched " + persons.size() + " persons");
        persons.stream().limit(3).forEach(System.out::println);
    }

}
