package com.example.onlinecarshop.service.impl;

import com.example.onlinecarshop.dto.DetailDTO;
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

    private DetailDTO convertingEntityToDto(DetailEntity detail) {
        DetailDTO detailDTO = new DetailDTO();
        detailDTO.setAmount(detail.getAmount());
        detailDTO.setPrice_for_one(detail.getPrice_for_one());
        return detailDTO;
    }

    @Override
    public DetailDTO getDetailById(Long detailId) {
        return detailRepository.findById(detailId)
                .map(this::convertingEntityToDto)
                .orElseThrow(() -> new RuntimeException("detail not found"));
    }

//    @Override
//    public DetailEntity getDetailById(Long detailId) {
//        Optional<DetailEntity> detailOpt = detailRepository.findById(detailId);
//        if (detailOpt.isPresent())
//            return detailOpt.get();
//        else
//            throw new RuntimeException("detail not found");
//    }

    @Override
    public void saveDetail(DetailEntity detail) {
        DetailEntity detailDet = detailRepository.save(detail);
        System.out.println("details saved to db with detailId" + detailDet.getId());
    }

}
