package com.BG.gitaverse;
import com.BG.gitaverse.ShlokaDTO;


import org.springframework.stereotype.Service;

@Service
public class ShlokaService {

    public ShlokaDTO getShloka(int chapter, int verse) {

        return ShlokaDTO.builder()
                .chapter(chapter)
                .verse(verse)
                .shlokaText("धर्मक्षेत्रे कुरुक्षेत्रे समवेता युयుత్సवः ।")
                .englishTranslation("In the field of dharma, in the field of Kurukshetra, assembled are those eager to fight.")
                .teluguTranslation("ధర్మక్షేత్రే కురుక్షేత్రే సమవేతా యుయుత్సవః ।")
                .build();
    }
}
