package by.nahodkin.tslosika4telegrambot.bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Утилитный класс для создания кнопок, рядов и разметки.
 * Пример создания клавиатуры с двумя рядами кнопок:
 * --------------------------------------------------------------------------------------------------
 * InlineKeyboardButton firstButton = KeyboardConstructor.createButton("some text", "some callback");
 * InlineKeyboardButton secondButton = KeyboardConstructor.createButton("some text", "some callback");
 * InlineKeyboardButton thirdButton = KeyboardConstructor.createButton("some text", "some callback");
 * <p>
 * List<InlineKeyboardButton> firstRow = KeyboardConstructor.createRow(firstButton, secondButton);
 * List<InlineKeyboardButton secondRow = KeyboardConstructor.createRow(thirdButton);
 * <p>
 * InlineKeyboardMarkup markup = KeyboardConstructor.createMarkup(firstRow, secondRow);
 * --------------------------------------------------------------------------------------------------
 */

public class KeyboardConstructor {

    /**
     * Статический метод создания одной кнопки.
     * Принимает на вход параметры String buttonText, String callback.
     * buttonText - текст, который будет отображаться на кнопке.
     * callback - текст, который будет приходить в update после нажатия на кнопку.
     */
    public static InlineKeyboardButton createButton(String buttonText, String callback) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(buttonText);
        button.setCallbackData(callback);
        return button;
    }

    /**
     * Статический метод создания одного ряда кнопок.
     * Принимает на вход максимум три кнопки типа InlineKeyboardButton.
     */
    @SneakyThrows
    public static List<InlineKeyboardButton> createRow(InlineKeyboardButton... values) {
        if (values == null) {
            throw new Exception("Метод getRow не может быть с пустым параметром");
        } else if (values.length > 3) {
            throw new Exception("В метод getRow нельзя передавать больше 3-х кнопок");
        } else {
            List<InlineKeyboardButton> row = new ArrayList<>();
            row.addAll(Arrays.asList(values));
            return row;
        }
    }

    /**
     * Статический метод создания клавиатурной разметки.
     * Принимает на вход неограниченное кол-во рядов кнопок типа List<InlineKeyboardButton>.
     */
    @SneakyThrows
    public static InlineKeyboardMarkup createMarkup(List<InlineKeyboardButton>... values) {
        if (values == null) {
            throw new Exception("Метод createMarkup не может быть с пустыми параметрами");
        }
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.addAll(Arrays.asList(values));
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(buttons);
        return markup;
    }
}