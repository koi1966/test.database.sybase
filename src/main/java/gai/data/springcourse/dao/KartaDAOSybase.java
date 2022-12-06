package gai.data.springcourse.dao;

import gai.data.springcourse.models.KartaSybase;

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
public class KartaDAOSybase {

    private final KartaDAOPostgres kartaDAOPostgres;

    public KartaDAOSybase(KartaDAOPostgres kartaDAOPostgres) {
        this.kartaDAOPostgres = kartaDAOPostgres;
    }

    public List<KartaSybase> searchKarta() {

        List<KartaSybase> kartaSybaseAMTList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connectionSa.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        String SQLa = "SELECT * from gai.dbo.karta ";
        String SQLa = "SELECT * from gai.dbo.karta WHERE id BETWEEN 1 AND 6";

        try {

            try (ResultSet resultSet = statement.executeQuery(SQLa)) {

//                FileWriter writer = new FileWriter("c:/outputKarta.txt", true);

                while (resultSet.next()) {
                    KartaSybase kartaSybaseAMT = new KartaSybase();
//                    kartaSybaseAMT.setId(resultSet.getLong("id"));
                    kartaSybaseAMT.setKart_id(resultSet.getString("Kart_id"));
                    kartaSybaseAMT.setData_oper(resultSet.getDate("Data_oper").toLocalDate());
                    kartaSybaseAMT.setReg_def(resultSet.getInt("reg_def"));
                    kartaSybaseAMT.setNum_dv(resultSet.getString("num_dv"));
                    kartaSybaseAMT.setNum_cuz(resultSet.getString("num_cuz"));
                    kartaSybaseAMT.setNum_shas(resultSet.getString("num_shas"));
                    kartaSybaseAMT.setData_v(resultSet.getInt("Data_v"));
                    kartaSybaseAMT.setColor(resultSet.getString("Color"));
                    kartaSybaseAMT.setCuzov(resultSet.getString("cuzov"));
                    kartaSybaseAMT.setTip(resultSet.getString("tip"));
                    kartaSybaseAMT.setMarka(resultSet.getString("marka"));
                    kartaSybaseAMT.setModel(resultSet.getString("model"));
                    kartaSybaseAMT.setWho(resultSet.getInt("who"));
                    kartaSybaseAMT.setTeh_pasp(resultSet.getString("teh_pasp"));
                    kartaSybaseAMT.setType_zn(resultSet.getInt("type_zn"));
                    kartaSybaseAMT.setZnak(resultSet.getString("znak"));
                    kartaSybaseAMT.setAnnot(resultSet.getString("annot"));
                    kartaSybaseAMT.setCode_oper(resultSet.getString("code_oper"));
                    kartaSybaseAMT.setData_naklad(resultSet.getDate("data_naklad").toLocalDate());
                    kartaSybaseAMT.setMasa(resultSet.getInt("masa"));
                    kartaSybaseAMT.setStatus(resultSet.getInt("status"));
                    kartaSybaseAMT.setRegion(resultSet.getString("region"));
                    kartaSybaseAMT.setMinistr_name(resultSet.getString("ministr_name"));
                    kartaSybaseAMT.setInsp(resultSet.getString("insp"));
                    kartaSybaseAMT.setIspekt_osm(resultSet.getString("ispekt_osm"));
                    kartaSybaseAMT.setWho_out(resultSet.getString("who_out"));
                    kartaSybaseAMT.setRegim(resultSet.getInt("regim"));
                    kartaSybaseAMT.setPower(resultSet.getString("power"));
                    kartaSybaseAMT.setVolume(resultSet.getString("volume"));
                    kartaSybaseAMT.setCylinder(resultSet.getString("cylinder"));
                    kartaSybaseAMT.setDoor(resultSet.getString("door"));
                    kartaSybaseAMT.setFuel(resultSet.getString("fuel"));
                    kartaSybaseAMT.setPlace(resultSet.getString("place"));
                    kartaSybaseAMT.setTom(resultSet.getString("tom"));
                    kartaSybaseAMT.setSob_id(resultSet.getString("sob_id"));
                    kartaSybaseAMT.setFamily(resultSet.getString("family"));
                    kartaSybaseAMT.setFname(resultSet.getString("fname"));
                    kartaSybaseAMT.setSec_name(resultSet.getString("sec_name"));
                    kartaSybaseAMT.setFamily_lat(resultSet.getString("family_lat"));
                    kartaSybaseAMT.setPermis(resultSet.getString("permis"));

                    try {
                        kartaSybaseAMT.setBorn(resultSet.getDate("born").toLocalDate());
                    } catch (NullPointerException e) {
                            System.out.println(e.getMessage());
                        kartaSybaseAMT.setBorn(LocalDate.parse("1900-01-01"));
                    }

                    kartaSybaseAMT.setPasport(resultSet.getString("pasport"));
                    kartaSybaseAMT.setPasp_cto(resultSet.getString("pasp_cto"));
                    kartaSybaseAMT.setObl(resultSet.getString("obl"));
                    kartaSybaseAMT.setRajon(resultSet.getString("rajon"));
                    kartaSybaseAMT.setCity(resultSet.getString("city"));
                    kartaSybaseAMT.setStreet(resultSet.getString("street"));
                    kartaSybaseAMT.setHouse(resultSet.getString("house"));
                    kartaSybaseAMT.setCorp(resultSet.getString("corp"));
                    kartaSybaseAMT.setKv(resultSet.getString("kv"));
                    kartaSybaseAMT.setTel(resultSet.getString("tel"));
                    kartaSybaseAMT.setTel_work(resultSet.getString("tel_work"));
                    kartaSybaseAMT.setOffice(resultSet.getString("office"));
                    kartaSybaseAMT.setDolj(resultSet.getString("dolj"));
                    kartaSybaseAMT.setObl_g(resultSet.getString("obl_g"));
                    kartaSybaseAMT.setFname(resultSet.getString("rajon_g"));
                    kartaSybaseAMT.setCity_g(resultSet.getString("city_g"));
                    kartaSybaseAMT.setStreet_g(resultSet.getString("street_g"));
                    kartaSybaseAMT.setCorp_g(resultSet.getString("corp_g"));
                    kartaSybaseAMT.setHouse_g(resultSet.getString("house_g"));
                    kartaSybaseAMT.setTel_g(resultSet.getString("tel_g"));
                    kartaSybaseAMT.setMasa1(resultSet.getInt("masa1"));

//                    kartaSybaseAMTList.add(kartaSybaseAMT);

                    // Add to Postgres
                    kartaDAOPostgres.addKarta(kartaSybaseAMT);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return kartaSybaseAMTList;
    }
}
