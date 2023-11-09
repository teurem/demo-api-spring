package com.example.onlinecarshop.service;

import com.example.onlinecarshop.dto.DetailDTO;
import com.example.onlinecarshop.entity.DetailEntity;

public interface DetailService {
    DetailDTO getDetailById(Long detailId);
    void saveDetail(DetailEntity detail);
}
