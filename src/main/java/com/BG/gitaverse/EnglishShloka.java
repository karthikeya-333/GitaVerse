package com.BG.gitaverse;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnglishShloka {
    private int chapter;
    private int verse;
    private String sanskrit;
    private String hindi;
    private String english;
    private String transliteration;
}

