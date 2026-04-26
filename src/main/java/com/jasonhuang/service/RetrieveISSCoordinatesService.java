package com.jasonhuang.service;

import com.jasonhuang.model.ISSCoordinates;
import com.jasonhuang.model.ISSPosition;
import com.jasonhuang.service.impl.RetrieveISSCoordinatesServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RetrieveISSCoordinatesService implements RetrieveISSCoordinatesServiceImpl {
    private final String issURL;

    public RetrieveISSCoordinatesService(@Value("${issUrl}") String issURL) {
        this.issURL = issURL;
    }

    @Override
    public ISSPosition retrieveISSCoordinates() {
        WebClient client = WebClient.create();
        ISSCoordinates issCoordinates = client.get()
                .uri(issURL)
                .retrieve()
                .bodyToMono(ISSCoordinates.class)
                .block();

        ISSPosition iss_position = issCoordinates.getIss_position();

        return iss_position;
    }


}
