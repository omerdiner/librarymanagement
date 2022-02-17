package Projem;

public interface IKutuphane {

    void kitaplarıGoster();

    void kitapAra(String aranan_kitap);

    void yazarAra(String aranan_yazar);

    void kitapEkle(String kitap_adi, String yazar, String yayin_evi, String tur, int sayfa_sayisi);

    void kitapSil(String silinecek_kitap);

    void islemleri_goruntule();

    void hakkinda();

    void toplamKitapSayisi();

    void toplamSayfaSayisi();

    void tureGoreGoster();

    void degisiklikleriKaydet();

    void tumKitaplariSil();

    void kutuphaneyiIceAktar();

    void yazarlarınSahipOlduguKitapSayısı();

}
