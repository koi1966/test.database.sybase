package gai.data.springcourse.dao;

import gai.data.springcourse.models.KartaSybase;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static gai.data.springcourse.bl.DataDAOPostgres.connectionPos;

@Component
public class KartaDAOPostgres {

//    private final KartaSybase kartaDAOSybase;

//    public KartaDAOPostgres(KartaSybase kartaDAOSybase) {
//        this.kartaDAOSybase = kartaDAOSybase;
//    }

    public void addKarta(KartaSybase kartaS) {
//        PreparedStatement statementPostgres = null;
        {
            try {
                PreparedStatement statementPostgres = connectionPos.prepareStatement("INSERT INTO karta (kart_id, data_oper,reg_def," +
                        "num_dv,num_cuz,num_shas,data_v,color,cuzov,tip,marka,model,who,teh_pasp,type_zn,znak,annot," +
                        "code_oper,nom_naklad,data_naklad,masa,status,region,ministr_name,insp,ispekt_osm,who_out,regim," +
                        "power,volume,cylinder,door,fuel,place,tom,sob_id,family,fname,sec_name,family_lat,fname_lat,permis," +
                        "born,pasport,pasp_cto,obl,rajon,city,street,house,corp,kv,tel,tel_work,office,dolj,obl_g,rajon_g," +
                        "city_g,street_g,corp_g,house_g,tel_g,masa1) " +
                        "Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                statementPostgres.setString(1, kartaS.getKart_id());
                statementPostgres.setDate(2, Date.valueOf(kartaS.getData_oper()));
                statementPostgres.setInt(3, kartaS.getReg_def());
                statementPostgres.setString(4, kartaS.getNum_dv());
                statementPostgres.setString(5, kartaS.getNum_cuz());
                statementPostgres.setString(6, kartaS.getNum_shas());
                statementPostgres.setInt(7, kartaS.getData_v());
                statementPostgres.setString(8, kartaS.getColor());
                statementPostgres.setString(9, kartaS.getCuzov());
                statementPostgres.setString(10, kartaS.getTip());
                statementPostgres.setString(11, kartaS.getMarka());
                statementPostgres.setString(12, kartaS.getModel());
                statementPostgres.setInt(13, kartaS.getWho());
                statementPostgres.setString(14, kartaS.getTeh_pasp());
                statementPostgres.setInt(15, kartaS.getType_zn());
                statementPostgres.setString(16, kartaS.getZnak());
                statementPostgres.setString(17, kartaS.getAnnot());
                statementPostgres.setString(18, kartaS.getCode_oper());
                statementPostgres.setInt(19, kartaS.getNom_naklad());
                statementPostgres.setDate(20, Date.valueOf(kartaS.getData_naklad()));
                statementPostgres.setInt(21, kartaS.getMasa());
                statementPostgres.setInt(22, kartaS.getStatus());
                statementPostgres.setString(23, kartaS.getRajon());
                statementPostgres.setString(24, kartaS.getMinistr_name());
                statementPostgres.setString(25, kartaS.getInsp());
                statementPostgres.setString(26, kartaS.getIspekt_osm());
                statementPostgres.setInt(27, kartaS.getRegim());
                statementPostgres.setString(28, kartaS.getPower());
                statementPostgres.setString(29, kartaS.getVolume());
                statementPostgres.setString(30, kartaS.getCylinder());
                statementPostgres.setString(31, kartaS.getDoor());
                statementPostgres.setString(32, kartaS.getFuel());
                statementPostgres.setString(33, kartaS.getPlace());
                statementPostgres.setString(34, kartaS.getTom());
                statementPostgres.setString(35, kartaS.getSob_id());
                statementPostgres.setString(36, kartaS.getFamily());
                statementPostgres.setString(37, kartaS.getFname());
                statementPostgres.setString(38, kartaS.getSec_name());
                statementPostgres.setString(39, kartaS.getFamily_lat());
                statementPostgres.setString(40, kartaS.getPermis());
                statementPostgres.setDate(41, Date.valueOf(kartaS.getBorn()));
                statementPostgres.setString(42, kartaS.getPasport());
                statementPostgres.setString(43, kartaS.getPasp_cto());
                statementPostgres.setString(44, kartaS.getObl());
                statementPostgres.setString(45, kartaS.getRegion());
                statementPostgres.setString(46, kartaS.getCity());
                statementPostgres.setString(47, kartaS.getStreet());
                statementPostgres.setString(48, kartaS.getHouse());
                statementPostgres.setString(49, kartaS.getCorp());
                statementPostgres.setString(50, kartaS.getKv());
                statementPostgres.setString(51, kartaS.getTel());
                statementPostgres.setString(52, kartaS.getTel_work());
                statementPostgres.setString(53, kartaS.getOffice());
                statementPostgres.setString(54, kartaS.getDolj());
                statementPostgres.setString(55, kartaS.getObl_g());
                statementPostgres.setString(56, kartaS.getRajon_g());
                statementPostgres.setString(57, kartaS.getCity_g());
                statementPostgres.setString(58, kartaS.getStreet_g());
                statementPostgres.setString(59, kartaS.getCorp_g());
                statementPostgres.setString(60, kartaS.getHouse_g());
                statementPostgres.setString(61, kartaS.getTel_g());
                statementPostgres.setInt(62, kartaS.getMasa1());
                statementPostgres.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
