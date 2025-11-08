package lk.pubudu.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1099389437728308115L;
    private String id;
    private String name;
    private String language;
    private String bio;
    private Double version;
}
