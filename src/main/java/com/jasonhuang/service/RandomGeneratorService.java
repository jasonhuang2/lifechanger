package com.jasonhuang.service;

import com.jasonhuang.model.LottoTypeEnum;
import com.jasonhuang.model.Result;
import com.jasonhuang.service.impl.RandomGeneratorServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGeneratorService implements RandomGeneratorServiceImpl {
    private final int SIX_FOURTY_NINE_NUMBERS = 6;
    private final int LOTTO_MAX_NUMBERS = 7;

    @Override
    public Result generateRandomNumbers(int seed, LottoTypeEnum lottoTypeEnum) {
        List<Integer> generatedNumbersList = generate(seed, lottoTypeEnum);
        return new Result(generatedNumbersList);
    }

    private List<Integer> generate(int seed,
                                   LottoTypeEnum lottoTypeEnum) {
        List<Integer> result = new ArrayList<>();
        Random rand = new Random(seed);
        if (lottoTypeEnum == LottoTypeEnum.LOTTOMAX) {
            for (int i = 0; i < LOTTO_MAX_NUMBERS; i++) {
                result.add(generateSingleNumber(rand));
            }
        } else if (lottoTypeEnum == LottoTypeEnum.SIXFOURTYNINE) {
            for (int i = 0; i < SIX_FOURTY_NINE_NUMBERS; i++) {
                result.add(generateSingleNumber(rand));
            }
        }

        return result;
    }

    private int generateSingleNumber(Random rand) {
        return rand.nextInt(50) + 1;
    }
}