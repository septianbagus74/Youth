package com.android.youth.soal;

/**
 * Created by septian.bagus on 28/05/2018.
 */

public class SoalLevel1 {

    public String pertanyaan[] = {
            "Marcell : What's your name?(1) \nFauzi : My name is Fauzi(2) \nMarcell : What a great name!(3) \nFauzi : Thanks!(4)\n\nWhere is the compliment?",
            "Which of the following sentence is a NOT a compliment?",
            "The poor kids thanked us for ... him money and food.",
            "I don't know why they prefer ... in Cisauk.",
            "Diketahui data sebagai berikut : 7, 8, 8, 9, 7, 6, 5, 8. Nilai rata rata dari data tersebut adalah ...",
            "Median dari data : 5, 6, 6, 8, 7, 6, 8, 7, 6, 9 adalah ...",
            "Sebuah barisan Aritmatika memiliki jumlah suku ganjil. Jika suku pertamanya 4 dan suku terakhirnya 20, maka suku tengahnya adalah ...",
            "Diketahui U2 + U4 = 12 dan U3 + U5 = 16, maka suku ke-7 barisan itu adalah",
            "Pada dasarnya, menulis menulis kerangka sebuah debat tidak jauh berbeda dengan kerangka dasar jurnal atau pidato. Namun, dalam membuat kerangka debat harus ... dengan baik.",
            "Salah satu bentuk perdebatan yang banyak digunakan. Pada paruh waktu pertama perdebatan, setiap tim memiliki dua segmen untuk menyajikan argumen. Hal tersebut merupakan pengertian debat ...",
    };

    private String pilihanJawaban[][] = {
            {"(1)","(2)","(3)"},
            {"That looks awful","Nice bike!","You look Amazing"},
            {"giving","given","gave"},
            {"live","living","to living"},
            {"8,25", "7,25", "6,00"},
            {"Me = 6","Me = 6,25","Me = 6,5"},
            {"12","11","14"},
            {"11","13","14"},
            {"terlihat","terstruktur","terakomodir"},
            {"antartim","publik", "bebas"},
    };

    private String jawabanBenar[] = {
            "(3)",
            "That looks awful",
            "giving",
            "living",
            "7,25",
            "6,5",
            "11",
            "14",
            "terstruktur",
            "antartim",
    };

    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }

    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}