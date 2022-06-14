package by.nahodkin.tslosika4telegrambot.service;

import by.nahodkin.tslosika4telegrambot.entity.User;
import by.nahodkin.tslosika4telegrambot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Double getAllByArea() {
        List<Double> area = userRepository.getAllByArea();
        return area.stream().mapToDouble((s)->s).sum();
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
}