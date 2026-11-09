package oms.com.example.oms.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", nullable = false)
    private long id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name= "email", nullable = false)
    private String email;

    @Column(name= "password", nullable = false)
    private String password;

    @Column(name= "phone", nullable = false)
    private String phone;

    // Usage constructures
    public User(){}

    public User(int i, String admin, String mail, String s, String number) {
    }
}
