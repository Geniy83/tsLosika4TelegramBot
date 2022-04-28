package by.nahodkin.tslosika4telegrambot.application;

import by.nahodkin.tslosika4telegrambot.bot.Bot;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@EntityScan("by.nahodkin.tslosika4telegrambot.entity")
@EnableJpaRepositories("by.nahodkin.tslosika4telegrambot.repository")
@ComponentScan("by.nahodkin.tslosika4telegrambot")
public class TsLosika4TelegramBotApplication {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(TsLosika4TelegramBotApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(@Autowired TelegramBotsApi telegramBotsApi, @Autowired Bot bot) {
        return args -> {
            telegramBotsApi.registerBot(bot);
        };
    }

    @SneakyThrows
    @Bean
    public TelegramBotsApi telegramBotsApi(Bot bot) {
        return new TelegramBotsApi(DefaultBotSession.class);
    }
}
