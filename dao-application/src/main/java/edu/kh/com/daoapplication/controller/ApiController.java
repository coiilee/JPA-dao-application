package edu.kh.com.daoapplication.controller;

import edu.kh.com.daoapplication.entity.KHTBook;
import edu.kh.com.daoapplication.entity.KHTProduct;
import edu.kh.com.daoapplication.entity.KHTUser;
import edu.kh.com.daoapplication.service.KHTBookService;
import edu.kh.com.daoapplication.service.KHTProductService;
import edu.kh.com.daoapplication.service.KHTUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api") //맨 앞에 공통으로 들어갈 url api 명칭 작성해주는 어노테이션
public class ApiController {

    @Autowired
    private KHTUserService khtUserService;
    @Autowired
    private KHTProductService khtProductService;
    @Autowired
    private KHTBookService khtBookService;

    // ajax url을 이용해서 DB에 저장된 DB 불러오기
    @GetMapping("/users")
    public List<KHTUser> findAll() {
        List<KHTUser> users = khtUserService.findAll();
        log.info(users.toString());
        return users;
    }

    //ajax url을 이용해서 DB에 회원 저장하기
    @PostMapping("/saveUser")
    public KHTUser saveUser(@RequestBody KHTUser khtUser) {
        return khtUserService.save(khtUser);
    }

    //모든 제품 조회:  /api/products
    @GetMapping("/products")
    public List<KHTProduct> getAllProducts() {
        List<KHTProduct> products = khtProductService.findAll();
        log.info(products.toString());
        return products;
    }

    //제품등록 : /api/saveProduct
    @PostMapping("/saveProduct")
    public KHTProduct saveProduct(@RequestBody KHTProduct khtProduct) {
        KHTProduct savedProduct = khtProductService.save(khtProduct);
        log.info(savedProduct.toString());
        return savedProduct;
    }

    /**
     *
     * @RequestParam은 get('id')으로 전달받은 id값을 활용해서 ajax로 db에서 id값에 해당하는 데이터를 가져오기
     *
     * URLSearchParams = URL 주소에서 parameters(파라미터들)을 SEARCH 검색해서
     *               const urlParam = new URLSearchParams(window.location.search);
     *               const id = urlParam.get('id');
     * urlParam 이라는 변수 이름에 ? 뒤에 오는 키=값을 모두 담아둠
     * urlParam에서 원하는 키의 값을 get 해서 가져옴
     *
     * @param id 는 @RequestParam get('id')으로 전달받은 id값
     * id라는 변수 이름에 키에 해당하는 값을 저장
     *
     * @return
     */

    @GetMapping("/user/{id}")
    public KHTUser findByIdUser(@PathVariable("id")int id) {
        KHTUser khtUser = khtUserService.findById(id);
        log.info(khtUser.toString());
        return khtUserService.findById(id); //가져온 데이터가 있든 없든 html에 전달
    }

    @GetMapping("/products/{id}")
    public KHTProduct findByIdProduct(@PathVariable("id") int id){
        KHTProduct khtProduct = khtProductService.findById(id);
        log.info(khtProduct.toString());
        return khtProduct;
    }

    /// 📚 모든 책 조회 API
    @GetMapping("/books")
    public List<KHTBook> apiBooks() {
        // Book 목록 JSON 응답
        List<KHTBook> books = khtBookService.findAll();
        log.info(books.toString());
        return books;
    }

    // 📖 특정 책 조회 API
    @GetMapping("/book/{id}")
    public KHTBook apiBook(@PathVariable("id") long id) {
        KHTBook khtBook = khtBookService.findById(id);
        log.info(khtBook.toString());
        return khtBook;
    }

    // 📝 책 저장 API
    @PostMapping("/bookSave")
    public KHTBook apiSaveBook(@RequestBody KHTBook khtBook) {
        KHTBook saveBook = khtBookService.save(khtBook);
        log.info(saveBook.toString());
        return saveBook;
    }
}
