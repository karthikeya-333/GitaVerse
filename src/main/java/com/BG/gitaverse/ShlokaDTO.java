package com.BG.gitaverse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShlokaDTO {
    private int chapter;
    private int verse;
    private String shlokaText;
    private String englishTranslation;
    private String teluguTranslation;
}
