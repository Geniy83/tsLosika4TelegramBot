package by.nahodkin.tslosika4telegrambot.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class BotMainMenu extends KeyboardConstructor {

    public static InlineKeyboardMarkup sendMainMenu() {

        return createMarkup(createRow(createButton("Согласен", "Agree"),
                createButton("Выход", "Exit")));
    }
}