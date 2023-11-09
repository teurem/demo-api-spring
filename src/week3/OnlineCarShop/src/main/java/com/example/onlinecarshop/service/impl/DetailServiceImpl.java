package com.example.onlinecarshop.service.impl;

import com.example.onlinecarshop.entity.DetailEntity;
import com.example.onlinecarshop.repository.DetailRepository;
import com.example.onlinecarshop.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailRepository detailRepository;

    @Override
    public DetailEntity getDetailById(Long detailId) {
        Optional<DetailEntity> detailOpt = detailRepository.findById(detailId);
        if (detailOpt.isPresent())
            return detailOpt.get();
        else
            throw new RuntimeException("detail not found");
    }

    @Override
    public void saveDetail(DetailEntity detail) {
        DetailEntity detailDet = detailRepository.save(detail);
        System.out.println("details saved to db with detailId" + detailDet.getId());
    }

}
