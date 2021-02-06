package org.dibek.munro.service;

import org.dibek.munro.domain.MunroInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class MunroService {

    private final ConcurrentMap<Long, MunroInfo> munroInfoConcurrentMap;

    public MunroService(ConcurrentMap<Long, MunroInfo> munroInfoConcurrentMap) {
        this.munroInfoConcurrentMap = munroInfoConcurrentMap;
    }

    public Optional<MunroInfo> getMunroInfoById(Long runningNo) {
        return Optional.ofNullable(munroInfoConcurrentMap.get(runningNo));
    }

    public Optional<List<MunroInfo>> filterByEntity(MunroInfo munroInfo) {
        List<MunroInfo> filteredList = new ArrayList<>();
        filteredList.addAll(extractByCategory(munroInfo));
        filteredList = filterByMinimumHeight(filteredList,munroInfo);
        filteredList = filterByMaximumHeight(filteredList,munroInfo);
        return Optional.of(filteredList);
    }

    private List<MunroInfo> extractByCategory(MunroInfo munroInfo) {
        return munroInfoConcurrentMap.values().stream().
                filter(item -> item.getCategory().contains(munroInfo.getCategory()) ||
                munroInfo.getCategory().contains("null"))
                .collect(Collectors.toList());
    }

    private List<MunroInfo> filterByMinimumHeight(List<MunroInfo> munroInfoList, MunroInfo munroInfo) {
        return munroInfoList.stream().
                filter(item -> munroInfo.getMinimumHeight() == null ||
                                item.getHeightMeter().compareTo(munroInfo.getMinimumHeight()) > 0
                        )
                .collect(Collectors.toList());
    }

    private List<MunroInfo> filterByMaximumHeight(List<MunroInfo> munroInfoList, MunroInfo munroInfo) {
        return munroInfoList.stream().
                filter(item -> munroInfo.getMaximumHeight() == null ||
                                item.getHeightMeter().compareTo(munroInfo.getMaximumHeight()) < 0
                        )
                .collect(Collectors.toList());
    }


}
