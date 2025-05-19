package entity;

import java.time.LocalDateTime;

/**
 * Uçuş bilgilerini tutan sınıf
 * 
 * Bu sınıf, bir uçuşun tüm detaylarını içerir:
 * - Uçuş numarası
 * - Kalkış ve varış lokasyonları
 * - Kalkış ve varış zamanları
 * - Kullanılan uçak
 * - Bilet fiyatı
 * - Dolu koltuk sayısı
 * 
 * @author Uçak Rezervasyon Ekibi
 * @version 1.0
 */
public class Ucus {
    // Sınıf değişkenleri
    private final String ucusNo;
    private final Lokasyon kalkisLokasyonu;
    private final Lokasyon varisLokasyonu;
    private final LocalDateTime kalkisZamani;
    private final LocalDateTime varisZamani;
    private final Ucak ucak;
    private final double fiyat;
    private int doluKoltukSayisi;

    /**
     * Uçuş sınıfının yapıcı metodu
     * 
     * @param ucusNo Uçuş numarası
     * @param kalkisLokasyonu Kalkış lokasyonu
     * @param varisLokasyonu Varış lokasyonu
     * @param kalkisZamani Kalkış zamanı
     * @param varisZamani Varış zamanı
     * @param ucak Kullanılacak uçak
     * @param fiyat Bilet fiyatı
     */
    public Ucus(String ucusNo, Lokasyon kalkisLokasyonu, Lokasyon varisLokasyonu,
                LocalDateTime kalkisZamani, LocalDateTime varisZamani, Ucak ucak, double fiyat) {
        this.ucusNo = ucusNo;
        this.kalkisLokasyonu = kalkisLokasyonu;
        this.varisLokasyonu = varisLokasyonu;
        this.kalkisZamani = kalkisZamani;
        this.varisZamani = varisZamani;
        this.ucak = ucak;
        this.fiyat = fiyat;
        this.doluKoltukSayisi = 0;
    }

    // Getter metodları
    public String getUcusNo() { return ucusNo; }
    public Lokasyon getKalkisLokasyonu() { return kalkisLokasyonu; }
    public Lokasyon getVarisLokasyonu() { return varisLokasyonu; }
    public LocalDateTime getKalkisZamani() { return kalkisZamani; }
    public LocalDateTime getVarisZamani() { return varisZamani; }
    public Ucak getUcak() { return ucak; }
    public double getFiyat() { return fiyat; }
    public int getDoluKoltukSayisi() { return doluKoltukSayisi; }

    /**
     * Uçuşa yeni bir koltuk rezervasyonu ekler
     * 
     * @return Rezervasyon başarılı ise true, değilse false
     */
    public boolean koltukRezerveEt() {
        if (doluKoltukSayisi < ucak.getKoltukKapasitesi()) {
            doluKoltukSayisi++;
            return true;
        }
        return false;
    }

    /**
     * Uçuşun dolu olup olmadığını kontrol eder
     * 
     * @return Uçuş dolu ise true, değilse false
     */
    public boolean doluMu() {
        return doluKoltukSayisi >= ucak.getKoltukKapasitesi();
    }

    @Override
    public String toString() {
        return String.format("Uçuş No: %s\nKalkış: %s\nVarış: %s\nKalkış Zamanı: %s\nVarış Zamanı: %s\n" +
                           "Uçak: %s\nFiyat: %.2f TL\nDolu Koltuk: %d/%d",
                           ucusNo, kalkisLokasyonu.getSehir(), varisLokasyonu.getSehir(),
                           kalkisZamani, varisZamani, ucak.getModel(), fiyat,
                           doluKoltukSayisi, ucak.getKoltukKapasitesi());
    }
} 