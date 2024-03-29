package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
    @Id
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateStart;
    private LocalDateTime dateFin;


}
