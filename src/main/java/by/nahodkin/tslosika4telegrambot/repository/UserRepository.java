package by.nahodkin.tslosika4telegrambot.repository;

import by.nahodkin.tslosika4telegrambot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select area from User")
    List<Double> getAllByArea();

    @Query("select fio from User where id =:id")
    String getUserByFio(@Param("id") Integer id);

    @Modifying
    @Query("update User set status =:status where id =:id")
    void updateStatusByUser(@Param("id") Integer id, @Param("status") Integer status);

    @Query("select status from User where id =:id")
    String getStatusByUser(@Param("id") Integer id);

    @Query("select password from User where id =:id")
    String getPasswordByUser(@Param("id") Integer id);

    @Query("select area from User where id =:id")
    String getAreaByUser(@Param("id") Integer id);

    @Query("select share from User where id =:id")
    String getShareByUser(@Param("id") Integer id);

    @Query("select id from User where flat =:flat")
    Integer getIdByUser(@Param("flat") String flat);

    @Modifying
    @Query("update User set q11 =:q11 where id =:id")
    void updateQ11ByUser(@Param("id") Integer id, @Param("q11") Double q11);

    @Modifying
    @Query("update User set q12 =:q12 where id =:id")
    void updateQ12ByUser(@Param("id") Integer id, @Param("q12") Double q12);

    @Modifying
    @Query("update User set q13 =:q13 where id =:id")
    void updateQ13ByUser(@Param("id") Integer id, @Param("q13") Double q13);
}