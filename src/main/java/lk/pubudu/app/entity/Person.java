package lk.pubudu.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 5981801158962140394L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String name;
    @Column(nullable = false, columnDefinition = "VARCHAR(64)")
    private String language;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String bio;
    @Column(nullable = false, columnDefinition = "VARCHAR(64)")
    private Double version;
}
