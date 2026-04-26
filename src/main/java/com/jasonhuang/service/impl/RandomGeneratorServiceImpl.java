package com.jasonhuang.service.impl;

import com.jasonhuang.model.LottoTypeEnum;
import com.jasonhuang.model.Result;

public interface RandomGeneratorServiceImpl {
    Result generateRandomNumbers(LottoTypeEnum lottoTypeEnum);
}