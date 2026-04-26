package com.jasonhuang.service;

import com.jasonhuang.model.ISSPosition;
import com.jasonhuang.model.LottoTypeEnum;
import com.jasonhuang.model.Result;
import com.jasonhuang.service.impl.RandomGeneratorServiceImpl;
import com.jasonhuang.service.impl.RetrieveISSCoordinatesServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomGeneratorService implements RandomGeneratorServiceImpl {
    private final RetrieveISSCoordinatesServiceImpl retrieveISSCoordinatesService;

    public RandomGeneratorService(RetrieveISSCoordinatesServiceImpl retrieveISSCoordinatesService) {
        this.retrieveISSCoordinatesService = retrieveISSCoordinatesService;
    }

    @Override
    public Result generateRandomNumbers(LottoTypeEnum lottoTypeEnum) {
        int seed = generateSeed();
        List<Integer> generatedNumbersList = generate(seed, lottoTypeEnum);
        return new Result(generatedNumbersList);
    }

    private int convertStringValueToInt(String value) {
        BigDecimal bd = BigDecimal.valueOf(Math.abs(Double.parseDouble(value)));
        String digitsOnly = bd.toPlainString().replace(".", "");

        return Integer.parseInt(digitsOnly);
    }

    private int generateSeed() {
        ISSPosition issPosition = retrieveISSCoordinatesService.retrieveISSCoordinates();
        return convertStringValueToInt(issPosition.longitude) + convertStringValueToInt(issPosition.latitude);
    }

    private List<Integer> generate(int seed,
                                   LottoTypeEnum lottoTypeEnum) {
        List<Integer> result = new ArrayList<>();
        Random rand = new Random(seed);
        if (lottoTypeEnum == LottoTypeEnum.LOTTOMAX) {
            int LOTTO_MAX_NUMBERS = 7;
            for (int i = 0; i < LOTTO_MAX_NUMBERS; i++) {
                result.add(generateSingleNumber(rand));
            }
        } else if (lottoTypeEnum == LottoTypeEnum.SIXFOURTYNINE) {
            int SIX_FOURTY_NINE_NUMBERS = 6;
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