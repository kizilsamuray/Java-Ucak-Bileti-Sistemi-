import entity.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 * Uçak Bilet Rezervasyon Sistemi
 * 
 * Bu sınıf, uçak bilet rezervasyon sisteminin ana giriş noktasıdır.
 * Sistem başlatıldığında örnek veriler oluşturulur ve grafiksel kullanıcı arayüzü başlatılır.
 * 
 * @author Uçak Rezervasyon Ekibi
 * @version 1.0
 */
public class Main {
    // Sistemdeki uçuş ve rezervasyon listeleri
    private static final List<Ucus> ucuslar = new ArrayList<>();
    private static final List<Rezervasyon> rezervasyonlar = new ArrayList<>();
    
    // Veri dosyalarının yolları
    private static final String Ucus_DOSYASI = "data/ucuslar.txt";
    private static final String REZERVASYON_DOSYASI = "data/rezervasyonlar.txt";

    public static void main(String[] args) {
        try {
            // Örnek verileri yükle
            initializeData();
            
            // GUI'yi başlat
            SwingUtilities.invokeLater(() -> {
                GUI gui = new GUI(ucuslar, rezervasyonlar);
                gui.setVisible(true);
            });
        } catch (Exception e) {
            System.err.println("Program başlatılırken bir hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Sistem için örnek verileri oluşturur.
     * Uçak, lokasyon ve uçuş bilgilerini içerir.
     */
    private static void initializeData() {
        // Uçak filosu oluştur
        Ucak ucak1 = new Ucak("Boeing 737", 150);
        Ucak ucak2 = new Ucak("Airbus A320", 180);
        Ucak ucak3 = new Ucak("Boeing 777", 300);
        Ucak ucak4 = new Ucak("Airbus A350", 250);

        // Havalimanları oluştur
        Lokasyon istanbul = new Lokasyon("İstanbul", "IST");
        Lokasyon ankara = new Lokasyon("Ankara", "ESB");
        Lokasyon izmir = new Lokasyon("İzmir", "ADB");
        Lokasyon antalya = new Lokasyon("Antalya", "AYT");
        Lokasyon londra = new Lokasyon("Londra", "LHR");
        Lokasyon paris = new Lokasyon("Paris", "CDG");
        Lokasyon roma = new Lokasyon("Roma", "FCO");
        Lokasyon dubai = new Lokasyon("Dubai", "DXB");

        // Uçuş zamanlarını ayarla
        LocalDateTime now = LocalDateTime.now();
        
        // İç hat uçuşlarını ekle
        ucuslar.add(new Ucus("TK1001", istanbul, ankara, now.plusHours(2), now.plusHours(3), ucak1, 500.0));
        ucuslar.add(new Ucus("TK1002", ankara, izmir, now.plusHours(4), now.plusHours(5), ucak2, 600.0));
        ucuslar.add(new Ucus("TK1003", izmir, istanbul, now.plusHours(6), now.plusHours(7), ucak1, 550.0));
        ucuslar.add(new Ucus("TK1004", istanbul, antalya, now.plusHours(8), now.plusHours(9), ucak2, 700.0));
        ucuslar.add(new Ucus("TK1005", antalya, ankara, now.plusHours(10), now.plusHours(11), ucak1, 650.0));
        
        // Dış hat uçuşlarını ekle
        ucuslar.add(new Ucus("TK2001", istanbul, londra, now.plusHours(12), now.plusHours(15), ucak3, 2500.0));
        ucuslar.add(new Ucus("TK2002", istanbul, paris, now.plusHours(14), now.plusHours(17), ucak3, 2300.0));
        ucuslar.add(new Ucus("TK2003", istanbul, roma, now.plusHours(16), now.plusHours(18), ucak4, 2100.0));
        ucuslar.add(new Ucus("TK2004", istanbul, dubai, now.plusHours(18), now.plusHours(22), ucak4, 2800.0));
        ucuslar.add(new Ucus("TK2005", dubai, londra, now.plusHours(20), now.plusHours(24), ucak3, 3200.0));

        // Verileri dosyaya kaydet
        saveUcuslar();
    }

    /**
     * Uçuş bilgilerini dosyaya kaydeder.
     * Her uçuş için gerekli bilgiler CSV formatında kaydedilir.
     */
    private static void saveUcuslar() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Ucus_DOSYASI))) {
            for (Ucus ucus : ucuslar) {
                writer.println(ucus.getUcusNo() + "," + 
                             ucus.getKalkisLokasyonu().getSehir() + "," +
                             ucus.getVarisLokasyonu().getSehir() + "," +
                             ucus.getKalkisZamani() + "," +
                             ucus.getVarisZamani() + "," +
                             ucus.getUcak().getModel() + "," +
                             ucus.getFiyat());
            }
        } catch (IOException e) {
            System.err.println("Uçuşlar kaydedilirken hata oluştu: " + e.getMessage());
        }
    }

    /**
     * Rezervasyon bilgilerini dosyaya kaydeder.
     * Her rezervasyon için gerekli bilgiler CSV formatında kaydedilir.
     */
    private static void saveRezervasyonlar() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(REZERVASYON_DOSYASI))) {
            for (Rezervasyon rezervasyon : rezervasyonlar) {
                writer.println(rezervasyon.getRezervasyonNo() + "," +
                             rezervasyon.getUcus().getUcusNo() + "," +
                             rezervasyon.getYolcuAdi() + "," +
                             rezervasyon.getYolcuSoyadi() + "," +
                             rezervasyon.getYolcuYasi() + "," +
                             rezervasyon.getRezervasyonTarihi() + "," +
                             rezervasyon.isOnaylandi());
            }
        } catch (IOException e) {
            System.err.println("Rezervasyonlar kaydedilirken hata oluştu: " + e.getMessage());
        }
    }
} 