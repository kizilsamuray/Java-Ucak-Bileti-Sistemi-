package entity;

import java.time.LocalDateTime;

/**
 * Rezervasyon bilgilerini tutan sınıf
 * 
 * Bu sınıf, bir rezervasyonun tüm detaylarını içerir:
 * - Rezervasyon numarası
 * - Rezervasyon yapılan uçuş
 * - Yolcu bilgileri (ad, soyad, yaş)
 * - Rezervasyon tarihi
 * - Rezervasyon durumu
 * 
 * @author Uçak Rezervasyon Ekibi
 * @version 1.0
 */
public class Rezervasyon {
    // Sınıf değişkenleri
    private final String rezervasyonNo;
    private final Ucus ucus;
    private final String yolcuAdi;
    private final String yolcuSoyadi;
    private final int yolcuYasi;
    private final LocalDateTime rezervasyonTarihi;
    private boolean onaylandi;

    /**
     * Rezervasyon sınıfının yapıcı metodu
     * 
     * @param rezervasyonNo Rezervasyon numarası
     * @param ucus Rezervasyon yapılacak uçuş
     * @param yolcuAdi Yolcunun adı
     * @param yolcuSoyadi Yolcunun soyadı
     * @param yolcuYasi Yolcunun yaşı
     */
    public Rezervasyon(String rezervasyonNo, Ucus ucus, String yolcuAdi, String yolcuSoyadi, int yolcuYasi) {
        this.rezervasyonNo = rezervasyonNo;
        this.ucus = ucus;
        this.yolcuAdi = yolcuAdi;
        this.yolcuSoyadi = yolcuSoyadi;
        this.yolcuYasi = yolcuYasi;
        this.rezervasyonTarihi = LocalDateTime.now();
        this.onaylandi = false;
    }

    // Getter metodları
    public String getRezervasyonNo() { return rezervasyonNo; }
    public Ucus getUcus() { return ucus; }
    public String getYolcuAdi() { return yolcuAdi; }
    public String getYolcuSoyadi() { return yolcuSoyadi; }
    public int getYolcuYasi() { return yolcuYasi; }
    public LocalDateTime getRezervasyonTarihi() { return rezervasyonTarihi; }
    public boolean isOnaylandi() { return onaylandi; }

    /**
     * Rezervasyonu gerçekleştirir
     * 
     * @return Rezervasyon başarılı ise true, değilse false
     */
    public boolean rezervasyonYap() {
        if (ucus.koltukRezerveEt()) {
            onaylandi = true;
            return true;
        }
        return false;
    }

    /**
     * Rezervasyonu iptal eder
     */
    public void iptalEt() {
        if (onaylandi) {
            onaylandi = false;
            // Burada uçuşun dolu koltuk sayısını azaltma işlemi yapılabilir
        }
    }

    @Override
    public String toString() {
        return String.format("Rezervasyon No: %s\nYolcu: %s %s (Yaş: %d)\nUçuş: %s\n" +
                           "Rezervasyon Tarihi: %s\nDurum: %s",
                           rezervasyonNo, yolcuAdi, yolcuSoyadi, yolcuYasi,
                           ucus.getUcusNo(), rezervasyonTarihi,
                           onaylandi ? "Onaylandı" : "Beklemede");
    }
} 