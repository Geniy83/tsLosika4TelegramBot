package by.nahodkin.tslosika4telegrambot.bot;

import by.nahodkin.tslosika4telegrambot.entity.BotStatus;
import by.nahodkin.tslosika4telegrambot.enums.BotStatusEnums;
import by.nahodkin.tslosika4telegrambot.service.BotStatusService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    private static final String botUserName = "NEVtestVEN";
    private static final String token = "5143583930:AAESQSalRsZ097mc5oxFL8vVAFXXL-13lOY";

    private BotStatus botStatus;
    @Autowired
    private BotStatusService botStatusService;

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        new Thread(() -> {
            if (update.hasMessage()) {
                String userName = update.getMessage().getFrom().getUserName();
                String firstName = update.getMessage().getFrom().getFirstName();
                String start = update.getMessage().getText();
                String chatId = update.getMessage().getChatId().toString();

                if (start.startsWith("/start")) {
                    try {


                        String status = botStatusService.getBotStatusByChat_id(chatId);
                        if (status != null) {
                            botStatusService.deleteBotStatusByChat_id(chatId);
                        }

                        botStatus = new BotStatus();
                        botStatus.setStatus(BotStatusEnums.ASK_0.name());
                        botStatus.setUsername(userName);
                        botStatus.setChat_id(chatId);
                        botStatusService.saveBotStatus(botStatus);

                        execute(SendMessageConstructor.sendMessage("Привет " + firstName + " (@" + userName + ") в нашем телеграм-боте для сверки данных",
                                update.getMessage().getChatId().toString(), false,
                                null));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            } else if (update.hasCallbackQuery()) {

            }
        }).start();
    }
}
