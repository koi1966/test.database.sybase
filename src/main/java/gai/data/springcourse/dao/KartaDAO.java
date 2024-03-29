package gai.data.springcourse.dao;

import static gai.data.springcourse.bl.DataDAO.connectionSa;

import gai.data.springcourse.models.KartaAMT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class KartaDAO {

  public List<KartaAMT> serch(KartaAMT kar) {

    List<KartaAMT> kart = new ArrayList<>();

    Statement statement = null;
    try {
      statement = connectionSa.createStatement();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    String SQLa = "SELECT * from karta where ";
    if (!kar.getZnak().isEmpty()) {
      SQLa = SQLa + "znak like '" + kar.getZnak() + "' ";
    }

    if (!kar.getTeh_pasp().isEmpty()) {
      SQLa = SQLa + "Teh_pasp like '" + kar.getTeh_pasp() + "' ";
    }

    SQLa = SQLa + "ORDER BY Data_oper, kart_id";

    try (ResultSet resultSet = statement.executeQuery(SQLa)) {
      while (resultSet.next()) {
        KartaAMT AMT = new KartaAMT();
        AMT.setKart_id(resultSet.getString("Kart_id"));
        String vv = resultSet.getString("Kart_id");
        AMT.setId(resultSet.getLong("id"));
        AMT.setFamily(resultSet.getString("Family"));
        AMT.setFname(resultSet.getString("Fname"));
        AMT.setData_oper(resultSet.getDate("Data_oper"));
        AMT.setSec_name(resultSet.getString("Sec_name"));
        AMT.setColor(resultSet.getString("Color"));
        AMT.setData_v(resultSet.getString("Data_v"));
        AMT.setMarka(resultSet.getString("Marka"));
        AMT.setModel(resultSet.getString("Model"));
        AMT.setZnak(resultSet.getString("Znak"));
        AMT.setTeh_pasp(resultSet.getString("Teh_pasp"));
        AMT.setNum_cuz(resultSet.getString("Num_cuz"));
        kart.add(AMT);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return kart;
  }

  public List<KartaAMT> AmtHistory(long id) {
    List<KartaAMT> kartHistory = new ArrayList<>();
    //        Statement statement = null;
    String SQL =
        "" //
            + "select id,Kart_id,Data_oper,Data_v,Znak,kv,Teh_pasp,Family,Fname,Sec_name,house,street,city,rajon,obl," //
            + "Znak,Teh_pasp,Color,(Marka + ' '+Model)as Marka,reverse(karta.num_cuz) as Num_cuz," //
            + "reverse(karta.num_shas) as Num_shas,reverse(karta.num_Dv) as num_Dv, oper.*  " //
            + "from karta, oper " //
            + "where kart_id in (Select k2.kart_id from karta k2 where k2.id=?) "
            + "and substring(karta.code_oper,1,2)=oper.oper_id  "
            + "ORDER BY Data_oper";

    //   "select
    // id,Kart_id,Data_oper,Data_v,Znak,kv,Teh_pasp,Family,Fname,Sec_name,house,street,city,rajon,obl,Znak,Teh_pasp,Color,(Marka + ' '+Model)as Marka,reverse(karta.num_cuz) as Num_cuz,reverse(karta.num_shas) as Num_shas,reverse(karta.num_Dv) as num_Dv, oper.*  from karta, oper where kart_id in (Select k2.kart_id from karta k2 where k2.id=?) and substring(karta.code_oper,1,2)=oper.oper_id  ORDER BY Data_oper";
    try {
      PreparedStatement preparedStatement = connectionSa.prepareStatement(SQL);
      preparedStatement.setLong(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          KartaAMT AMTh = new KartaAMT();
          AMTh.setId(resultSet.getLong("id"));
          AMTh.setKart_id(resultSet.getString("Kart_id"));
          AMTh.setData_oper(resultSet.getDate("Data_oper"));
          AMTh.setZnak(resultSet.getString("Znak"));
          AMTh.setTeh_pasp(resultSet.getString("Teh_pasp"));
          AMTh.setNum_cuz(resultSet.getString("Num_cuz"));
          AMTh.setNum_shas(resultSet.getString("Num_shas"));
          AMTh.setNum_dv(resultSet.getString("Num_dv"));
          AMTh.setData_v(resultSet.getString("Data_v"));
          AMTh.setColor(resultSet.getString("Color"));
          AMTh.setMarka(resultSet.getString("Marka"));
          AMTh.setFamily(resultSet.getString("Family"));
          AMTh.setFname(resultSet.getString("Fname"));
          AMTh.setSec_name(resultSet.getString("Sec_name"));
          AMTh.setOper(resultSet.getString("oper"));
          AMTh.setObl(resultSet.getString("obl"));
          AMTh.setRajon(resultSet.getString("rajon"));
          AMTh.setCity(resultSet.getString("city"));
          AMTh.setStreet(resultSet.getString("street"));
          AMTh.setHouse(resultSet.getString("house"));
          AMTh.setKv(resultSet.getString("kv"));
          AMTh.setOper(resultSet.getString("oper"));

          kartHistory.add(AMTh);
        }
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return kartHistory;
  }
}
