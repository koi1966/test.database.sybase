package gai.data.springcourse.dao;


import gai.data.springcourse.models.KartaAMT;
import org.springframework.stereotype.Component;
import java.sql.PreparedStatement;
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

    public List<KartaAMT> AmtHistory(String Kart_id){
        List<KartaAMT> kartHistory = new ArrayList<>();

//        Statement statement = null;
        try {
            PreparedStatement preparedStatement =
                    connectionSa.prepareStatement("SELECT * FROM karta WHERE kart_id=?");
            preparedStatement.setString(1, Kart_id );
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    KartaAMT AMTh = new KartaAMT();
                    AMTh.setKart_id(resultSet.getString("Kart_id"));
                    AMTh.setId(resultSet.getLong("id"));
                    AMTh.setFamily(resultSet.getString("Family"));
                    AMTh.setFname(resultSet.getString("Fname"));
                    AMTh.setData_oper(resultSet.getDate("Data_oper"));
                    AMTh.setSec_name(resultSet.getString("Sec_name"));
                    AMTh.setColor(resultSet.getString("Color"));
                    AMTh.setData_v(resultSet.getString("Data_v"));
                    AMTh.setMarka(resultSet.getString("Marka"));
                    AMTh.setModel(resultSet.getString("Model"));
                    AMTh.setZnak(resultSet.getString("Znak"));
                    AMTh.setTeh_pasp(resultSet.getString("Teh_pasp"));
                    AMTh.setNum_cuz(resultSet.getString("Num_cuz"));
                    kartHistory.add(AMTh);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return kartHistory;
    }

}


