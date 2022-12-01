package gai.data.springcourse.dao;

import gai.data.springcourse.models.Karta;

import org.springframework.stereotype.Component;


import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static gai.data.springcourse.bl.DataDAO.connectionSa;

@Component
public class KartaDAOExport {
    public List<Karta> searchKarta() {

        List<Karta> kartaAMTList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connectionSa.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        String SQLa = "SELECT * from gai.dbo.karta ";
        String SQLa = "SELECT * from gai.dbo.karta WHERE id BETWEEN 501 AND 1500";

//        String SQLa = "SELECT * from gai.dbo.karta where znak = "+" '"+ "АМ3223ВА'";
        try {

            //  Warning:(31, 47) Method invocation 'executeQuery' may produce 'NullPointerException'
            try (ResultSet resultSet = statement.executeQuery(SQLa)) {

                FileWriter writer = new FileWriter("c:/outputKarta.txt", true);

                while (resultSet.next()) {
                    Karta KartaAMT = new Karta();
                    KartaAMT.setId(resultSet.getLong("id"));
                    KartaAMT.setKart_id(resultSet.getString("Kart_id"));
                    KartaAMT.setData_oper(resultSet.getDate("Data_oper").toLocalDate());
                    KartaAMT.setReg_def(resultSet.getInt("reg_def"));
                    KartaAMT.setNum_dv(resultSet.getString("num_dv"));
                    KartaAMT.setNum_cuz(resultSet.getString("num_cuz"));
                    KartaAMT.setNum_shas(resultSet.getString("num_shas"));
                    KartaAMT.setData_v(resultSet.getInt("Data_v"));
                    KartaAMT.setColor(resultSet.getString("Color"));
                    KartaAMT.setCuzov(resultSet.getString("cuzov"));
                    KartaAMT.setTip(resultSet.getString("tip"));
                    KartaAMT.setMarka(resultSet.getString("marka"));
                    KartaAMT.setModel(resultSet.getString("model"));
                    KartaAMT.setWho(resultSet.getInt("who"));
                    KartaAMT.setTeh_pasp(resultSet.getString("teh_pasp"));
                    KartaAMT.setType_zn(resultSet.getInt("type_zn"));
                    KartaAMT.setZnak(resultSet.getString("znak"));
                    KartaAMT.setAnnot(resultSet.getString("annot"));
                    KartaAMT.setCode_oper(resultSet.getString("code_oper"));
                    KartaAMT.setData_naklad(resultSet.getDate("data_naklad").toLocalDate());
                    KartaAMT.setMasa(resultSet.getInt("masa"));
                    KartaAMT.setStatus(resultSet.getInt("status"));
                    KartaAMT.setRegion(resultSet.getString("region"));
                    KartaAMT.setMinistr_name(resultSet.getString("ministr_name"));
                    KartaAMT.setInsp(resultSet.getString("insp"));
                    KartaAMT.setIspekt_osm(resultSet.getString("ispekt_osm"));
                    KartaAMT.setWho_out(resultSet.getString("who_out"));
                    KartaAMT.setRegim(resultSet.getInt("regim"));
                    KartaAMT.setPower(resultSet.getString("power"));
                    KartaAMT.setVolume(resultSet.getString("volume"));
                    KartaAMT.setCylinder(resultSet.getString("cylinder"));
                    KartaAMT.setDoor(resultSet.getString("door"));
                    KartaAMT.setFuel(resultSet.getString("fuel"));
                    KartaAMT.setPlace(resultSet.getString("place"));
                    KartaAMT.setTom(resultSet.getString("tom"));
                    KartaAMT.setSob_id(resultSet.getString("sob_id"));
                    KartaAMT.setFamily(resultSet.getString("family"));
                    KartaAMT.setFname(resultSet.getString("fname"));
                    KartaAMT.setSec_name(resultSet.getString("sec_name"));
                    KartaAMT.setFamily_lat(resultSet.getString("family_lat"));
                    KartaAMT.setPermis(resultSet.getString("permis"));

                    try {
                        KartaAMT.setBorn(resultSet.getDate("born").toLocalDate());
                    } catch (NullPointerException e) {
                            System.out.println(e.getMessage());
                        KartaAMT.setBorn(LocalDate.parse("1900-01-01"));
                    }

                    KartaAMT.setPasport(resultSet.getString("pasport"));
                    KartaAMT.setPasp_cto(resultSet.getString("pasp_cto"));
                    KartaAMT.setObl(resultSet.getString("obl"));
                    KartaAMT.setRajon(resultSet.getString("rajon"));
                    KartaAMT.setCity(resultSet.getString("city"));
                    KartaAMT.setStreet(resultSet.getString("street"));
                    KartaAMT.setHouse(resultSet.getString("house"));
                    KartaAMT.setCorp(resultSet.getString("corp"));
                    KartaAMT.setKv(resultSet.getString("kv"));
                    KartaAMT.setTel(resultSet.getString("tel"));
                    KartaAMT.setTel_work(resultSet.getString("tel_work"));
                    KartaAMT.setOffice(resultSet.getString("office"));
                    KartaAMT.setDolj(resultSet.getString("dolj"));
                    KartaAMT.setObl_g(resultSet.getString("obl_g"));
                    KartaAMT.setFname(resultSet.getString("rajon_g"));
                    KartaAMT.setCity_g(resultSet.getString("city_g"));
                    KartaAMT.setStreet_g(resultSet.getString("street_g"));
                    KartaAMT.setCorp_g(resultSet.getString("corp_g"));
                    KartaAMT.setHouse_g(resultSet.getString("house_g"));
                    KartaAMT.setTel_g(resultSet.getString("tel_g"));
                    KartaAMT.setMasa1(resultSet.getInt("masa1"));

                    kartaAMTList.add(KartaAMT);
                    // Write to file
//                    System.out.println(kartaAMTList.toString());
//                    fr.write("kartaAMTList.toString()");
                    writer.write(kartaAMTList.toString()+"\n");

                    writer.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(kartaAMTList.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return kartaAMTList;
    }
}
