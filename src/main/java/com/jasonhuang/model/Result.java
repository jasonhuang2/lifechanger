package com.jasonhuang.model;

import java.util.List;
import java.util.UUID;

public class Result {
    private UUID uuid = UUID.randomUUID();
    private List<Integer> numbers;

    public Result() {
        numbers = List.of();
    }

    public Result(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public UUID getUuid() {
        return uuid;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}