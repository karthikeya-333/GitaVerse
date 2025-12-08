package com.BG.gitaverse;
import com.BG.gitaverse.ShlokaDTO;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static reactor.netty.http.HttpConnectionLiveness.log;

@Service
public class ShlokaService {

    private List<EnglishShloka> englishShlokaList;
    private List<TeluguShloka> teluguShlokaList;

    public ShlokaService() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            ClassLoader classLoader = getClass().getClassLoader();

            EnglishShloka[] data = mapper.readValue(
                    classLoader.getResourceAsStream("geeta_english.json"),
                    EnglishShloka[].class
            );
            englishShlokaList = Arrays.asList(data);

            TeluguShloka[] teluguData = mapper.readValue(
                    classLoader.getResourceAsStream("geeta_telugu.json"),
                    TeluguShloka[].class
            );
            teluguShlokaList = Arrays.asList(teluguData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ShlokaDTO getShloka(int chapter, int verse) {

        EnglishShloka engShloka = englishShlokaList.stream()
                .filter(s -> s.getChapter() == chapter && s.getVerse() == verse)
                .findFirst()
                .orElse(null);

        TeluguShloka telShloka = teluguShlokaList.stream()
                .filter(s -> s.getChapter() == chapter && s.getVerse() == verse)
                .findFirst()
                .orElse(null);

        if (engShloka == null || telShloka == null) {
            return null;
        }

        return ShlokaDTO.builder()
                .chapter(chapter)
                .verse(verse)
                .shlokaText(engShloka.getSanskrit())
                .englishTranslation(engShloka.getEnglish())
                .teluguTranslation(telShloka.getTe_translation())
                .build();


    }
}
