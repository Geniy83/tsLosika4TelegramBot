package by.nahodkin.tslosika4telegrambot.service;

import by.nahodkin.tslosika4telegrambot.entity.BotStatus;
import by.nahodkin.tslosika4telegrambot.repository.BotStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BotStatusService {

    @Autowired
    private BotStatusRepository repository;

    public String getBotStatusByChat_id(String chat_id) {
        return repository.getBotStatusByChat_id(chat_id);
    }

    public void deleteBotStatusByChat_id(String chat_id) {
        repository.deleteBotStatusByChat_id(chat_id);
    }

    public void saveBotStatus(BotStatus botStatus) {
        repository.save(botStatus);
    }

    public void updateBotStatus(String chat_id, String status) {
        repository.updateBotStatusByChat_id(chat_id, status);
    }

    public void updateBotRoom(String chat_id, String room) {
        repository.updateBotRoomByChat_id(chat_id, room);
    }

    public void updateBotDate(String chat_id, String date) {
        repository.updateBotDateByChat_id(chat_id, date);
    }

    public String getBotRoomByChat_id(String chat_id) {
        return repository.getBotRoomByChat_id(chat_id);
    }
}