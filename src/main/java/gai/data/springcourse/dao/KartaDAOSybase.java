package gai.data.springcourse.dao;

import gai.data.springcourse.models.ArestSybase;
import gai.data.springcourse.models.KartaSybase;

import org.springframework.stereotype.Component;


import java.sql.*;
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

    public List<KartaSybase> searchKarta() throws SQLException {

        List<KartaSybase> kartaSybaseAMTList = new ArrayList<>();

        PreparedStatement preparedStatement = connectionSa.prepareStatement("SELECT * from karta WHERE id BETWEEN ? AND ?");

        try {
//            Warning:(42, 50) Method invocation 'executeQuery' may produce 'NullPointerException'

            {   long minId = 0L;
                long maxId = 41750000000308968L;

                System.out.println("minId - " + minId + "  maxId - " + maxId);
                for ( ;maxId < 51750000000308968L; ) {
                    preparedStatement.setLong(1,minId);
                    preparedStatement.setLong(2,maxId);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {

                        while (resultSet.next()) {
                            KartaSybase kartaSybaseAMT = new KartaSybase();
                            kartaSybaseAMT.setId(resultSet.getLong("id"));
                            kartaSybaseAMT.setKart_id(resultSet.getString("Kart_id"));
                            kartaSybaseAMT.setData_oper(resultSet.getDate("Data_oper").toLocalDate());
                            kartaSybaseAMT.setReg_def(resultSet.getInt("reg_def"));
                            kartaSybaseAMT.setNum_dv(resultSet.getString("num_dv"));
                            kartaSybaseAMT.setNum_cuz(resultSet.getString("num_cuz"));
                            kartaSybaseAMT.setNum_shas(resultSet.getString("num_shas"));
                            kartaSybaseAMT.setData_v(resultSet.getInt("data_v"));
                            kartaSybaseAMT.setColor(resultSet.getString("color"));
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
                            kartaSybaseAMT.setNom_naklad(resultSet.getInt("nom_naklad"));
                            try {
                                kartaSybaseAMT.setData_naklad(resultSet.getDate("data_naklad").toLocalDate());
                            } catch (NullPointerException e) {
//                        System.out.println(e.getMessage());
                                kartaSybaseAMT.setData_naklad(LocalDate.parse("1900-01-01"));
                            }
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
                            kartaSybaseAMT.setFname_lat(resultSet.getString("fname_lat"));
                            kartaSybaseAMT.setPermis(resultSet.getString("permis"));
                            try {
                                kartaSybaseAMT.setBorn(resultSet.getDate("born").toLocalDate());
                            } catch (NullPointerException e) {
//                        System.out.println(e.getMessage());
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
                            kartaSybaseAMT.setRajon_g(resultSet.getString("rajon_g"));
                            kartaSybaseAMT.setCity_g(resultSet.getString("city_g"));
                            kartaSybaseAMT.setStreet_g(resultSet.getString("street_g"));
                            kartaSybaseAMT.setCorp_g(resultSet.getString("corp_g"));
                            kartaSybaseAMT.setHouse_g(resultSet.getString("house_g"));
                            kartaSybaseAMT.setTel_g(resultSet.getString("tel_g"));
                            kartaSybaseAMT.setMasa1(resultSet.getInt("masa1"));

                            kartaDAOPostgres.addKarta(kartaSybaseAMT);
                        }
                    }
                    minId = maxId + 1;
                    maxId = maxId + 30000;

                    System.out.println("minId - " + minId + "  maxId - " + maxId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return kartaSybaseAMTList;
    }

    public List<ArestSybase> searchArest() throws SQLException {
        List<ArestSybase> arestSybaseList = new ArrayList<>();

        PreparedStatement preparedStatement = connectionSa.prepareStatement("SELECT * from arest");

        try (ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                ArestSybase arestSybase = new ArestSybase();
//                arestSybase.setId(resultSet.getLong("id"));
                arestSybase.setData_arest(resultSet.getDate("data_arest"));
                arestSybase.setKart_id(resultSet.getString("Kart_id"));
                arestSybase.setWho_na(resultSet.getString("who_na"));
                arestSybase.setIn_nom(resultSet.getString("in_nom"));
                arestSybase.setData_in(resultSet.getDate("data_in"));
                arestSybase.setData_sna(resultSet.getDate("data_sna"));
                arestSybase.setWho_sha(resultSet.getString("who_sha"));
                arestSybase.setOut_nom(resultSet.getString("out_nom"));
                arestSybase.setData_out(resultSet.getDate("data_out"));
                arestSybase.setOper_in(resultSet.getString("oper_in"));
                arestSybase.setOper_out(resultSet.getString("oper_out"));
                arestSybase.setVlad(resultSet.getString("vlad"));
                arestSybase.setIsh_answer1(resultSet.getInt("ish_answer1"));
                arestSybase.setIsh_answer1(resultSet.getInt("ish_answer2"));
                arestSybase.setK_nom1(resultSet.getString("k_nom1"));
                arestSybase.setK_data1(resultSet.getDate("k_data1"));
                arestSybase.setK_nom2(resultSet.getString("k_nom2"));
                arestSybase.setK_data2(resultSet.getDate("k_data2"));
                arestSybase.setCommenta(resultSet.getString("commenta"));
                arestSybase.setTime_fix(resultSet.getTimestamp("time_fix"));

                kartaDAOPostgres.addArest(arestSybase);
            }
        }

        return arestSybaseList;
    }
}
