package by.nahodkin.tslosika4telegrambot.question;

import by.nahodkin.tslosika4telegrambot.bot.Bot;
import by.nahodkin.tslosika4telegrambot.bot.KeyboardConstructor;
import by.nahodkin.tslosika4telegrambot.bot.SendMessageConstructor;
import by.nahodkin.tslosika4telegrambot.enums.BotStatusEnums;
import by.nahodkin.tslosika4telegrambot.service.BotStatusService;
import by.nahodkin.tslosika4telegrambot.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.List;

import static by.nahodkin.tslosika4telegrambot.question.Questions.*;

@Component
public class QuestionsUser {
    @Autowired
    private BotStatusService botStatusService;
    @Autowired
    private UserService userService;

    private SendMessage sendMessage;

    @SneakyThrows
    public SendMessage questions(String status, String chatId, Integer idUser) {
        String statusQuestions = botStatusService.getBotStatusByChat_id(chatId);
        if(status.equals("0")) {
            if(statusQuestions.equals(BotStatusEnums.ASK_3.toString())) {
                botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_4.toString());
                sendMessage = SendMessageConstructor.sendMessage(question1, chatId, true, answer());
            } else
                if(statusQuestions.equals(BotStatusEnums.ASK_4.toString())) {
                    EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup();
                    editMessageReplyMarkup.setMessageId(sendMessage.getReplyToMessageId());
                    editMessageReplyMarkup.setReplyMarkup(null);


                botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_5.toString());
                sendMessage = SendMessageConstructor.sendMessage(question2, chatId, true, answer());
            } else
                if(statusQuestions.equals(BotStatusEnums.ASK_5.toString())) {
                botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_6.toString());
                sendMessage = SendMessageConstructor.sendMessage(question3, chatId, true, answer());
            } else
                if(statusQuestions.equals(BotStatusEnums.ASK_6.toString())) {
                    botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_7.toString());
                    sendMessage = SendMessageConstructor.sendMessage(question4, chatId, true, answer());
                } else
                if(statusQuestions.equals(BotStatusEnums.ASK_7.toString())) {
                    botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_8.toString());
                    sendMessage = SendMessageConstructor.sendMessage(question5, chatId, true, answer());
                } else
                if(statusQuestions.equals(BotStatusEnums.ASK_8.toString())) {
                    botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_9.toString());
                    sendMessage = SendMessageConstructor.sendMessage(question6, chatId, true, answer());
                } else
                if(statusQuestions.equals(BotStatusEnums.ASK_9.toString())) {
                    botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_10.toString());
                    sendMessage = SendMessageConstructor.sendMessage(question7, chatId, true, answer());
                } else
                if(statusQuestions.equals(BotStatusEnums.ASK_10.toString())) {
                    botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_11.toString());
                    sendMessage = SendMessageConstructor.sendMessage(question8, chatId, true, answer());
                } else
                if(statusQuestions.equals(BotStatusEnums.ASK_11.toString())) {
                    botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_12.toString());
                    sendMessage = SendMessageConstructor.sendMessage(question9, chatId, true, answer());
                } else
                if(statusQuestions.equals(BotStatusEnums.ASK_12.toString())) {
                sendMessage = SendMessageConstructor.sendMessage("Подтвердите ваш выбор нажав 'Да' или пройдите заново опрос нажав 'Нет'", chatId, true, confirmation());
            } else
                if(statusQuestions.equals(BotStatusEnums.END.toString())) {
                sendMessage = SendMessageConstructor.sendMessage("Спасибо за участие в собрании ТС", chatId, false, null);
            }
        } else {
            sendMessage = SendMessageConstructor.sendMessage("Вы уже приняли участие в голосовании! Если хотите изменить своё решение, обратитесь к Администратору", chatId, false, null);
        }
        return sendMessage;
    }

    public InlineKeyboardMarkup answer() {
        return KeyboardConstructor.createMarkup(
                KeyboardConstructor.createRow(KeyboardConstructor.createButton("За", "Per"),
                        KeyboardConstructor.createButton("Против", "Against"),
                        KeyboardConstructor.createButton("Воздержался", "Abstained")));
    }

    public InlineKeyboardMarkup confirmation() {
        return KeyboardConstructor.createMarkup(
                KeyboardConstructor.createRow(KeyboardConstructor.createButton("Да", "Yes"),
                        KeyboardConstructor.createButton("Нет", "No")));
    }
}
