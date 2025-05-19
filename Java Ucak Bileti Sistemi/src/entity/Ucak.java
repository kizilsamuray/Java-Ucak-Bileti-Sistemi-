package entity;

/**
 * Uçak bilgilerini tutan sınıf
 * 
 * Bu sınıf, bir uçağın temel özelliklerini içerir:
 * - Uçak modeli
 * - Koltuk kapasitesi
 * 
 * @author Uçak Rezervasyon Ekibi
 * @version 1.0
 */
public class Ucak {
    // Sınıf değişkenleri
    private final String model;
    private final int koltukKapasitesi;

    /**
     * Uçak sınıfının yapıcı metodu
     * 
     * @param model Uçak modeli
     * @param koltukKapasitesi Uçağın koltuk kapasitesi
     */
    public Ucak(String model, int koltukKapasitesi) {
        this.model = model;
        this.koltukKapasitesi = koltukKapasitesi;
    }

    // Getter metodları
    public String getModel() { return model; }
    public int getKoltukKapasitesi() { return koltukKapasitesi; }

    @Override
    public String toString() {
        return model + " (" + koltukKapasitesi + " koltuk)";
    }
} 