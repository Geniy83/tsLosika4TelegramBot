package by.nahodkin.tslosika4telegrambot.service;

import by.nahodkin.tslosika4telegrambot.entity.User;
import by.nahodkin.tslosika4telegrambot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends NullPointerException {

    @Autowired
    private UserRepository userRepository;

    public Double getAllByShareTrue(String status) {
        List<String> shareTrue = userRepository.getAllByShareTrue(status);
        return shareTrue.stream().mapToDouble(Double::valueOf).sum();
    }

    public Integer getAllByStatusTrue(String status) {
        List<String> statusTrue = userRepository.getAllByStatusTrue(status);
        return statusTrue.stream().mapToInt(Integer::valueOf).sum();
    }

    public String getFio(Integer id) {
        return userRepository.getUserByFio(id);
    }

    public Integer getIdUserFlat(String flat) {
        return userRepository.getIdByUser(flat);
    }

    public void updateUserStatus(Integer id, String status) {
        userRepository.updateStatusByUser(id, status);
    }

    public String getStatusUser(Integer id) {
        return userRepository.getStatusByUser(id);
    }

    public String getPassword(Integer id) {
        return userRepository.getPasswordByUser(id);
    }

    public String getShare(Integer id) {
        return userRepository.getShareByUser(id);
    }

    public String getArea(Integer id) {
        return userRepository.getAreaByUser(id);
    }

    public void updateQ11(Integer id, String q11) {
        userRepository.updateQ11ByUser(id, q11);
    }
    public void updateQ12(Integer id, String q12) {
        userRepository.updateQ12ByUser(id, q12);
    }
    public void updateQ13(Integer id, String q13) {
        userRepository.updateQ13ByUser(id, q13);
    }

    public void updateQ21(Integer id, String q21) {
        userRepository.updateQ21ByUser(id, q21);
    }
    public void updateQ22(Integer id, String q22) {
        userRepository.updateQ22ByUser(id, q22);
    }
    public void updateQ23(Integer id, String q23) {
        userRepository.updateQ23ByUser(id, q23);
    }

    public void updateQ31(Integer id, String q31) {
        userRepository.updateQ31ByUser(id, q31);
    }
    public void updateQ32(Integer id, String q32) {
        userRepository.updateQ32ByUser(id, q32);
    }
    public void updateQ33(Integer id, String q33) {
        userRepository.updateQ33ByUser(id, q33);
    }

    public void updateQ41(Integer id, String q41) {
        userRepository.updateQ41ByUser(id, q41);
    }
    public void updateQ42(Integer id, String q42) {
        userRepository.updateQ42ByUser(id, q42);
    }
    public void updateQ43(Integer id, String q43) {
        userRepository.updateQ43ByUser(id, q43);
    }

    public void updateQ51(Integer id, String q51) {
        userRepository.updateQ51ByUser(id, q51);
    }
    public void updateQ52(Integer id, String q52) {
        userRepository.updateQ52ByUser(id, q52);
    }
    public void updateQ53(Integer id, String q53) {
        userRepository.updateQ53ByUser(id, q53);
    }

    public void updateQ61(Integer id, String q61) {
        userRepository.updateQ61ByUser(id, q61);
    }
    public void updateQ62(Integer id, String q62) {
        userRepository.updateQ62ByUser(id, q62);
    }
    public void updateQ63(Integer id, String q63) {
        userRepository.updateQ63ByUser(id, q63);
    }

    public void updateQ71(Integer id, String q71) {
        userRepository.updateQ71ByUser(id, q71);
    }
    public void updateQ72(Integer id, String q72) {
        userRepository.updateQ72ByUser(id, q72);
    }
    public void updateQ73(Integer id, String q73) {
        userRepository.updateQ73ByUser(id, q73);
    }

    public void updateQ81(Integer id, String q81) {
        userRepository.updateQ81ByUser(id, q81);
    }
    public void updateQ82(Integer id, String q82) {
        userRepository.updateQ82ByUser(id, q82);
    }
    public void updateQ83(Integer id, String q83) {
        userRepository.updateQ83ByUser(id, q83);
    }

    public void updateQ91(Integer id, String q91) {
        userRepository.updateQ91ByUser(id, q91);
    }
    public void updateQ92(Integer id, String q92) {
        userRepository.updateQ92ByUser(id, q92);
    }
    public void updateQ93(Integer id, String q93) {
        userRepository.updateQ93ByUser(id, q93);
    }
}