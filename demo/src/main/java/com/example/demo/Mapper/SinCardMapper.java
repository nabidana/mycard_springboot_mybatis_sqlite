package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Domain.CommonSearch;
import com.example.demo.Domain.SinCard;

@Mapper
public interface SinCardMapper {
    List<SinCard> selectSinCardLists(CommonSearch commonSearch);

    int getTotalPrice();

    int insertSinCard(SinCard sinCard);

    int delSincard(SinCard sinCard);

    List<String> getMonthList();

    SinCard getOneSinCard(int index);
}
