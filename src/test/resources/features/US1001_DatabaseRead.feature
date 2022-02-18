Feature: US1001 Kullanici Database'e baglanip bilgileri okuyabilir
  @db
  Scenario: Kullanici Database'e baglanip istedigi bilgileri okuyabilir


    Given kullanici HMC veri tabanina baglanir
    And kullanici "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici "Price" sutunundaki verileri okur
