public class Odemeler {
    private double bakiye = 0;

    public void faturalariGoruntule(FitnessUyeSistemi sistem) {
        System.out.println("Fatura bilgileri:");
        String seciliPaket = sistem.getPaketler().getSeciliPaket();
        if (seciliPaket != null) {
            int paketIndex = sistem.getPaketler().getMevcutPaketler().indexOf(seciliPaket);
            double paketFiyati = sistem.getPaketler().getPaketFiyatlari()[paketIndex];

            System.out.println("Aktif Paket: " + seciliPaket);
            System.out.println("Fatura Tutarı: " + paketFiyati);
            
        } else {
            System.out.println("Herhangi bir paket seçilmedi.");
        }
    }


    public void odemeYap(double miktar) {
        if (bakiye >= miktar) {
            bakiye -= miktar;
            System.out.println("Ödeme yapılmıştır! Kalan bakiye: " + bakiye);
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }

    public void bakiyeEkle(double miktar) {
        bakiye += miktar;
        System.out.println("Bakiye eklendi. Yeni bakiye: " + bakiye);
    }

    public void bakiyeSorgula() {
        System.out.println("Mevcut bakiyeniz: " + bakiye);
    }

    public double getBakiye() {
        return bakiye;
    }
}