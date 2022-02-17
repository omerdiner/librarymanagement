package Projem;

import java.io.Serializable;

public class Kitap implements Serializable {

    private String kitap_adi;
    private String yazar;
    private String yayin_evi;
    private String tur;
    private int sayfa_sayisi;

    public Kitap(String kitap_adi, String yazar, String yayin_evi, String tur, int sayfa_sayisi) {
        this.kitap_adi = kitap_adi;
        this.yazar = yazar;
        this.yayin_evi = yayin_evi;
        this.tur = tur;
        this.sayfa_sayisi = sayfa_sayisi;
    }

    @Override
    public String toString() {
        return kitap_adi + "," + yazar + "," + yayin_evi + "," + tur + "," + sayfa_sayisi;
    }

    public String getKitap_adi() {
        return kitap_adi;
    }

    public void setKitap_adi(String kitap_adi) {
        this.kitap_adi = kitap_adi;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getYayin_evi() {
        return yayin_evi;
    }

    public void setYayin_evi(String yayin_evi) {
        this.yayin_evi = yayin_evi;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int getSayfa_sayisi() {
        return sayfa_sayisi;
    }

    public void setSayfa_sayisi(int sayfa_sayisi) {
        this.sayfa_sayisi = sayfa_sayisi;
    }

}
