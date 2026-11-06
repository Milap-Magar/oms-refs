package oms.com.example.oms.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class User {

    @Setter @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", nullable = false)
    private long id;

    @Setter @Getter
    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Setter @Getter
    @Column(name= "email", nullable = false)
    private String email;

    @Setter @Getter
    @Column(name= "password", nullable = false)
    private String password;

    @Setter @Getter
    @Column(name= "phone", nullable = false)
    private String phone;

    // Usage constructures
    public User(){}

    public User(int i, String admin, String mail, String s, String number) {
    }
}
