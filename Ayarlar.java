import java.util.Scanner;

public class Ayarlar {
    private boolean bildirimlerAktif = true;
    private Scanner scanner = new Scanner(System.in);

    public void bildirimTercihleriYapilandir() {
        System.out.println("\nBildirim Tercihleri:");
        System.out.println("1. Bildirimleri Aç");
        System.out.println("2. Bildirimleri Kapat");
        System.out.print("Seciminiz: ");

        int secim = scanner.nextInt();
        scanner.nextLine();

        switch (secim) {
            case 1:
                bildirimlerAktif = true;
                break;
            case 2:
                bildirimlerAktif = false;
                break;
            default:
                System.out.println("Geçersiz seçim!");
                break;
        }

        System.out.println("Bildirimler: " + (bildirimlerAktif ? "Açık" : "Kapalı"));
    }

    public void digerAyarlariDuzenle() {
        System.out.println("Diğer ayarları düzenleme işlemleri burada yapılacak.");
        // valla hocam ne kadar uğraşırsam uğraşayım arkadaşlada yaptım bir türlü bildirimleri aktif et veya kapat seçeneklerini çıktıya ekleyemedim
    }
}