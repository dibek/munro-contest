package org.dibek.munro.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.net.SocketFlow;
import netscape.javascript.JSObject;
import org.dibek.munro.domain.MunroInfo;
import org.dibek.munro.service.MunroService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MunroController extends BaseController {

    private final MunroService munroService;

    public MunroController(MunroService munroService) {
        this.munroService = munroService;
    }

    @GetMapping("/munros")
    public ResponseEntity<Object> getListMunro(
            @RequestParam(value = "minHeight", required = false) Double minHeight,
            @RequestParam(value = "maxHeight", required = false) Double maxHeight,
             @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "direction", required = false) String direction
    ) {
        MunroInfo.MunroInfoBuilder builder = MunroInfo.MunroInfoBuilder.aMunroInfo();
        if (minHeight != null) {
            builder.withMinHeight(new BigDecimal(minHeight));
        }
        if (maxHeight != null) {
            builder.withMaxHeight(new BigDecimal(maxHeight));
        }
        if (category != null) {
            builder.withCategory(category);
        }
        Optional<List<MunroInfo>> optionalMunroInfos = munroService.filterByEntity(
                builder.build()
        );
        HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<Object> responseEntity;
        if (optionalMunroInfos.isEmpty()) {
            responseEntity = new ResponseEntity<Object>(responseHeaders, HttpStatus.OK);
        } else {
            responseHeaders.add("X-Total-Count", Long.toString(optionalMunroInfos.get().size()));
            List<MunroInfo> munroInfoList = MunroInfoSorter.sort(optionalMunroInfos.get(),(sort != null? sort:"heightMeter"), (direction != null? direction:"ASC"));
            munroInfoList = MunroPaginator.paginate(munroInfoList,10,1);
            responseEntity = new ResponseEntity<Object>(munroInfoList,responseHeaders,HttpStatus.OK);
        }
        return responseEntity;
    }


}
