package com.perennialsys.service;

import com.perennialsys.entity.HoldRequest;
import com.perennialsys.repository.HoldRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoldRequestServiceImpl implements HoldRequestService{
    @Autowired
    private HoldRequestRepository holdRequestRepository;
    @Override
    public HoldRequest save(HoldRequest holdRequest) {

        return holdRequestRepository.save(holdRequest);
    }
}
