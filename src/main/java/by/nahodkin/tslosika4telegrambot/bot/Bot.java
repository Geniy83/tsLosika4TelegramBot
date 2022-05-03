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
            //Проверка на введенный текст
            if (update.hasMessage()) {
                String userName = update.getMessage().getFrom().getUserName();
                String firstName = update.getMessage().getFrom().getFirstName();
                String start = update.getMessage().getText();
                String chatId = update.getMessage().getChatId().toString();

                if (start.startsWith("/start")) {
                    try {

//                        String status = botStatusService.getBotStatusByChat_id(chatId);
//                        if (status != null) {
//                            botStatusService.deleteBotStatusByChat_id(chatId);
//                        }

                        botStatus = new BotStatus();
                        botStatus.setStatus(BotStatusEnums.ASK_0.name());
                        botStatus.setUsername(userName);
                        botStatus.setChat_id(chatId);
                        botStatusService.saveBotStatus(botStatus);

                        execute(SendMessageConstructor.sendMessage("Привет " + firstName + " (@" + userName + ") в телеграм-боте для проведения голосования ТС Лосика 4. Нажимая кнопку 'Согласен', вы даёте согласие на обработку и использование персональных данных (ФИО собственника квартиры, площади жилого помещения и т.д., для проведения голосования согласно ЖК РБ)! При не согласии - нажмите 'Выход'",
                                update.getMessage().getChatId().toString(), true,
                                BotMainMenu.sendMainMenu()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (start.startsWith("/stop")) {
                    try {
                        botStatusService.updateBotStatus(chatId, BotStatusEnums.STOP.name());
                        execute(SendMessageConstructor.sendMessage("Просьба явится в помещения ТС Лосика 4, для провидения очного голосования. При себе иметь удостовирение личности. До свидания!",
                                update.getMessage().getChatId().toString(), false, null));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
            //Проверка на нажатие кнопки
            else if (update.hasCallbackQuery()) {
                String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
                String callback = update.getCallbackQuery().getData();

                if (callback.equals("Exit")) {
                    try {
                        execute(SendMessageConstructor.sendMessage("Если вы уверены что хотите выйти кликните сюда -> /stop",
                                chatId, false, null));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
