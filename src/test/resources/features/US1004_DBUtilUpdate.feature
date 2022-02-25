Feature: US1004 Kullanici kayitlari update eder
  Scenario: TC04 Kullanici tablo IDHotel degerleri verilen Email'i update edebilmeli
    Given kullanici DBUtil ile HMC veri tabanina baglanir
    Then IDHotel degeri 1016 olan kaydin Email bilgisini "hoscakal@gmail.com" yapar