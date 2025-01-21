package edu.kh.com.daoapplication.service;

import edu.kh.com.daoapplication.entity.KHTProduct;
import edu.kh.com.daoapplication.repository.KHTProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KHTProductService {

    @Autowired
    private KHTProductRepository khtProductRepository;

    //모든 제품 조회 기능
    public List<KHTProduct> findAll() {
        return khtProductRepository.findAll();
    }

    //제품 저장 기능
    public KHTProduct save(KHTProduct khtProduct) {
        return khtProductRepository.save(khtProduct);
    }

    //아이디를 활용해 제품 상세보기
   public KHTProduct findById(int id) {
        return khtProductRepository.findById(id);
   }
}
