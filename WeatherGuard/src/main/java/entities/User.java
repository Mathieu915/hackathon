package entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "User")
public class User {

    @Id
    private long idUser;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String department;
    private String zipCode;
}

