package edu.kh.com.daoapplication.service;

import edu.kh.com.daoapplication.dao.KHTProduct;
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
}
