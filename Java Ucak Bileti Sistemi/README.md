✈️ Uçak Bilet Rezervasyon Sistemi
Bu proje, Java programlama dili kullanılarak geliştirilmiş basit bir uçak bilet rezervasyon sistemidir. Sistem, kullanıcıların uçuşları görüntülemesine ve bilet rezervasyonu yapmasına olanak sağlar.

🚀 Özellikler
Uçuş listesi görüntüleme

Yeni rezervasyon yapma

Rezervasyon geçmişi görüntüleme

Koltuk doluluk oranı takibi

İç ve dış hat uçuşları desteği

Kullanıcı dostu grafiksel arayüz
codewithcurious.com

🛠️ Sistem Gereksinimleri
Java Development Kit (JDK) 8 veya üzeri

Herhangi bir işletim sistemi (Windows, macOS, Linux)

⚙️ Kurulum
Projeyi bilgisayarınıza indirin veya klonlayın:

bash
Kopyala
Düzenle
git clone https://github.com/kizilsamuray/ucak-rezervasyon.git
cd ucak-rezervasyon
data klasörünü oluşturun:

bash
Kopyala
Düzenle
mkdir data
Java dosyalarını derleyin:

bash
Kopyala
Düzenle
javac src/*.java src/entity/*.java
Programı çalıştırın:
GitHub
+4
arXiv
+4
arXiv
+4

bash
Kopyala
Düzenle
java -cp src Main
🎮 Kullanım
Program başlatıldığında üç sekme içeren bir arayüz açılır:

Uçuşlar Sekmesi

Mevcut tüm uçuşları listeler

Uçuş detaylarını (kalkış, varış, zaman, fiyat vb.) gösterir

Koltuk doluluk oranlarını takip eder

Rezervasyon Yap Sekmesi

Uçuş seçimi

Yolcu bilgileri girişi (ad, soyad, yaş)

Rezervasyon onayı

Rezervasyonlar Sekmesi

Tüm rezervasyonları listeler

Rezervasyon durumlarını gösterir

Rezervasyon detaylarını görüntüler

✈️ Uçuş Bilgileri
Sistem şu anda aşağıdaki uçuşları içermektedir:

İç Hat Uçuşları
İstanbul-Ankara (TK1001)

Ankara-İzmir (TK1002)

İzmir-İstanbul (TK1003)

İstanbul-Antalya (TK1004)

Antalya-Ankara (TK1005)

Dış Hat Uçuşları
İstanbul-Londra (TK2001)

İstanbul-Paris (TK2002)

İstanbul-Roma (TK2003)

İstanbul-Dubai (TK2004)

Dubai-Londra (TK2005)

🛩️ Uçak Filosu
Boeing 737 (150 koltuk)

Airbus A320 (180 koltuk)

Boeing 777 (300 koltuk)

Airbus A350 (250 koltuk)

💾 Veri Saklama
Sistem, uçuş ve rezervasyon bilgilerini data klasörü altında metin dosyalarında saklar:

data/ucuslar.txt: Uçuş bilgileri

data/rezervasyonlar.txt: Rezervasyon bilgileri

👨‍💻 Geliştirici
Bu proje, Java programlama dili öğrenme sürecinde geliştirilmiştir. Projeyi geliştirmek veya katkıda bulunmak isterseniz, lütfen bir issue açın veya pull request gönderin.

GitHub: github.com/kizilsamuray

E-posta: Akersemih07@gmail.com