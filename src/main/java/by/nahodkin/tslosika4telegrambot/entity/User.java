package by.nahodkin.tslosika4telegrambot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    private Integer id;
    private String flat;
    private String password;
    private String status;
    private String fio;
    private String phone;
    private String area;
    private String share;

    private String q11;
    private String q12;
    private String q13;

    private String q21;
    private String q22;
    private String q23;

    private String q31;
    private String q32;
    private String q33;
}
