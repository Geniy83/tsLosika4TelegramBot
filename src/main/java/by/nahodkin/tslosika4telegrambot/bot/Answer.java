package by.nahodkin.tslosika4telegrambot.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class Answer extends KeyboardConstructor {
    public static InlineKeyboardMarkup sendMenu() {

        return createMarkup(
                KeyboardConstructor.createRow(KeyboardConstructor.createButton("За", "Per"),
                        KeyboardConstructor.createButton("Против", "Against"),
                        KeyboardConstructor.createButton("Воздержался", "Abstained")));
    }
}