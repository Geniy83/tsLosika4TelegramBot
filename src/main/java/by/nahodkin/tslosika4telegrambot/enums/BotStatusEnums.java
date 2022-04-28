package by.nahodkin.tslosika4telegrambot.enums;

public enum BotStatusEnums {
    ASK_0, //Вход в TelegramBot User
    ASK_1, //Согласие на использование персональных данных
    ASK_2, //Введение номера квартиры (flat)
    ASK_3, //Введение password
    ASK_4, //Ответ на 1 выпрос голосования (q1.)
    ASK_5, //Ответ на 2 выпрос голосования (q2.)
    ASK_6, //Ответ на 3 выпрос голосования (q3.)
    END //Голосование прошло успешно
}
