package entity;

/**
 * Lokasyon bilgilerini tutan sınıf
 * 
 * Bu sınıf, bir havalimanının temel bilgilerini içerir:
 * - Şehir adı
 * - Havalimanı kodu
 * 
 * @author Uçak Rezervasyon Ekibi
 * @version 1.0
 */
public class Lokasyon {
    // Sınıf değişkenleri
    private final String sehir;
    private final String havalimaniKodu;

    /**
     * Lokasyon sınıfının yapıcı metodu
     * 
     * @param sehir Şehir adı
     * @param havalimaniKodu Havalimanı kodu
     */
    public Lokasyon(String sehir, String havalimaniKodu) {
        this.sehir = sehir;
        this.havalimaniKodu = havalimaniKodu;
    }

    // Getter metodları
    public String getSehir() { return sehir; }
    public String getHavalimaniKodu() { return havalimaniKodu; }

    @Override
    public String toString() {
        return sehir + " (" + havalimaniKodu + ")";
    }
} 