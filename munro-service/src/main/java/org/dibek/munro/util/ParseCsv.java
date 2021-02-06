package org.dibek.munro.util;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import org.dibek.munro.domain.MunroInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class ParseCsv {


    public static List<String[]> getRawValues(String fileName) throws IOException, CsvException {

        File file = ResourceUtils.getFile("classpath:" + fileName);
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            List<String[]> rawList = reader.readAll();
            return rawList;
        }

    }

    public static List<MunroInfo> getMunroInfos(String fileName) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:" + fileName);
        return new CsvToBeanBuilder(new FileReader(file))
                .withType(MunroInfo.class)
                .build()
                .parse();

    }
}
