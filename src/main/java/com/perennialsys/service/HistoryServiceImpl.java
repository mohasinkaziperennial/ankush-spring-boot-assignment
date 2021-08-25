package com.perennialsys.service;

import com.perennialsys.entity.History;
import com.perennialsys.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService{
    @Autowired
    private HistoryRepository historyRepository;
    @Override
    public History save(History history) {
        return historyRepository.save(history);
    }

}
