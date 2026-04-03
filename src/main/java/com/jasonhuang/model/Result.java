package com.jasonhuang.model;

import java.util.List;
import java.util.UUID;

public class Result {
    private UUID uuid;
    private List<Integer> numbers;

    public Result(UUID uuid, List<Integer> numbers) {
        this.uuid = uuid;
        this.numbers = numbers;
    }

    public UUID getUuid() {
        return uuid;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}