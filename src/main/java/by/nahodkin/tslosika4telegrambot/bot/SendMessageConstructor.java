package by.nahodkin.tslosika4telegrambot.bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class SendMessageConstructor {
    /**
     * @author Nahodkin Evgeniy 3477734n@gmail.com (https://t.me/VENVeV)
     * Статический метод для создания объекта SendMessage.
     * Принимает на вход String message, String chatId, boolean needKeyboard, InlineKeyboardMarkup markup.
     * message - текст сообщения, которое будет отправлено пользователю.
     * chatId - id чата, в которое будет отправлено сообщение.
     * needKeyboard - устанавливать значение true, если к сообщению надо привязать кнопки. В случае false -
     * оставить параметр markup = null.
     */
    @SneakyThrows
    public static SendMessage sendMessage(
            String message,
            String chatId,
            boolean needKeyboard,
            InlineKeyboardMarkup markup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        if (needKeyboard) {
            if (markup != null) {
                sendMessage.setReplyMarkup(markup);
            } else {
                throw new Exception(
                        "Нужно указать клавиатуру для метода sendMessage, " +
                                "иначе установите значение needKeyboard == false в параметрах метода");
            }
        }
        return sendMessage;
    }
}