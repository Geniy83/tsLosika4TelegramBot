package by.nahodkin.tslosika4telegrambot.saveAnswers;

import by.nahodkin.tslosika4telegrambot.enums.BotStatusEnums;
import by.nahodkin.tslosika4telegrambot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveAnswers {
    @Autowired
    private UserService userService;

    public void saveAnswer(Integer idUser, String statusASK, String q1, String q2, String q3) {
        if(statusASK.equals(BotStatusEnums.ASK_4.toString())) {
            userService.updateQ11(idUser, q1);
            userService.updateQ12(idUser, q2);
            userService.updateQ13(idUser, q3);
        } else if(statusASK.equals(BotStatusEnums.ASK_5.toString())) {
            userService.updateQ21(idUser, q1);
            userService.updateQ22(idUser, q2);
            userService.updateQ23(idUser, q3);
        } else if(statusASK.equals(BotStatusEnums.ASK_6.toString())) {
            userService.updateQ31(idUser, q1);
            userService.updateQ32(idUser, q2);
            userService.updateQ33(idUser, q3);
        }
    }

    public void deleteAnswer(Integer idUser) {
        userService.updateQ11(idUser, "0");
        userService.updateQ12(idUser, "0");
        userService.updateQ13(idUser, "0");
        userService.updateQ21(idUser, "0");
        userService.updateQ22(idUser, "0");
        userService.updateQ23(idUser, "0");
        userService.updateQ31(idUser, "0");
        userService.updateQ32(idUser, "0");
        userService.updateQ33(idUser, "0");
    }
}
