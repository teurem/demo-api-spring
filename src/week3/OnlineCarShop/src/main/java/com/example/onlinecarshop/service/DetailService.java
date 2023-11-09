package com.example.onlinecarshop.service;

import com.example.onlinecarshop.entity.DetailEntity;

public interface DetailService {
    DetailEntity getDetailById(Long detailId);
    void saveDetail(DetailEntity detail);
}
