package gai.data.springcourse.dao;

import gai.data.springcourse.models.KartaSybase;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static gai.data.springcourse.bl.DataDAOPostgres.connectionPos;

@Component
public class KartaDAOPostgres {

    public void addKarta(KartaSybase kartaS) {

        try {
            PreparedStatement statementPostgres = connectionPos.prepareStatement("INSERT INTO karta (id, kart_id, data_oper,reg_def," +
                    "num_dv,num_cuz,num_shas,data_v,color,cuzov,tip,marka,model,who,teh_pasp,type_zn,znak,annot," +
                    "code_oper,nom_naklad,data_naklad,masa,status,region,ministr_name,insp,ispekt_osm,who_out,regim," +
                    "power,volume,cylinder,door,fuel,place,tom,sob_id,family,fname,sec_name,family_lat,fname_lat,permis," +
                    "born,pasport,pasp_cto,obl,rajon,city,street,house,corp,kv,tel,tel_work,office,dolj,obl_g,rajon_g," +
                    "city_g,street_g,corp_g,house_g,tel_g,masa1) " +
                    "Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            statementPostgres.setLong(1, kartaS.getId());
            statementPostgres.setString(2, kartaS.getKart_id());
            statementPostgres.setDate(3, Date.valueOf(kartaS.getData_oper()));
            statementPostgres.setInt(4, kartaS.getReg_def());
            statementPostgres.setString(5, kartaS.getNum_dv());
            statementPostgres.setString(6, kartaS.getNum_cuz());
            statementPostgres.setString(7, kartaS.getNum_shas());
            statementPostgres.setInt(8, kartaS.getData_v());
            statementPostgres.setString(9, kartaS.getColor());
            statementPostgres.setString(10, kartaS.getCuzov());
            statementPostgres.setString(11, kartaS.getTip());
            statementPostgres.setString(12, kartaS.getMarka());
            statementPostgres.setString(13, kartaS.getModel());
            statementPostgres.setInt(14, kartaS.getWho());
            statementPostgres.setString(15, kartaS.getTeh_pasp());
            statementPostgres.setInt(16, kartaS.getType_zn());
            statementPostgres.setString(17, kartaS.getZnak());
            statementPostgres.setString(18, kartaS.getAnnot());
            statementPostgres.setString(19, kartaS.getCode_oper());
            statementPostgres.setInt(20, kartaS.getNom_naklad());
            statementPostgres.setDate(21, Date.valueOf(kartaS.getData_naklad()));
            statementPostgres.setInt(22, kartaS.getMasa());
            statementPostgres.setInt(23, kartaS.getStatus());
            statementPostgres.setString(24, kartaS.getRegion());
            statementPostgres.setString(25, kartaS.getMinistr_name());
            statementPostgres.setString(26, kartaS.getInsp());
            statementPostgres.setString(27, kartaS.getIspekt_osm());
            statementPostgres.setString(28, kartaS.getWho_out());
            statementPostgres.setInt(29, kartaS.getRegim());
            statementPostgres.setString(30, kartaS.getPower());
            statementPostgres.setString(31, kartaS.getVolume());
            statementPostgres.setString(32, kartaS.getCylinder());
            statementPostgres.setString(33, kartaS.getDoor());
            statementPostgres.setString(34, kartaS.getFuel());
            statementPostgres.setString(35, kartaS.getPlace());
            statementPostgres.setString(36, kartaS.getTom());
            statementPostgres.setString(37, kartaS.getSob_id());
            statementPostgres.setString(38, kartaS.getFamily());
            statementPostgres.setString(39, kartaS.getFname());
            statementPostgres.setString(40, kartaS.getSec_name());
            statementPostgres.setString(41, kartaS.getFamily_lat());
            statementPostgres.setString(42, kartaS.getFname_lat());
            statementPostgres.setString(43, kartaS.getPermis());
            statementPostgres.setDate(44, Date.valueOf(kartaS.getBorn()));
            statementPostgres.setString(45, kartaS.getPasport());
            statementPostgres.setString(46, kartaS.getPasp_cto());
            statementPostgres.setString(47, kartaS.getObl());
            statementPostgres.setString(48, kartaS.getRajon());
            statementPostgres.setString(49, kartaS.getCity());
            statementPostgres.setString(50, kartaS.getStreet());
            statementPostgres.setString(51, kartaS.getHouse());
            statementPostgres.setString(52, kartaS.getCorp());
            statementPostgres.setString(53, kartaS.getKv());
            statementPostgres.setString(54, kartaS.getTel());
            statementPostgres.setString(55, kartaS.getTel_work());
            statementPostgres.setString(56, kartaS.getOffice());
            statementPostgres.setString(57, kartaS.getDolj());
            statementPostgres.setString(58, kartaS.getObl_g());
            statementPostgres.setString(59, kartaS.getRajon_g());
            statementPostgres.setString(60, kartaS.getCity_g());
            statementPostgres.setString(61, kartaS.getStreet_g());
            statementPostgres.setString(62, kartaS.getCorp_g());
            statementPostgres.setString(63, kartaS.getHouse_g());
            statementPostgres.setString(64, kartaS.getTel_g());
            statementPostgres.setInt(65, kartaS.getMasa1());
//            statementPostgres.executeUpdate();
            int num =statementPostgres.executeUpdate();
//            System.out.print(num);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
