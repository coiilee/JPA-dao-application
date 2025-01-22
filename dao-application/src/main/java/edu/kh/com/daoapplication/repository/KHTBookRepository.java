package edu.kh.com.daoapplication.repository;

import edu.kh.com.daoapplication.entity.KHTBook;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public interface KHTBookRepository extends JpaRepository<KHTBook, Long> {

    //findAll
    //save
    // -> 기존에 JPA에서 만들었던 save 메서드를 변형해서 재설정
//    KHTBook save(String title, String author, String genre, String imagePath);

    @Select("SELECT * FROM KHTBOOK WHERE id = #{id}")
    //from 테이블명         findBy = where 명칭 where 이름
    KHTBook findById(long id); //findBy = WHERE 절과 동일

//    //아이디와 이름으로 비밀번호찾기
//    @Select("SELECT password FROM KHTBOOK WHERE id = #{id} AND name= #{name}")
//    String findPasswordByIdAndName(int id, String name);
}
