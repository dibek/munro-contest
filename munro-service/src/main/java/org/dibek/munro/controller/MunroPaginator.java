package org.dibek.munro.controller;

import org.dibek.munro.domain.MunroInfo;

import java.util.List;

public class MunroPaginator {

    public final static List<MunroInfo> paginate(List<MunroInfo> munroInfoList,int size, int page){
        int pages = munroInfoList.size()/size;
        if (page > pages) {
            return munroInfoList;
        }
        int startWith = 0;
        if (page > 1) {
            startWith = page-- * size;
        }
        return  munroInfoList.subList(startWith,size);
    }
}
