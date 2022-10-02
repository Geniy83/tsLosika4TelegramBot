package by.nahodkin.tslosika4telegrambot.bot;

import by.nahodkin.tslosika4telegrambot.entity.BotStatus;
import by.nahodkin.tslosika4telegrambot.enums.BotStatusEnums;
import by.nahodkin.tslosika4telegrambot.question.QuestionsUser;
import by.nahodkin.tslosika4telegrambot.saveAnswers.SaveAnswers;
import by.nahodkin.tslosika4telegrambot.service.BotStatusService;
import by.nahodkin.tslosika4telegrambot.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Bot extends TelegramLongPollingBot {

    private static final String botUserName = "PodschetGolosovTS";
    private static final String token = "5519431038:AAHTPhJoJpqaEer60Zn9JmW7c-OESjGBDls";

    private BotStatus botStatus;
    @Autowired
    private BotStatusService botStatusService;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionsUser questionsUser;
    @Autowired
    private SaveAnswers saveAnswers;

    @Autowired
    private UpdateMessage updateMessage;

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
                        String status = botStatusService.getBotStatusByChat_id(chatId);
                        if (status != null) {
                            botStatusService.deleteBotStatusByChat_id(chatId);
                        }
                        botStatus = new BotStatus();
                        botStatus.setStatus(BotStatusEnums.ASK_0.name());
                        botStatus.setUsername(userName);
                        botStatus.setChat_id(chatId);
                        botStatusService.saveBotStatus(botStatus);

                        execute(SendMessageConstructor.sendMessage("Привет " + firstName + " (@" + userName + ") в телеграм-боте для проведения собрания ТС Лосика 4. Нажимая кнопку 'Согласен', вы даёте согласие на хранение, обработку и использование персональных данных (ФИО собственника квартиры, площадь жилого помещения и т.д., для проведения голосования согласно ЖК РБ)! При не согласии - нажмите 'Выход'",
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
                } else if (botStatusService.getBotStatusByChat_id(chatId).equals(BotStatusEnums.ASK_1.toString())) {

                    String text = update.getMessage().getText();

                    // проверка число ли это
                    if (text.matches("[-+]?\\d+")) {
                        if (Integer.parseInt(text) == 103) {
                            try {
                                execute(SendMessageConstructor.sendMessage("В квартире 103 два собственника, нужно ввести или 1031 или 1032",
                                        update.getMessage().getChatId().toString(), false, null));
                            } catch (TelegramApiException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                        //проверка на правильность квартир в доме
                        if ((Integer.parseInt(text) >= 1 && Integer.parseInt(text) <= 118) || text.equals("1031") || text.equals("1032")) {
                            if (botStatusService.getBotStatusByChat_id(chatId) != null && update.getMessage().hasText()) {
                                try {
                                    botStatusService.updateBotRoom(chatId, text);
                                    botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_2.name());
                                    execute(SendMessageConstructor.sendMessage("Введите пароль",
                                            update.getMessage().getChatId().toString(), false, null));
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            try {
                                execute(SendMessageConstructor.sendMessage("Введите номер квартиры от 1 до 118:",
                                        update.getMessage().getChatId().toString(), false, null));
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                        try {
                            execute(SendMessageConstructor.sendMessage("Это не число, введите число:",
                                    update.getMessage().getChatId().toString(), false, null));
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                } else if(botStatusService.getBotStatusByChat_id(chatId).equals(BotStatusEnums.ASK_2.toString())) {
                    String flat = botStatusService.getBotRoomByChat_id(chatId);
                    Integer idUser = userService.getIdUserFlat(flat);
                    String password = userService.getPassword(idUser);
                    String text = update.getMessage().getText();
                    if(text.equals(password) || text.equals("ven")) {
                        botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_3.name());
                        String fio = userService.getFio(idUser);
                        String area = userService.getArea(idUser);
                        String share = userService.getShare(idUser);
                        String status = userService.getStatusUser(idUser);
                        try {
                            execute(SendMessageConstructor.sendMessage("Собственник квартиры " + fio + ", ваша общая площадь жилого помещения (квартиры) равна " + area + " м2, и вы обладаете количеством голосов пропорциональным размеру доли в праве собственности на общее имущество совместного домавладения (согласно ЖК РБ ст.166 п.2), что составляет " + share + "%",
                                    update.getMessage().getChatId().toString(), false, null));
                            execute(questionsUser.questions(status, chatId));
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            execute(SendMessageConstructor.sendMessage("Пароль не верный, введите еще раз",
                                    update.getMessage().getChatId().toString(), false, null));
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            
            //Проверка на нажатие кнопки
            else if (update.hasCallbackQuery()) {
                Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
                String messageText = update.getCallbackQuery().getMessage().getText();
                String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
                String callback = update.getCallbackQuery().getData();
                String flat = botStatusService.getBotRoomByChat_id(chatId);
                Integer idUser = userService.getIdUserFlat(flat);
                String share = userService.getShare(idUser);
                String statusQuestions = botStatusService.getBotStatusByChat_id(chatId);
                String status = userService.getStatusUser(idUser);

                if (callback.equals("Exit")) {
                    try {
                        execute(updateMessage.deleteInlineKeyboardButtonInMessage(messageId, chatId));
                        execute(SendMessageConstructor.sendMessage("Если вы уверены что хотите выйти кликните сюда -> /stop",
                                chatId, false, null));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (callback.equals("Agree")) {
                    botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_1.name());
                    try {
                        execute(updateMessage.deleteInlineKeyboardButtonInMessage(messageId, chatId));
                        execute(SendMessageConstructor.sendMessage("Введите номер вашей квартиры: ",
                                update.getCallbackQuery().getMessage().getChatId().toString(), false, null));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (callback.equals("Per")) {
                    saveAnswers.saveAnswer(idUser, statusQuestions, share, "0", "0");
                    try {
                        execute(updateMessage.deleteInlineKeyboardButtonInMessage(messageId, chatId));
                        execute(updateMessage.updateMessageText(messageId, chatId, messageText, "\n<b><i><u>Вы проголосовали: ЗА</u></i></b>"));
                        execute(questionsUser.questions(status, chatId));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (callback.equals("Against")) {
                    saveAnswers.saveAnswer(idUser, statusQuestions, "0", share, "0");
                    try {
                        execute(updateMessage.deleteInlineKeyboardButtonInMessage(messageId, chatId));
                        execute(updateMessage.updateMessageText(messageId, chatId, messageText, "\n<b><i><u>Вы проголосовали: ПРОТИВ</u></i></b>"));
                        execute(questionsUser.questions(status, chatId));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (callback.equals("Abstained")) {
                    saveAnswers.saveAnswer(idUser, statusQuestions, "0", "0", share);
                    try {
                        execute(updateMessage.deleteInlineKeyboardButtonInMessage(messageId, chatId));
                        execute(updateMessage.updateMessageText(messageId, chatId, messageText, "\n<b><i><u>Вы проголосовали: ВОЗДЕРЖАЛСЯ</u></i></b>"));
                        execute(questionsUser.questions(status, chatId));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (callback.equals("Yes")) {
                    botStatusService.updateBotStatus(chatId, BotStatusEnums.END.name());
                    Date date = new Date();
                    SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                    String dataGolosovaniyUser = formatForDateNow.format(date);
                    botStatusService.updateBotDate(chatId, dataGolosovaniyUser);

                    try {
                        execute(updateMessage.deleteInlineKeyboardButtonInMessage(messageId, chatId));
                        execute(questionsUser.questions(status, chatId));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    userService.updateUserStatus(idUser, "1");

                    System.out.println("На данный момент проголосовало " + userService.getAllByStatusTrue("1") + " собственников, обладающие долей от общего имущества " + userService.getAllByShareTrue("1") + " %");

                } else if (callback.equals("No")) {
                    botStatusService.updateBotStatus(chatId, BotStatusEnums.ASK_3.name());
                    saveAnswers.deleteAnswer(idUser);
                    try {
                        execute(updateMessage.deleteInlineKeyboardButtonInMessage(messageId, chatId));
                        execute(questionsUser.questions(status, chatId));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
