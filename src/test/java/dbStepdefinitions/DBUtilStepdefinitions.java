package dbStepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class DBUtilStepdefinitions {

    @Given("kullanici DBUtil ile HMC veri tabanina baglanir")
    public void kullanici_db_util_ile_hmc_veri_tabanina_baglanir() {
        DBUtils.getConnection();
    }
    @Given("kullanici DBUtil ile {string} tablosundaki {string} verilerini alir")
    public void kullanici_db_util_ile_tablosundaki_verilerini_alir(String table, String field) {
        String queryStr="SELECT "+field+" FROM "+table;
        DBUtils.executeQuery(queryStr);
    }
    @Given("kullanici DBUtil ile {string} sutunundaki verileri okur")
    public void kullanici_db_util_ile_sutunundaki_verileri_okur(String field) throws SQLException {
        DBUtils.getResultset().first();

    }
    @Given("DBUtil ile tum {string} degerlerini sira numarasi ile yazdirir")
    public void db_util_ile_tum_degerlerini_sira_numarasi_ile_yazdirir(String field) throws Exception {
        int satirSayisi=DBUtils.getRowCount();
        int siraNo=1;
        DBUtils.getResultset().first();
        for (int i = 1; i <satirSayisi ; i++) {
            System.out.println(i+" satirdaki "+field+" : "+DBUtils.getResultset().getString(field));
            DBUtils.getResultset().next();
            siraNo++;
        }
    }
    @Then("DBUtill ile {int}. {string} in {int} oldugunu test eder")
    public void db_utill_ile_in_oldugunu_test_eder(Integer siraNo, String field, Integer expectedPrice) throws SQLException {
        DBUtils.getResultset().absolute(siraNo);
        double actualPrice=DBUtils.getResultset().getDouble(field);
        Assert.assertTrue(actualPrice==expectedPrice);
    }


}
