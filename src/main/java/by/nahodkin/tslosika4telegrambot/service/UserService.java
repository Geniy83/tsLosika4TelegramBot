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

    public void saveUser(User user) {
        userRepository.save(user);
    }

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

    public void updateUserStatus(Integer id, Integer status) {
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

    public void updateQ11(Integer id, Double q11) {
        userRepository.updateQ11ByUser(id, q11);
    }

    public void updateQ12(Integer id, Double q12) {
        userRepository.updateQ12ByUser(id, q12);
    }

    public void updateQ13(Integer id, Double q13) {
        userRepository.updateQ13ByUser(id, q13);
    }
}