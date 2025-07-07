import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitnessUyeSistemi {
    private List<Uye> uyeListesi = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Paketler paketler = new Paketler();
    private GrupDersleri grupDersleri = new GrupDersleri();
    private Odemeler odemeler = new Odemeler();
    private AntrenorRandevulari antrenorRandevulari = new AntrenorRandevulari();
    private Ayarlar ayarlar = new Ayarlar();

    public void girisYap() {
        System.out.print("Kullanıcı Adı: ");
        String kullaniciAdi = scanner.nextLine();
        System.out.print("Şifre ");
        String sifre = scanner.nextLine();

        for (Uye uye : uyeListesi) {
            if (uye.getKullaniciAdi().equals(kullaniciAdi) && uye.getSifre().equals(sifre)) {
                System.out.println("Giriş başarılı!");
                menuGoster();
                return;
            }
        }

        System.out.println("Kullanıcı adı veya şifre hatalı, tekrar dene SPORCU Kardeşim!");
    }

    public void kayitOl() {
        System.out.print("Kullanıcı Adı: ");
        String kullaniciAdi = scanner.nextLine();
        System.out.print("Şifre: ");
        String sifre = scanner.nextLine();

        if (kullaniciAdiVarMi(kullaniciAdi)) {
            System.out.println("Bu kullanıcı adı zaten mevcut, farklı bir kullanıcı adı gir SPORCU Kardeşim!");
            return;
        }

        Uye yeniUye = new Uye(kullaniciAdi, sifre);
        uyeListesi.add(yeniUye);
        System.out.println("Aramız Hoşgeldin SPORCU Kardeşim!");
    }

    public boolean kullaniciAdiVarMi(String kullaniciAdi) {
        for (Uye uye : uyeListesi) {
            if (uye.getKullaniciAdi().equals(kullaniciAdi)) {
                return true;
            }
        }
        return false;
    }

    public void menuGoster() {
        while (true) {
            System.out.println("\nSpor Menusu:");
            System.out.println("1. Paket Secimi");
            System.out.println("2. Grup Dersleri");
            System.out.println("3. Odemeler");
            System.out.println("4. Faturalari Goruntule");
            System.out.println("5. Antrenor Randevulari");
            System.out.println("6. Ayarlar");
            System.out.println("0. Cikis");
            System.out.print("Seciminiz: ");

            int secim;
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    paketler.mevcutPaketleriGoruntule();
                    paketler.paketSecimiDegisikligi(odemeler);
                    break;
                case 2:
                    grupDersleri.mevcutDersleriGoruntule();
                    grupDersleri.dersKaydiDegisiklik();
                    break;
                case 3:
                    odemeMenusuGoster();
                    break;
                case 4:
                    odemeler.faturalariGoruntule(this);
                    break;
                case 5:
                    antrenorRandevulari.mevcutRandevulariGoruntule();
                    antrenorRandevulari.randevuAlIptalEt();
                    break;
                case 6:
                    ayarlar.digerAyarlariDuzenle();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("geçersiz seçim");
            }
        }
    }

    private void odemeMenusuGoster() {
        while (true) {
            System.out.println("\n1. Odeme Yap");
            System.out.println("2. Bakiye Ekle");
            System.out.println("3. Bakiye Sorgula");
            System.out.println("0. Geri Don");
            System.out.print("Seciminiz: ");

            int secim;
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.print("ödeme miktari: ");
                    double miktar = scanner.nextDouble();
                    scanner.nextLine();
                    odemeler.odemeYap(miktar);
                    break;
                case 2:
                    double eklenecekBakiye = 0;
                    if (paketler.getSeciliPaket() != null) {
                        int paketIndex = paketler.getMevcutPaketler().indexOf(paketler.getSeciliPaket());
                        double paketFiyati = paketler.getPaketFiyatlari()[paketIndex];
                        System.out.print("Eklenecek bakiye miktari (Paket fiyati: " + paketFiyati + "): ");
                        eklenecekBakiye = scanner.nextDouble();
                        scanner.nextLine();

                        if (eklenecekBakiye < paketFiyati) {
                            System.out.println("Yetersiz bakiye! Paketin fiyati: " + paketFiyati);
                            break;
                        }

                        eklenecekBakiye -= paketFiyati;
                    } else {
                        System.out.print("Eklenecek bakiye miktari: ");
                        eklenecekBakiye = scanner.nextDouble();
                        scanner.nextLine();
                    }
                    odemeler.bakiyeEkle(eklenecekBakiye);
                    break;
                case 3:
                    odemeler.bakiyeSorgula();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz seçim");
            }
        }
    }

    public Paketler getPaketler() {
        return paketler;
    }

    public static void main(String[] args) {
    	  Scanner scanner = new Scanner(System.in);
    	  FitnessUyeSistemi fitnessUyeSistemi = new FitnessUyeSistemi();

    	  while (true) {
    	    System.out.println("\n1. Giriş Yap");
    	    System.out.println("2. Kayıt Ol");
    	    System.out.println("3. Çıkış");
    	    System.out.print("Seçiminizi Yapın: ");

    	    int secim;
    	    secim = scanner.nextInt();
    	    scanner.nextLine();

    	    switch (secim) {
    	      case 1:
    	        fitnessUyeSistemi.girisYap();
    	        break;
    	      case 2:
    	        fitnessUyeSistemi.kayitOl();
    	        break;
    	      case 3:
    	        System.out.println("Çıkış yapılıyor...");
    	        scanner.close();
    	        System.exit(0);
    	      default:
    	        System.out.println("Geçersiz seçim yaptınız.");
    	    }
    	  }
    	}
}
