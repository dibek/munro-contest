package org.dibek.munro.controller;

import org.dibek.munro.domain.MunroInfo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MunroInfoSorter {

    public final static List<MunroInfo>  sort(List<MunroInfo> munroInfoList, String field, String direction) {

        Comparator<MunroInfo> munroInfoComparator = getComparingHeightMetersAsc() ;

        switch (direction) {
            case "DESC":
                switch (field) {
                    case "heightMeter":
                        munroInfoComparator = getComparingHeightMetersDesc();
                        break;
                    case "name":
                    default:
                        munroInfoComparator = getComparingNameDesc();
                }
                break;
            case "ASC":
            default:
                switch (field) {
                    case "name":
                        munroInfoComparator = getComparingNameAsc();
                        break;
                    case "heightMeter":
                    default:
                        munroInfoComparator = getComparingHeightMetersAsc();
                }
        }
            return munroInfoList.stream()
                    .sorted(munroInfoComparator
                            )
                    .collect(Collectors.toList());

    }

    private static Comparator<MunroInfo> getComparingHeightMetersAsc() {
        return Comparator.comparing(MunroInfo::getHeightMeter);
    }

    private static Comparator<MunroInfo> getComparingHeightMetersDesc() {
        return Comparator.comparing(MunroInfo::getHeightMeter).reversed();
    }

    private static Comparator<MunroInfo> getComparingNameAsc() {
        return Comparator.comparing(MunroInfo::getName);
    }

    private static Comparator<MunroInfo> getComparingNameDesc() {
        return Comparator.comparing(MunroInfo::getName).reversed();
    }


}
