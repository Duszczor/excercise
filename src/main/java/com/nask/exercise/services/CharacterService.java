package com.nask.exercise.services;

import com.nask.exercise.models.JsonValues;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CharacterService {

    private static final Integer SUBSTRING_URL = 29;
    private static final String API_URL = "https://swapi.dev/api/planets/";

    public void getAllJson(JsonValueService service) {
        List<JsonValues> listToPrint = service.getAll();
        if (listToPrint == null || listToPrint.isEmpty()) {
            //POBIERAMY WSZYSTKIE POSTACIE JAKO JSON
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(API_URL, String.class);
            JSONObject jsonObject = new JSONObject(response);

            //LISTA OBIEKTÓW
            JSONArray array = (JSONArray) jsonObject.get("results");

            for (int i = 0; i < array.length(); i++) {
                //ID JEST W URLU
                JSONObject urlObject = (JSONObject) array.get(i);
                String url = (String) urlObject.get("url");
                url = url.substring(SUBSTRING_URL);
                url = url.substring(0, url.length() - 1);
                Integer id = Integer.valueOf(url);

                //ZAPISUJEMY TO DO BAZY H2
                JsonValues jsonVal = new JsonValues();
                jsonVal.setId(id);
                jsonVal.setValue(urlObject.toString());
                service.save(jsonVal);

            }
        }
    }

}
