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
    // ------------------------- Вопрос 4
    @Modifying
    @Query("update User set q41 =:q41 where id =:id")
    void updateQ41ByUser(@Param("id") Integer id, @Param("q41") String q41);
    @Modifying
    @Query("update User set q42 =:q42 where id =:id")
    void updateQ42ByUser(@Param("id") Integer id, @Param("q42") String q42);
    @Modifying
    @Query("update User set q43 =:q43 where id =:id")
    void updateQ43ByUser(@Param("id") Integer id, @Param("q43") String q43);
    // ------------------------- Вопрос 5
    @Modifying
    @Query("update User set q51 =:q51 where id =:id")
    void updateQ51ByUser(@Param("id") Integer id, @Param("q51") String q51);
    @Modifying
    @Query("update User set q52 =:q52 where id =:id")
    void updateQ52ByUser(@Param("id") Integer id, @Param("q52") String q52);
    @Modifying
    @Query("update User set q53 =:q53 where id =:id")
    void updateQ53ByUser(@Param("id") Integer id, @Param("q53") String q53);
    // ------------------------- Вопрос 6
    @Modifying
    @Query("update User set q61 =:q61 where id =:id")
    void updateQ61ByUser(@Param("id") Integer id, @Param("q61") String q61);
    @Modifying
    @Query("update User set q62 =:q62 where id =:id")
    void updateQ62ByUser(@Param("id") Integer id, @Param("q62") String q62);
    @Modifying
    @Query("update User set q63 =:q63 where id =:id")
    void updateQ63ByUser(@Param("id") Integer id, @Param("q63") String q63);
    // ------------------------- Вопрос 7
    @Modifying
    @Query("update User set q71 =:q71 where id =:id")
    void updateQ71ByUser(@Param("id") Integer id, @Param("q71") String q71);
    @Modifying
    @Query("update User set q72 =:q72 where id =:id")
    void updateQ72ByUser(@Param("id") Integer id, @Param("q72") String q72);
    @Modifying
    @Query("update User set q73 =:q73 where id =:id")
    void updateQ73ByUser(@Param("id") Integer id, @Param("q73") String q73);
    // ------------------------- Вопрос 8
    @Modifying
    @Query("update User set q81 =:q81 where id =:id")
    void updateQ81ByUser(@Param("id") Integer id, @Param("q81") String q81);
    @Modifying
    @Query("update User set q82 =:q82 where id =:id")
    void updateQ82ByUser(@Param("id") Integer id, @Param("q82") String q82);
    @Modifying
    @Query("update User set q83 =:q83 where id =:id")
    void updateQ83ByUser(@Param("id") Integer id, @Param("q83") String q83);
    // ------------------------- Вопрос 9
    @Modifying
    @Query("update User set q91 =:q91 where id =:id")
    void updateQ91ByUser(@Param("id") Integer id, @Param("q91") String q91);
    @Modifying
    @Query("update User set q92 =:q92 where id =:id")
    void updateQ92ByUser(@Param("id") Integer id, @Param("q92") String q92);
    @Modifying
    @Query("update User set q93 =:q93 where id =:id")
    void updateQ93ByUser(@Param("id") Integer id, @Param("q93") String q93);
}