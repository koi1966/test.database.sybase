package gai.data.springcourse.dao;


import gai.data.springcourse.models.KartaAMT;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static gai.data.springcourse.bl.DataDAO.connectionSa;

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
        String SQLa = "SELECT * from karta where znak  like " + "'"+ kar.getZnak()+ "'";
        try (ResultSet resultSet = statement.executeQuery(SQLa)) {
            while (resultSet.next()) {
                KartaAMT AMT = new KartaAMT();
                AMT.setKart_id(resultSet.getString("Kart_id"));
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

    public List<KartaAMT> index() {
        List<KartaAMT> karta = new ArrayList<>();
        try {

            Statement statement = connectionSa.createStatement();
//            String SQL = "SELECT * FROM Person";
            String SQL = "select * from karta where znak='49910ВВ'";
            try (ResultSet resultSet = statement.executeQuery(SQL)) {
                while (resultSet.next()) {
                    KartaAMT AMT = new KartaAMT();
                    AMT.setKart_id (resultSet.getString("Kart_id"));
                    AMT.setId(resultSet.getLong("id"));
                    AMT.setFamily(resultSet.getString("Family"));
                    AMT.setFname(resultSet.getString("Fname"));
                    AMT.setData_oper (resultSet.getDate("Data_oper"));
                    AMT.setSec_name(resultSet.getString("Sec_name"));
                    AMT.setColor(resultSet.getString("Color"));
                    AMT.setData_v(resultSet.getString("Data_v"));
                    AMT.setMarka(resultSet.getString("Marka"));
                    AMT.setModel(resultSet.getString("Model"));
                    AMT.setZnak(resultSet.getString("Znak"));
                    AMT.setTeh_pasp(resultSet.getString("Teh_pasp"));
                    AMT.setNum_cuz(resultSet.getString("Num_cuz"));
                    //                person.setAge(resultSet.getInt("age"));
 //                   System.out.println(resultSet.getString("Znak"));
                    karta.add(AMT);
                }
  //              System.out.println("Fig_tam");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return karta;
    }
 }


