package com.wetech.core.service;

import com.wetech.core.common.ApiException;
import com.wetech.ryutsumodel.model.dto.Micacoma012InputDto;
import com.wetech.ryutsumodel.model.dto.Micacoma012OutputDto;

import java.text.ParseException;
import java.util.List;

public interface Micacoma012Servie {
    //処理状況検索
    Micacoma012OutputDto syoriJyokyoSearch(Micacoma012InputDto micacoma012InputDto, List<String> role) throws ApiException,ParseException;
}
