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

    private String q41;
    private String q42;
    private String q43;

    private String q51;
    private String q52;
    private String q53;

    private String q61;
    private String q62;
    private String q63;

    private String q71;
    private String q72;
    private String q73;

    private String q81;
    private String q82;
    private String q83;

    private String q91;
    private String q92;
    private String q93;
}
