import entity.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Uçak Bilet Rezervasyon Sistemi Grafiksel Kullanıcı Arayüzü
 * 
 * Bu sınıf, sistemin grafiksel kullanıcı arayüzünü oluşturur ve yönetir.
 * Üç ana sekme içerir: Uçuşlar, Rezervasyon Yap ve Rezervasyonlar.
 * 
 * @author Uçak Rezervasyon Ekibi
 * @version 1.0
 */
public class GUI extends JFrame {
    // Sınıf değişkenleri
    private final List<Ucus> ucuslar;
    private final List<Rezervasyon> rezervasyonlar;
    private final JTabbedPane tabbedPane;
    private final JTable ucusTable;
    private final JTable rezervasyonTable;
    private final DefaultTableModel ucusTableModel;
    private final DefaultTableModel rezervasyonTableModel;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    /**
     * GUI sınıfının yapıcı metodu
     * 
     * @param ucuslar Mevcut uçuşların listesi
     * @param rezervasyonlar Mevcut rezervasyonların listesi
     */
    public GUI(List<Ucus> ucuslar, List<Rezervasyon> rezervasyonlar) {
        this.ucuslar = ucuslar;
        this.rezervasyonlar = rezervasyonlar;

        // Pencere ayarları
        setTitle("Uçak Bilet Rezervasyon Sistemi");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Ana panel oluştur
        tabbedPane = new JTabbedPane();
        
        // Uçuşlar tablosunu oluştur
        String[] ucusColumns = {"Uçuş No", "Kalkış", "Varış", "Kalkış Zamanı", "Varış Zamanı", "Uçak", "Fiyat", "Dolu Koltuk"};
        ucusTableModel = new DefaultTableModel(ucusColumns, 0);
        ucusTable = new JTable(ucusTableModel);
        JScrollPane ucusScrollPane = new JScrollPane(ucusTable);
        
        // Rezervasyonlar tablosunu oluştur
        String[] rezervasyonColumns = {"Rezervasyon No", "Yolcu", "Uçuş", "Rezervasyon Tarihi", "Durum"};
        rezervasyonTableModel = new DefaultTableModel(rezervasyonColumns, 0);
        rezervasyonTable = new JTable(rezervasyonTableModel);
        JScrollPane rezervasyonScrollPane = new JScrollPane(rezervasyonTable);

        // Rezervasyon yapma panelini oluştur
        JPanel rezervasyonPanel = createRezervasyonPanel();

        // Sekmeleri ekle
        tabbedPane.addTab("Uçuşlar", ucusScrollPane);
        tabbedPane.addTab("Rezervasyon Yap", rezervasyonPanel);
        tabbedPane.addTab("Rezervasyonlar", rezervasyonScrollPane);

        // Ana pencereye ekle
        add(tabbedPane);
        
        // Tabloları güncelle
        updateTables();
    }

    /**
     * Rezervasyon yapma panelini oluşturur
     * 
     * @return Oluşturulan panel
     */
    private JPanel createRezervasyonPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Uçuş seçimi
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Uçuş:"), gbc);

        gbc.gridx = 1;
        JComboBox<String> ucusCombo = new JComboBox<>();
        for (Ucus ucus : ucuslar) {
            ucusCombo.addItem(ucus.getUcusNo() + " - " + ucus.getKalkisLokasyonu().getSehir() + 
                            " -> " + ucus.getVarisLokasyonu().getSehir());
        }
        panel.add(ucusCombo, gbc);

        // Yolcu bilgileri
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Ad:"), gbc);

        gbc.gridx = 1;
        JTextField adField = new JTextField(20);
        panel.add(adField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Soyad:"), gbc);

        gbc.gridx = 1;
        JTextField soyadField = new JTextField(20);
        panel.add(soyadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Yaş:"), gbc);

        gbc.gridx = 1;
        JSpinner yasSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 120, 1));
        panel.add(yasSpinner, gbc);

        // Rezervasyon yap butonu
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton rezervasyonButton = new JButton("Rezervasyon Yap");
        panel.add(rezervasyonButton, gbc);

        // Rezervasyon yapma işlemi
        rezervasyonButton.addActionListener(e -> {
            int selectedIndex = ucusCombo.getSelectedIndex();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(this, "Lütfen bir uçuş seçin!");
                return;
            }

            String ad = adField.getText().trim();
            String soyad = soyadField.getText().trim();
            int yas = (Integer) yasSpinner.getValue();

            if (ad.isEmpty() || soyad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurun!");
                return;
            }

            Ucus secilenUcus = ucuslar.get(selectedIndex);
            String rezervasyonNo = String.format("REZ%04d", rezervasyonlar.size() + 1);
            Rezervasyon rezervasyon = new Rezervasyon(rezervasyonNo, secilenUcus, ad, soyad, yas);

            if (rezervasyon.rezervasyonYap()) {
                rezervasyonlar.add(rezervasyon);
                updateTables();
                JOptionPane.showMessageDialog(this, "Rezervasyon başarıyla yapıldı!");
                
                // Form alanlarını temizle
                adField.setText("");
                soyadField.setText("");
                yasSpinner.setValue(18);
            } else {
                JOptionPane.showMessageDialog(this, "Üzgünüz, bu uçuş için boş koltuk bulunmamaktadır!");
            }
        });

        return panel;
    }

    /**
     * Uçuş ve rezervasyon tablolarını günceller
     */
    private void updateTables() {
        // Uçuşlar tablosunu güncelle
        ucusTableModel.setRowCount(0);
        for (Ucus ucus : ucuslar) {
            ucusTableModel.addRow(new Object[]{
                ucus.getUcusNo(),
                ucus.getKalkisLokasyonu().getSehir(),
                ucus.getVarisLokasyonu().getSehir(),
                ucus.getKalkisZamani().format(formatter),
                ucus.getVarisZamani().format(formatter),
                ucus.getUcak().getModel(),
                String.format("%.2f TL", ucus.getFiyat()),
                ucus.getDoluKoltukSayisi() + "/" + ucus.getUcak().getKoltukKapasitesi()
            });
        }

        // Rezervasyonlar tablosunu güncelle
        rezervasyonTableModel.setRowCount(0);
        for (Rezervasyon rezervasyon : rezervasyonlar) {
            rezervasyonTableModel.addRow(new Object[]{
                rezervasyon.getRezervasyonNo(),
                rezervasyon.getYolcuAdi() + " " + rezervasyon.getYolcuSoyadi(),
                rezervasyon.getUcus().getUcusNo(),
                rezervasyon.getRezervasyonTarihi().format(formatter),
                rezervasyon.isOnaylandi() ? "Onaylandı" : "Beklemede"
            });
        }
    }
} 