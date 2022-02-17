package Projem;

import java.util.Scanner;

public class KütüphaneMain {

    private static KutuphaneIslemler islemler = new KutuphaneIslemler();
    private static Scanner scanner = new Scanner(System.in);
    private static Guvenlik silme = new Guvenlik();

    public static void kitaplarıGoster() {
        islemler.kitaplarıGoster();
    }

    public static void kitapAra() {
        System.out.print("Hangi kitabı arıyorsunuz?");
        String aranan_kitap = scanner.nextLine();
        islemler.kitapAra(aranan_kitap);
    }

    public static void yazarAra() {
        System.out.print("Hangi yazarı arıyorsunuz?");
        String aranan_yazar = scanner.nextLine();
        islemler.yazarAra(aranan_yazar);
    }

    public static void kitapEkle() {
        System.out.print("Eklenecek kitabın:\nAdı:");
        String kitap_adi = scanner.nextLine();
        System.out.print("Yazarı:");
        String yazar_adi = scanner.nextLine();
        System.out.print("Yayınevi:");
        String yayınevi = scanner.nextLine();
        System.out.print("Türü:");
        String tur = scanner.nextLine();
        System.out.print("Sayfa sayısı:");
        int sayfa_sayisi = scanner.nextInt();
        scanner.nextLine();
        islemler.kitapEkle(kitap_adi, yazar_adi, yayınevi, tur, sayfa_sayisi);
    }

    public static void kitapSil() {
        System.out.println("Silinecek kitabın adı:");
        String kitap_adi = scanner.nextLine();
        islemler.kitapSil(kitap_adi);
    }

    public static void tumKitaplariSil() {
        if (silme.silmeKontrol()) {
            islemler.tumKitaplariSil();
        } else {
            System.out.println("Buna yetkin yok.");
        }
    }

    public static void degisiklikleriKaydet() {
        islemler.degisiklikleriKaydet();
    }

    public static void hakkinda() {
        islemler.hakkinda();
    }

    public static void toplamKitapSayisi() {
        islemler.toplamKitapSayisi();
    }

    public static void toplamSayfaSayisi() {
        islemler.toplamSayfaSayisi();
    }

    public static void yazarlarinSahipOlduguKitapSayisi() {
        islemler.yazarlarınSahipOlduguKitapSayısı();
    }

    public static void islemleriGoruntule() {
        islemler.islemleri_goruntule();
    }

    public static void tureGoreKitaplariGoruntule() {

        islemler.tureGoreGoster();
    }

    public static void main(String[] args) {
        Guvenlik guvenlik = new Guvenlik();

        if (guvenlik.giris()) {
            islemler.kutuphaneyiIceAktar();
            islemleriGoruntule();
            String secim;
            boolean kontrol = true;
            while (kontrol) {

                System.out.print("Hangi işlemi yapacaksınız:");
                secim = scanner.nextLine();

                switch (secim) {
                    case "1":
                        kitaplarıGoster();
                        break;
                    case "2":
                        kitapAra();
                        break;
                    case "3":
                        yazarAra();
                        break;
                    case "4":
                        kitapEkle();
                        break;
                    case "5":
                        kitapSil();
                        break;
                    case "6":
                        toplamKitapSayisi();
                        break;
                    case "7":
                        toplamSayfaSayisi();
                        break;
                    case "8":
                        tureGoreKitaplariGoruntule();
                        break;
                    case "9":
                        tumKitaplariSil();
                        break;
                    case "10":
                        yazarlarinSahipOlduguKitapSayisi();
                        break;
                    case "11":
                        degisiklikleriKaydet();
                        break;
                    case "12":
                        hakkinda();
                        break;
                    case "13":
                        islemleriGoruntule();
                        break;
                    case "0":
                        System.out.println("Çıkış yapılıyor...");
                        kontrol = false;
                        break;
                    default:
                        System.out.println("Yanlış seçim,işlem seçimine geri dönülüyor...");
                }
            }

        } else {
            System.out.println("Giriş denemelerin başarısız.Giriş hakkı kalmadı.");
        }
    }

}
