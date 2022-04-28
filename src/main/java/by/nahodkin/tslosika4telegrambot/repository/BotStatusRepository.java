package by.nahodkin.tslosika4telegrambot.repository;

import by.nahodkin.tslosika4telegrambot.entity.BotStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BotStatusRepository extends JpaRepository<BotStatus, String> {

    @Query("select status from BotStatus where chat_id =:chat_id")
    String getBotStatusByChat_id(@Param("chat_id") String chat_id);

    @Modifying
    @Query("delete from BotStatus where chat_id =:chat_id")
    void deleteBotStatusByChat_id(@Param("chat_id") String chat_id);

    @Modifying
    @Query("update BotStatus set status =:status where chat_id =:chat_id")
    void updateBotStatusByChat_id(@Param("chat_id") String chat_id, @Param("status") String status);

    @Modifying
    @Query("update BotStatus set room =:room where chat_id =:chat_id")
    void updateBotRoomByChat_id(@Param("chat_id") String chat_id, @Param("room") String room);

    @Query("select room from BotStatus where chat_id =:chat_id")
    String getBotRoomByChat_id(@Param("chat_id") String chat_id);
}