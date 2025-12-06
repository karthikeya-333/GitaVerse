package com.BG.gitaverse;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeluguShloka {
    private int chapter;
    private int verse;
    private String sloka;
    private String te_translation;
}

