package com.jasonhuang.controller.impl;

import com.jasonhuang.model.LottoTypeEnum;
import com.jasonhuang.model.Result;


public interface MainControllerImpl {
    Result retrieveResult(LottoTypeEnum lottoTypeEnum);
}