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
        } else if(statusASK.equals(BotStatusEnums.ASK_7.toString())) {
            userService.updateQ41(idUser, q1);
            userService.updateQ42(idUser, q2);
            userService.updateQ43(idUser, q3);
        } else if(statusASK.equals(BotStatusEnums.ASK_8.toString())) {
            userService.updateQ51(idUser, q1);
            userService.updateQ52(idUser, q2);
            userService.updateQ53(idUser, q3);
        } else if(statusASK.equals(BotStatusEnums.ASK_9.toString())) {
            userService.updateQ61(idUser, q1);
            userService.updateQ62(idUser, q2);
            userService.updateQ63(idUser, q3);
        } else if(statusASK.equals(BotStatusEnums.ASK_10.toString())) {
            userService.updateQ71(idUser, q1);
            userService.updateQ72(idUser, q2);
            userService.updateQ73(idUser, q3);
        } else if(statusASK.equals(BotStatusEnums.ASK_11.toString())) {
            userService.updateQ81(idUser, q1);
            userService.updateQ82(idUser, q2);
            userService.updateQ83(idUser, q3);
        } else if(statusASK.equals(BotStatusEnums.ASK_12.toString())) {
            userService.updateQ91(idUser, q1);
            userService.updateQ92(idUser, q2);
            userService.updateQ93(idUser, q3);
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

        userService.updateQ41(idUser, "0");
        userService.updateQ42(idUser, "0");
        userService.updateQ43(idUser, "0");

        userService.updateQ51(idUser, "0");
        userService.updateQ52(idUser, "0");
        userService.updateQ53(idUser, "0");

        userService.updateQ61(idUser, "0");
        userService.updateQ62(idUser, "0");
        userService.updateQ63(idUser, "0");

        userService.updateQ71(idUser, "0");
        userService.updateQ72(idUser, "0");
        userService.updateQ73(idUser, "0");

        userService.updateQ81(idUser, "0");
        userService.updateQ82(idUser, "0");
        userService.updateQ83(idUser, "0");

        userService.updateQ91(idUser, "0");
        userService.updateQ92(idUser, "0");
        userService.updateQ93(idUser, "0");
    }
}
