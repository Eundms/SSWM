package com.ground.sswm.studyroom.repository;

import com.ground.sswm.studyroom.model.Studyroom;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyroomRepository extends JpaRepository<Studyroom, Long> {

    @Query("select s.id from Studyroom s")
    List<Long> findAllStudyRoomIds();

    @Query("select s from Studyroom s where s.name=:name and s.isDeleted = false and s.id in"
        + " (select us.studyroom.id from UserStudyroom us where us.isDeleted = false)")
    Optional<Studyroom> findByName(String name);

    @Query("select s from Studyroom s where s.isDeleted = false and s.id in"
        + " (select us.studyroom.id from UserStudyroom us where us.user.id = :userId and us.isDeleted = false)")
    List<Studyroom> findByUserId(@Param("userId") Long userId);

    @Query("select s from Studyroom s  where s.isDeleted = false"
        + " and s.name like %:searchKeyword%")
    List<Studyroom> list(@Param("searchKeyword") String searchKeyword);

    @Query("select s from Studyroom s  where s.isDeleted = false and s.isPublic = true"
        + " and s.name like %:searchKeyword%")
    List<Studyroom> listPublic(@Param("searchKeyword") String searchKeyword);

    @Query("select s from Studyroom s  where s.isDeleted = false"
        + " and s.id in"
        + " (select st.studyroom.id from StudyroomTag st where st.tag.id in"
        + " (select t.id from Tag t where t.name in :tagNames))"
        + " and s.name like %:searchKeyword%")
    List<Studyroom> listTag(@Param("tagNames") List<String> tagNames, @Param("searchKeyword") String searchKeyword);

    @Query("select s from Studyroom s  where s.isDeleted = false"
        + " and s.isPublic = true and s.id in"
        + " (select st.studyroom.id from StudyroomTag st where st.tag.id in"
        + " (select t.id from Tag t where t.name in :tagNames))"
        + " and (s.name like %:searchKeyword%)")
    List<Studyroom> listTagPublic(@Param("tagNames") List<String> tagNames,
        @Param("searchKeyword") String searchKeyword);

    Studyroom findByIdAndEnterCode(Long id, String enterCode);
}
