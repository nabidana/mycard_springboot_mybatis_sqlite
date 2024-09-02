package com.example.demo.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.CommonSearch;
import com.example.demo.Domain.SinCard;
import com.example.demo.Mapper.SinCardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SinCardService {

    @Autowired
    private SinCardMapper mapper;
    
    public List<SinCard> getSincardList(CommonSearch commonSearch){
        return mapper.selectSinCardLists(commonSearch);
    }

    public int getTotalPrice() {
        return mapper.getTotalPrice();
    }

    public int addSinCard(SinCard sinCard) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(now);
        sinCard.setInday(today);
        sinCard.setCard_stat("0");
        return mapper.insertSinCard(sinCard);
    }

    public int delsincard(SinCard sinCard) {
        return mapper.delSincard(sinCard);
    }

    public List<String> getMonthList() {
        return mapper.getMonthList();
    }
}
