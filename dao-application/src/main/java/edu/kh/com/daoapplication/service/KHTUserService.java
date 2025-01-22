package edu.kh.com.daoapplication.service;

import edu.kh.com.daoapplication.entity.KHTUser;
import edu.kh.com.daoapplication.repository.KHTUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class KHTUserService {

    @Autowired
    private KHTUserRepository khtUserRepository;

    @Value("${upload-img}")
    private String uploadImg;

    @Autowired //@Bean 이나 @Bean이 내장되어 있는 @Mapper @Repository @Controller @Service 등을 호출하는 기능
    private PasswordEncoder passwordEncoder; //SecurityConfig.java 내부에 작성되어 있는 기능 가져옴

    //모든 유저 조회 기능
    public List<KHTUser> findAll() {
        return khtUserRepository.findAll();
    }

//    //유저 저장하기
//    public KHTUser save(String username, String password, MultipartFile file) {
//        //        //khtUser.getPassword(0 = khtUser 유저에 저장하고자 사용자가 html 에서 작성한 비밀번호 가져오기
//        //passwordEncoder.encode(khtUser.getPassword()) = 가져온 비밀번호 암호화
//        //khtUser.setPassword() = 암호화된 비밀번호를 DB에 저장
//        System.out.println("html -> controller -> service로 가져온 비밀번호 확인: " + khtUser.getPassword());
//        String encodePassword = passwordEncoder.encode(khtUser.getPassword());
//        System.out.println("가져온 비밀번호 암호화 : " + passwordEncoder.encode(khtUser.getPassword()));
//
//
//        khtUser.setPassword(encodePassword);
//        khtUser.setPassword(passwordEncoder.encode(khtUser.getPassword()));
//        System.out.println(passwordEncoder.encode("암호화 완료된 비밀번호 확인 : " + khtUser.getPassword()));//위에서 저장한 암호 확인하기
//        return khtUserRepository.save(khtUser);


    public KHTUser save(String username, String password, MultipartFile file) {



        try {
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File saveFile = new File(uploadImg, filename);
            file.transferTo(saveFile);


            KHTUser khtUser = new KHTUser();
            khtUser.setUsername(username);
            khtUser.setPassword(password);
            khtUser.setImagePath("/images/" + filename);

            return khtUserRepository.save(khtUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //아이디를 활용해서 유저 상세보기
    public KHTUser findById(int id) {
        return khtUserRepository.findById(id);
    }

}

