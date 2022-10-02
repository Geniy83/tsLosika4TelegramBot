package by.nahodkin.tslosika4telegrambot.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

@Component
public class UpdateMessage {
    public EditMessageReplyMarkup deleteInlineKeyboardButtonInMessage(Integer messageId, String chatId) {
        EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup();
        editMessageReplyMarkup.setMessageId(messageId);
        editMessageReplyMarkup.setChatId(chatId);
        editMessageReplyMarkup.setReplyMarkup(null); // удаление кнопок привязанных к сообщению
        return editMessageReplyMarkup;
    }

    public EditMessageText updateMessageText(Integer messageId, String chatId, String messageText, String addTextInMessage) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setMessageId(messageId);
        editMessageText.setChatId(chatId);
        editMessageText.setParseMode("HTML"); // ввнедрения HTML тегов
        editMessageText.setText(messageText + addTextInMessage); // изменение текста сообщения (добавление addTextInMessage)
        return editMessageText;
    }
}
