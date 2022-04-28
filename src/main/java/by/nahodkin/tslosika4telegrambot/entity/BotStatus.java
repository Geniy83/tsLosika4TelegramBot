package by.nahodkin.tslosika4telegrambot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bot_status")
@NoArgsConstructor
@Getter
public class BotStatus {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Setter
    private String chat_id;
    @Setter
    private String username;
    @Setter
    private String status;
    @Setter
    private String room;
}