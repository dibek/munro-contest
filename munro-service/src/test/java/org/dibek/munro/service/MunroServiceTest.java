package org.dibek.munro.service;

import org.dibek.munro.MunroApplication;
import org.dibek.munro.domain.MunroInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { MunroApplication.class })
class MunroServiceTest {

    @Autowired
    MunroService munroService;

    @Test
    public void getMunroInfoById() {
        assertTrue(munroService.getMunroInfoById(1l).isPresent());
    }

    @Test
    public void getMunroListByCategoryMunro() {
        MunroInfo munroInfo = MunroInfo.MunroInfoBuilder.aMunroInfo()
                .withCategory("MUN")
                .build();
        List<MunroInfo> results = munroService.filterByEntity(munroInfo).get();
        assertTrue(results.size()> 0);
        assertEquals(263,results.size());
    }

    @Test
    public void getMunroListByCategoryTop() {
        MunroInfo munroInfo = MunroInfo.MunroInfoBuilder.aMunroInfo()
                .withCategory("TOP")
                .build();
        List<MunroInfo> results = munroService.filterByEntity(munroInfo).get();
        assertTrue(results.size()> 0);
        assertEquals(339,results.size());
    }

    @Test
    public void getMunroListByCategoryNull() {
        MunroInfo munroInfo = MunroInfo.MunroInfoBuilder.aMunroInfo()
                .withCategory("")
                .build();
        List<MunroInfo> results = munroService.filterByEntity(munroInfo).get();
        assertTrue(results.size()> 0);
    }

    @Test
    public void getMunroListByMinimumHeight() {
        MunroInfo munroInfo = MunroInfo.MunroInfoBuilder.aMunroInfo()
                .withMinHeight(new BigDecimal(2000))
                .build();
        List<MunroInfo> results = munroService.filterByEntity(munroInfo).get();
        assertTrue(results.size() == 0);
        assertEquals(0,results.size());
    }

    @Test
    public void getMunroListByMinimumHeight1300() {
        MunroInfo munroInfo = MunroInfo.MunroInfoBuilder.aMunroInfo()
                .withMinHeight(new BigDecimal(1300))
                .build();
        List<MunroInfo> results = munroService.filterByEntity(munroInfo).get();
        assertTrue(results.size() > 0);
        assertEquals(2,results.size());
    }

    @Test
    public void getMunroListByMinimumHeight800Max900() {
        MunroInfo munroInfo = MunroInfo.MunroInfoBuilder.aMunroInfo()
                .withMinHeight(new BigDecimal(900))
                .withMaxHeight(new BigDecimal(1000))
                .build();
        List<MunroInfo> results = munroService.filterByEntity(munroInfo).get();
        assertTrue(results.size() > 0);
        assertEquals(340,results.size());
    }
}