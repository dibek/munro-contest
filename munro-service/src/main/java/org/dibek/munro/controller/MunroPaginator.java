package org.dibek.munro.controller;

import org.dibek.munro.domain.MunroInfo;

import java.util.List;

public class MunroPaginator {

    //TODO improve paginator add exceptions
    public final static List<MunroInfo> paginate(List<MunroInfo> munroInfoList,int size, int page){
        int pages = munroInfoList.size()/size;
        if (page > pages) {
            return munroInfoList;
        }
        int startWith = 0;
        if (page > 1) {
            startWith = page-- * size;
        }
        if (startWith + size >  munroInfoList.size()){
            return munroInfoList.subList(startWith,munroInfoList.size()-1);
        }
        return  munroInfoList.subList(startWith,size);
    }
}
