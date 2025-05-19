# ✈️ Uçak Bilet Rezervasyon Sistemi( Final Ödevi BIP1026)

Bu proje, Java programlama dili kullanılarak geliştirilmiş basit bir uçak bilet rezervasyon sistemidir. Sistem, kullanıcıların uçuşları görüntülemesine ve bilet rezervasyonu yapmasına olanak sağlar.

## 🚀 Özellikler

- Uçuş listesi görüntüleme  
- Yeni rezervasyon yapma  
- Rezervasyon geçmişi görüntüleme  
- Koltuk doluluk oranı takibi  
- İç ve dış hat uçuşları desteği  
- Basit ve anlaşılır konsol arayüzü  

## 🛠️ Sistem Gereksinimleri

- Java Development Kit (JDK) 8 veya üzeri  
- Herhangi bir işletim sistemi (Windows, macOS, Linux)  

## ⚙️ Kurulum

1. Projeyi bilgisayarınıza indirin veya klonlayın:
   ```bash
   git clone https://github.com/kizilsamuray/ucak-rezervasyon.git
   cd ucak-rezervasyon
2-data klasörünü oluşturun:

mkdir data

3-Java dosyalarını derleyin:

javac src/*.java src/entity/*.java

4-Programı çalıştırın:

java -cp src Main

🎮 Kullanım
Program çalıştığında kullanıcıya konsol üzerinden aşağıdaki seçenekler sunulur:

Uçuşları Listele

Tüm mevcut uçuşları listeler.

Kalkış/varış noktaları, saat, uçak tipi gibi bilgiler görüntülenir.

Yeni Rezervasyon Yap

Uygun bir uçuş seçilir.

Kullanıcıdan ad, soyad, yaş bilgileri alınır.

Koltuk kapasitesi kontrol edilir, uygunluk varsa rezervasyon yapılır.

Rezervasyonları Listele

Mevcut rezervasyonları listeler.

Uçuş bilgileri ve yolcu bilgileri görüntülenir.

Çıkış

Uygulamadan çıkılır.

✈️ Uçuş Bilgileri
Sistem şu anda aşağıdaki uçuşları içermektedir:

İç Hat Uçuşları
İstanbul - Ankara (TK1001)

Ankara - İzmir (TK1002)

İzmir - İstanbul (TK1003)

İstanbul - Antalya (TK1004)

Antalya - Ankara (TK1005)

Dış Hat Uçuşları
İstanbul - Londra (TK2001)

İstanbul - Paris (TK2002)

İstanbul - Roma (TK2003)

İstanbul - Dubai (TK2004)

Dubai - Londra (TK2005)

🛩️ Uçak Filosu
Uçak Modeli	Marka	Koltuk Kapasitesi
Boeing 737	Boeing	150
Airbus A320	Airbus	180
Boeing 777	Boeing	300
Airbus A350	Airbus	250

💾 Veri Saklama
Sistem verileri aşağıdaki dosyalarda saklar:

data/ucuslar.txt → Uçuş bilgileri

data/rezervasyonlar.txt → Rezervasyon bilgileri

Alternatif olarak .csv, .json veya .xml formatlarına dönüştürülebilir (isteğe bağlı).
