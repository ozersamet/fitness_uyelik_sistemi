import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrupDersleri {
    private List<String> mevcutDersler = new ArrayList<>();
    private List<String> kayitliDersler = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public GrupDersleri() {
        mevcutDersler.add("Dans");
        mevcutDersler.add("Plates");
        mevcutDersler.add("Yoga");
    }

    public void mevcutDersleriGoruntule() {
        System.out.println("Mevcut Grup Dersleri:");
        for (String ders : mevcutDersler) {
            System.out.println("- " + ders);
        }
    }

    public void dersKaydiDegisiklik() {
        System.out.println("\nGrup Dersleri Kayıt/Değişiklik:");
        for (int i = 0; i < mevcutDersler.size(); i++) {
            System.out.println((i + 1) + ". " + mevcutDersler.get(i));
        }
        System.out.print("Seçiminiz (1-" + mevcutDersler.size() + "): ");

        int secim = scanner.nextInt();
        scanner.nextLine();

        if (secim >= 1 && secim <= mevcutDersler.size()) {
            String secilenDers = mevcutDersler.get(secim - 1);
            if (kayitliDersler.contains(secilenDers)) {
                kayitliDersler.remove(secilenDers);
                System.out.println(secilenDers + " dersinden çıkış yapıldı.");
            } else {
                kayitliDersler.add(secilenDers);
                System.out.println(secilenDers + " dersine kayıt olundu.");
            }
        } else {
            System.out.println("Geçersiz seçim!");
        }
    }
}
