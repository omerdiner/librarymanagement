package Projem;

import java.util.Scanner;

public class Guvenlik {

    private final String sifre = "omer123";
    private final String silmeSifre = "qwqe";

    public boolean giris() {
        Scanner scanner = new Scanner(System.in);
        int kalan_hak = 2;
        System.out.print("Uygulamaya giriş yapmaya çalışan kişinin ismi:");
        String isim = scanner.nextLine();
        while (kalan_hak > -1) {
            System.out.print("Uygulamaya giriş için şifrenizi giriniz:");
            String gelen_sifre = scanner.nextLine();
            if (gelen_sifre.equals(sifre)) {
                System.out.println("Giriş başarılı..");
                System.out.println("İyi günler dileriz sayın " + isim);
                return true;
            } else {
                System.out.println("Başarısız giriş denemesi..");
                System.out.println("Kalan giriş hakkı:" + kalan_hak);
                kalan_hak--;
            }
        }
        return false;

    }

    public boolean silmeKontrol() {
        int kalan_hak = 1;
        Scanner scanner = new Scanner(System.in);

        while (kalan_hak > -1) {
            System.out.print("Silmek için şifrenizi giriniz:");
            String gelen_sifre = scanner.nextLine();
            if (gelen_sifre.equals(silmeSifre)) {
                System.out.println("Silinmek için izin alindi");
                return true;
            } else {
                System.out.println("Başarısız giriş denemesi..");
                System.out.println("Kalan giriş hakkı:" + kalan_hak);
                kalan_hak--;
            }
        }
        return false;

    }
}
