# Otonom Filo Sistemi

Java ile hazırlanmış, otonom araç filosu, görevler ve personel arasındaki ilişkileri örnekleyen komut satırı uygulaması.

## Örneklenen yapılar

- Araç türleri ve araçlara eklenebilen modüller
- Personel rolleri: mühendis, teknisyen ve yönetici
- Araçlara ve personele atanan görevler
- Görev açıklamasında anahtar kelime arama
- Filo durum raporu ve araç şarj işlemi

Ana sınıflar `src` dizinindedir. Programın giriş noktası `JavaApplication14` sınıfıdır.

## Gereksinimler

- JDK (Java Development Kit)

## Derleme ve çalıştırma

Proje kök dizininde:

```bash
javac -d out src/*.java
java -cp out JavaApplication14
```

Uygulama örnek araç, personel ve görev kayıtlarıyla başlar ve sonuçları terminale yazar.
