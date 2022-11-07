package com.example.library.dto;

public enum CategoryType {


    RESEARCH_HISTORY("Arastirma - Tarih"),
    SCIENCE("Bilim"),
    COMIC("Komik"),
    CHILD_AND_YOUNG("Çocuk ve Genclik"),
    LESSON_TEST_BOOKS("Sinav Kitaplari"),
    HOBBY("Hobi"),
    MYTH_LEGEND("Mitoloji Efsane"),
    HUMOR("Mizah"),
    PRESTIGE_BOOKS("Prestij Kitaplari"),
    ART_DESING("Sanat - Tasarim"),
    AUDIO_BOOKS("Sesli Kitaplar"),
    OTHER ("Diger");


    private final String value;

    CategoryType(String  value) {this.value = value;}

    public String getValue(){
        return value;
    }
}
