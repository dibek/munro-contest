package org.dibek.munro.util;

import com.opencsv.exceptions.CsvException;
import org.dibek.munro.domain.MunroInfo;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParseCsvTest {

    @Test
    public void getRawInfo() throws IOException, CsvException {

        List<String[]> listRawValues = ParseCsv.getRawValues("munrotab_v6_2.csv");
        assertNotNull(listRawValues);
    }

    @Test
    public void getMunroInfo() throws Exception {

        List<MunroInfo> munroInfoList =  ParseCsv.getMunroInfos("munrotab_v6_2.csv");
        assertNotNull(munroInfoList);
        assertTrue(munroInfoList.size()> 0);
        MunroInfo munroInfoFirst = munroInfoList.get(0);
        assertTrue(munroInfoFirst.getName().equals("Ben Chonzie"));
    }



}