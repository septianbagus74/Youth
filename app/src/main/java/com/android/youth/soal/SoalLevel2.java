package com.android.youth.soal;

/**
 * Created by septian.bagus on 12/06/2018.
 */

public class SoalLevel2 {

    public String pertanyaan[] = {
//            english
            "You would like someone to take a photo of you in front of a famous monument. Making a polite request for this situation!",
            "When you are ... a job, you must be patient.",
            "Education in Indonesia is the ... of school, government and society.",
//            math
            "Terdapat sebuah barisan aritmatika sebanyak tujuh suku. Jika suku pertama dan nilai bedanya adalah 2. Berapakah suku tengahnya ?",
            "Diketahui suatu barisan aritmatika :2, 5, 8, 11, 14, .........Un. Tentukan rumus suku ke-n dalam barisan aritmetika tersebut: ",
            "Diketahui U2 + U4 = 12 dan U3 + U5 = 16, maka suku ke-7 barisan itu adalah ...",
            "Sebuah barisan Aritmatika memiliki jumlah suku ganjil. Jika suku pertamanya 4 dan suku terakhirnya 20, maka suku tengahnya adalah ...",
//            indonesia
            "Diketahui U2 + U4 = 12 dan U3 + U5 = 16, maka suku ke-7 barisan itu adalah",
            "Pada dasarnya, menulis menulis kerangka sebuah debat tidak jauh berbeda dengan kerangka dasar jurnal atau pidato. Namun, dalam membuat kerangka debat harus ... dengan baik.",
            "Salah satu bentuk perdebatan yang banyak digunakan. Pada paruh waktu pertama perdebatan, setiap tim memiliki dua segmen untuk menyajikan argumen. Hal tersebut merupakan pengertian debat ...",
    };

    private String pilihanJawaban[][] = {
            {"Hey! Take some photos of me.","Could you take some picture of me.","Can I take your picture, please."},
            {"looking at","looking for","looking up"},
            {"responsible","responsive","responsibility"},
            {"8","9","12"},
            {"Un = 3n -1", "Un = 3n -2", "Un = 3n + 1"},
            {"14","11","8"},
            {"12","11","14"},
            {"11","13","14"},
            {"terlihat","terstruktur","terakomodir"},
            {"antartim","publik", "bebas"},
    };

    private String jawabanBenar[] = {
            "Could you take some picture of me.",
            "looking for",
            "responsibility",
            "Un = 3n -1",
            "14",
            "14",
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
    //membuat getter untuk mengambil pilihan jawaban 3
    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
