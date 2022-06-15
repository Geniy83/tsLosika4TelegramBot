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
    List<String> getAllByArea();

    @Query("select share from User")
    List<String> getAllByShare();

    @Query("select share from User where status =:status")
    List<String> getAllByShareTrue(@Param("status") String status);

    @Query("select q11 from User where status =:status")
    List<String> getAllByQ11(@Param("status") String status);

    @Query("select status from User where status =:status")
    List<String> getAllByStatusTrue(@Param("status") String status);

    @Query("select fio from User where id =:id")
    String getUserByFio(@Param("id") Integer id);

    @Modifying
    @Query("update User set status =:status where id =:id")
    void updateStatusByUser(@Param("id") Integer id, @Param("status") String status);

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

    // ------------------------- Вопрос 1
    @Modifying
    @Query("update User set q11 =:q11 where id =:id")
    void updateQ11ByUser(@Param("id") Integer id, @Param("q11") String q11);
    @Modifying
    @Query("update User set q12 =:q12 where id =:id")
    void updateQ12ByUser(@Param("id") Integer id, @Param("q12") String q12);
    @Modifying
    @Query("update User set q13 =:q13 where id =:id")
    void updateQ13ByUser(@Param("id") Integer id, @Param("q13") String q13);
    // ------------------------- Вопрос 2
    @Modifying
    @Query("update User set q21 =:q21 where id =:id")
    void updateQ21ByUser(@Param("id") Integer id, @Param("q21") String q21);
    @Modifying
    @Query("update User set q22 =:q22 where id =:id")
    void updateQ22ByUser(@Param("id") Integer id, @Param("q22") String q22);
    @Modifying
    @Query("update User set q23 =:q23 where id =:id")
    void updateQ23ByUser(@Param("id") Integer id, @Param("q23") String q23);
    // ------------------------- Вопрос 3
    @Modifying
    @Query("update User set q31 =:q31 where id =:id")
    void updateQ31ByUser(@Param("id") Integer id, @Param("q31") String q31);
    @Modifying
    @Query("update User set q32 =:q32 where id =:id")
    void updateQ32ByUser(@Param("id") Integer id, @Param("q32") String q32);
    @Modifying
    @Query("update User set q33 =:q33 where id =:id")
    void updateQ33ByUser(@Param("id") Integer id, @Param("q33") String q33);
}