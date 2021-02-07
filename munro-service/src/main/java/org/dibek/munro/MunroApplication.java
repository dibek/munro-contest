package org.dibek.munro;

import org.dibek.munro.domain.MunroInfo;
import org.dibek.munro.util.ParseCsv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@SpringBootApplication
public class MunroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MunroApplication.class, args);
	}




	@Bean
	ConcurrentMap<Long, MunroInfo> munroInfoMap() throws FileNotFoundException {
		List<MunroInfo> munroInfoList = ParseCsv.getMunroInfos("munrotab_v6_2.csv");
		return
				munroInfoList.stream().collect(Collectors.toConcurrentMap(MunroInfo::getRunningNo, item -> item));
	}
}
