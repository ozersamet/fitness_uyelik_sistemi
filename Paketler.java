import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Paketler {
    private List<String> mevcutPaketler = new ArrayList<>();
    private double[] paketFiyatlari = {1500.0, 3000.0, 5000.0};
    private List<String[]> paketOzellikleri = new ArrayList<>();
    private String seciliPaket;
    private Scanner scanner = new Scanner(System.in);

    public Paketler() {
        mevcutPaketler.add("Gümüş Paket");
        mevcutPaketler.add("Altın Paket");
        mevcutPaketler.add("Elmas Paket");
        seciliPaket = null;

        paketOzellikleri.add(new String[]{"Gümüş Paket Özellikleri +", "Tüm spor ekipmanları", "Herhangi bir Antrenör"});
        paketOzellikleri.add(new String[]{"Altın Paket Özellikleri +", "Tüm spor ekipmanları", "Herhangi bir Antrenör", "Havuz", "Sauna"});
        paketOzellikleri.add(new String[]{"Elmas Paket Özellikleri +", "Tüm spor ekipmanları", "Kişisel Antrenör", "Masaj", "Havuz", "Sauna", "Grup Dersleri"});
    }

    public void mevcutPaketleriGoruntule() {
        System.out.println("Mevcut Paketler:");
        for (int i = 0; i < mevcutPaketler.size(); i++) {
            System.out.println((i + 1) + ". " + mevcutPaketler.get(i) + " (Fiyat: " + paketFiyatlari[i] + ")");
            System.out.println("   Ozellikler: " + Arrays.toString(paketOzellikleri.get(i)));
        }
    }
    
    public double[] getPaketFiyatlari() {
        return paketFiyatlari;
    }
    
    public List<String> getMevcutPaketler() {
        return mevcutPaketler;
    }

    public void paketSecimiDegisikligi(Odemeler odemeler) {
        System.out.println("\nPaket Seçimi:");
        mevcutPaketleriGoruntule();

        System.out.print("Seçiminiz (1-" + mevcutPaketler.size() + "): ");

        int secim = scanner.nextInt();
        scanner.nextLine();

        if (secim >= 1 && secim <= mevcutPaketler.size()) {
            seciliPaket = mevcutPaketler.get(secim - 1);
            double paketFiyati = paketFiyatlari[secim - 1];

            
            if (odemeler.getBakiye() >= paketFiyati) {
                odemeler.odemeYap(paketFiyati);
                System.out.println(seciliPaket + " seçildi, git ve BASSS!");
            } else {
                System.out.println("Yetersiz bakiye! Lütfen bakiye ekleyin.");
                seciliPaket = null;
            }
        } else {
            System.out.println("Geçersiz seçim!");
        }
    }

    public String getSeciliPaket() {
        return seciliPaket;
    }
}
