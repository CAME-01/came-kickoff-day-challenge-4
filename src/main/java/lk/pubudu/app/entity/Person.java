package lk.pubudu.app.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 5981801158962140394L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(255)")
    private String name;
    @Column(name = "language", nullable = false, columnDefinition = "VARCHAR(64)")
    private String language;
    @Column(name = "bio", nullable = false, columnDefinition = "TEXT")
    private String bio;
    @Column(name = "version", nullable = false, columnDefinition = "VARCHAR(64)")
    private String version;
}
