package Projem;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class KutuphaneIslemler implements IKutuphane, Serializable {

    private static ArrayList<Kitap> kitaplarim = new ArrayList<Kitap>();

    @Override
    public void kutuphaneyiIceAktar() {

        try (ObjectInputStream kitaplarBin = new ObjectInputStream(new FileInputStream("kitaplar.bin"))) {

            /* if (kitaplarBin != null) {
                kitaplarim = (ArrayList<Kitap>) kitaplarBin.readObject();
            } else {
                System.out.println("Kayıtlı veri yok.");
            }*/ kitaplarim = (ArrayList<Kitap>) kitaplarBin.readObject();

        } catch (FileNotFoundException ex) {
            System.out.println("Kitaplar kaynak dosyası bulunamadı..");
        } catch (EOFException ex) {
            System.out.println("Dosya boş");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Kitaplar dosyası çalışırken hata oluştu...");
            System.out.println("Hata verse de önce bir kitap ekleyin.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Kitaplar sınıfı bulunamadı....");
        }

    }

    @Override
    public void kitaplarıGoster() {
        for (Kitap kitap : kitaplarim) {
            System.out.println(kitap + "\n");
        }
    }

    @Override
    public void kitapAra(String aranan_kitap) {
        boolean kontrol = true;
        for (Kitap kitap : kitaplarim) {
            if (kitap.getKitap_adi().equalsIgnoreCase(aranan_kitap)) {
                System.out.println("Aranan kitap bulundu:" + kitap);
                kontrol = false;
                break;
            }
        }
        if (kontrol) {
            System.out.println("Aradığınız kitap bulunmamaktadır..");
        }
    }

    @Override
    public void yazarAra(String aranan_yazar) {
        boolean kontrol = true;
        for (Kitap kitap : kitaplarim) {
            if (kitap.getYazar().equalsIgnoreCase(aranan_yazar)) {
                System.out.println(kitap + "\n");
                kontrol = false;
            }

        }
        if (kontrol) {
            System.out.println("Aradığınız yazar bulunamadı...");
        }
    }

    @Override
    public void kitapEkle(String kitap_adi, String yazar, String yayin_evi, String tur, int sayfa_sayisi) {
        boolean kitapVarmi = false;
        for (Kitap kitap : kitaplarim) {
            if (kitap.getKitap_adi().equalsIgnoreCase(kitap_adi)) {
                System.out.println("Bu kitap zaten ekli..");
                kitapVarmi = true;
                break;
            }
        }
        if (!kitapVarmi) {
            kitaplarim.add(new Kitap(kitap_adi, yazar, yayin_evi, tur, sayfa_sayisi));
        }

    }

    @Override
    public void kitapSil(String silinecek_kitap) {
        boolean kontrol = true;
        for (Kitap kitap : kitaplarim) {
            if (kitap.getKitap_adi().equalsIgnoreCase(silinecek_kitap)) {
                kitaplarim.remove(kitap);
                System.out.println(silinecek_kitap + " silindi..");
                kontrol = false;
                break;
            }
        }
        if (kontrol) {
            System.out.println("Silinecek kitap mevcut değil...");

        }
    }

    @Override
    public void islemleri_goruntule() {
        String islemler = "1.Kitapları Görüntüle\n" + "2.Kitap Ara\n" + "3.Yazar Ara\n" + "4.Kitap Ekle\n" + "5.Kitap Sil\n" + "6.Toplam Kitap Sayısı\n" + "7.Toplam Sayfa Sayısı\n" + "8.Türe Göre Kitapları Görüntüle\n"
                + "9.Tüm Kitapları Sil\n" + "10.Yazarların Sahip Olduğu Kitap Sayısını Görüntüle\n" + "11.Değişiklikleri Kaydet\n" + "12.Hakkında\n" + "13.İşlemleri Göster\n" + "0.Çıkış\n";
        System.out.println(islemler);
    }

    @Override
    public void hakkinda() {
        System.out.println("Programı yazan:ÖMER DİNER\n"
                + "Kodlanma tarihi:31.03.2021\n" + "Txt dosyası:kitaplar.txt\n" + "Kayıt dosyası:kitaplar.bin\n" + "Kitap ekleme/çıkarma vb işlemlerden sonra değişiklikleri kaydetmeyi unutmayınız.");
    }

    @Override
    public void toplamKitapSayisi() {
        System.out.println("Kütüphanenizde bulunan toplam kitap sayısı:" + kitaplarim.size());
    }

    @Override
    public void toplamSayfaSayisi() {
        int toplam_sayfa_sayisi = 0;
        for (Kitap kitap : kitaplarim) {
            toplam_sayfa_sayisi += kitap.getSayfa_sayisi();
        }
        System.out.println("Kütüphanenizde bulunan toplam sayfa sayısı:" + toplam_sayfa_sayisi);
    }

    @Override
    public void tureGoreGoster() {
        ArrayList<Kitap> Roman = new ArrayList<Kitap>();
        ArrayList<Kitap> Tarih_Biyografi = new ArrayList<Kitap>();
        ArrayList<Kitap> Bilim_Arastirma = new ArrayList<Kitap>();
        ArrayList<Kitap> Felsefe_KisiselGelisim = new ArrayList<Kitap>();
        ArrayList<Kitap> Siir_Diger = new ArrayList<Kitap>();

        Roman.clear();
        Tarih_Biyografi.clear();
        Bilim_Arastirma.clear();
        Felsefe_KisiselGelisim.clear();
        Siir_Diger.clear();

        for (Kitap kitap : kitaplarim) {
            if (kitap.getTur().equalsIgnoreCase("roman")) {
                Roman.add(kitap);
            } else if (kitap.getTur().equalsIgnoreCase("tarih")) {
                Tarih_Biyografi.add(kitap);
            } else if (kitap.getTur().equalsIgnoreCase("bilim")) {
                Bilim_Arastirma.add(kitap);
            } else if (kitap.getTur().equalsIgnoreCase("felsefe")) {
                Felsefe_KisiselGelisim.add(kitap);
            } else if (kitap.getTur().equalsIgnoreCase("siir")) {
                Siir_Diger.add(kitap);
            } else {
                System.out.println("Böyle bir tür bulunmuyor,tekrar bakınız.\n" + kitap);
            }
        }
        System.out.println("--------ROMAN-----------");
        for (Kitap kitap : Roman) {
            System.out.println(kitap);
        }
        System.out.println("\n\n---------TARİH VE BİYOGRAFİ--------");
        for (Kitap kitap : Tarih_Biyografi) {
            System.out.println(kitap);
        }
        System.out.println("\n\n--------BİLİM VE ARAŞTIRMA---------");
        for (Kitap kitap : Bilim_Arastirma) {
            System.out.println(kitap);
        }
        System.out.println("\n\n------FELSEFE VE KİŞİSEL GELİŞİM-------");
        for (Kitap kitap : Felsefe_KisiselGelisim) {
            System.out.println(kitap);
        }
        System.out.println("\n\n-------ŞİİR VE DİĞER-------");
        for (Kitap kitap : Siir_Diger) {
            System.out.println(kitap);
        }

    }

    @Override
    public void tumKitaplariSil() {
        kitaplarim.clear();
        System.out.println("Kütüphanenizden tüm kitaplar silinmiştir.");
        try {
            new FileOutputStream("kitaplar.bin", false).close();
            new FileOutputStream("kitaplar.txt", false).close();

        } catch (IOException ex) {
            System.out.println("Dosya temizlenirken hata çıktı");
        }
    }

    @Override
    public void yazarlarınSahipOlduguKitapSayısı() {
        Map<String, Integer> frekans = new TreeMap<String, Integer>();

        for (Kitap kitap : kitaplarim) {

            if (frekans.containsKey(kitap.getYazar())) {
                frekans.replace(kitap.getYazar(), frekans.get(kitap.getYazar()) + 1);
            } else {
                frekans.put(kitap.getYazar(), 1);
            }
        }

        for (String yazar : frekans.keySet()) {
            System.out.println(yazar + " " + frekans.get(yazar) + " adet kitaba sahiptir..");
        }
        System.out.println("Toplam " + frekans.size() + " adet yazar kütüphanenizde bulunmaktadır.");

    }

    @Override
    public void degisiklikleriKaydet() {
        try (ObjectOutputStream kitaplarObje = new ObjectOutputStream(new FileOutputStream("kitaplar.bin"));
                BufferedWriter kitaplarTxt = new BufferedWriter(new FileWriter("kitaplar.txt"))) {

            kitaplarObje.writeObject(kitaplarim);

            for (Kitap kitap : kitaplarim) {
                kitaplarTxt.write(kitap.toString() + "\n");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Kaydedilecek dosyalar açılırken hata..");
        } catch (IOException ex) {
            System.out.println("Kitapları kaydederken hata oluştu..");
        }
    }

}
