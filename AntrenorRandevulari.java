import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AntrenorRandevulari {
    private List<String> mevcutRandevular = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public AntrenorRandevulari() {
        mevcutRandevular.add("Salı 10:00-12:00");
        mevcutRandevular.add("Çarşamba 14:00-16:00");
        mevcutRandevular.add("Cuma 16:00-18:00");
    }

    public void mevcutRandevulariGoruntule() {
        System.out.println("Mevcut Antrenör Randevuları:");
        if (mevcutRandevular.isEmpty()) {
            System.out.println("Mevcut randevu bulunamadı.");
        } else {
            for (String randevu : mevcutRandevular) {
                System.out.println("- " + randevu);
            }
        }
    }

    public void randevuAlIptalEt() {
        System.out.println("\nRandevu Al/İptal Et:");
        mevcutRandevulariGoruntule();

        System.out.print("Almak istediğiniz randevuyu seçin (veya iptal etmek için 'iptal' yazın): ");
        String secim = scanner.nextLine();

        if (secim.equalsIgnoreCase("iptal")) {
            System.out.print("İptal etmek istediğiniz randevuyu seçin: ");
            String iptalEdilecekRandevu = scanner.nextLine();
            if (mevcutRandevular.remove(iptalEdilecekRandevu)) {
                System.out.println(iptalEdilecekRandevu + " randevusu iptal edildi.");
            } else {
                System.out.println("Randevu bulunamadı.");
            }
        } else {
            if (mevcutRandevular.contains(secim)) {
                System.out.println(secim + " randevusu zaten alınmış.");
            } else {
                mevcutRandevular.add(secim);
                System.out.println(secim + " randevusu alındı.");
            }
        } 
    }
}
