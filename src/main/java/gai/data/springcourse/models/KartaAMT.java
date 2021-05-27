package gai.data.springcourse.models;

import java.util.Date;
import java.util.Objects;

public class KartaAMT {
    private long id;
    private String marka;
    private String model;
    private String teh_pasp;
    private String znak;
    private String family;
    private String fname;
    private String sec_name;
    private String obl;
    private String rajon;
    private String city;
    private String street;
    private String house;
    private String kv;
    private String num_dv;
    private String num_cuz;
    private String num_shas;
    private String data_v;
    private String color;
    private Date data_oper;
    private String kart_id;

    public String getCode_oper() {
        return code_oper;
    }

    public void setCode_oper(String code_oper) {
        this.code_oper = code_oper;
    }

    private String code_oper;
    public KartaAMT() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTeh_pasp() {
        return teh_pasp;
    }

    public void setTeh_pasp(String teh_pasp) {
        this.teh_pasp = teh_pasp;
    }

    public String getZnak() {
        return znak;
    }

    public void setZnak(String znak) {
        this.znak = znak;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSec_name() {
        return sec_name;
    }

    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
    }

    public String getObl() {
        return obl;
    }

    public void setObl(String obl) {
        this.obl = obl;
    }

    public String getRajon() {
        return rajon;
    }

    public void setRajon(String rajon) {
        this.rajon = rajon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getKv() {
        return kv;
    }

    public void setKv(String kv) {
        this.kv = kv;
    }

    public String getNum_dv() {
        return num_dv;
    }

    public void setNum_dv(String num_dv) {
        this.num_dv = num_dv;
    }

    public String getNum_cuz() {
        return num_cuz;
    }

    public void setNum_cuz(String num_cuz) {
        this.num_cuz = num_cuz;
    }

    public String getNum_shas() {
        return num_shas;
    }

    public void setNum_shas(String num_shas) {
        this.num_shas = num_shas;
    }

    public String getData_v() {
        return data_v;
    }

    public void setData_v(String data_v) {
        this.data_v = data_v;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getData_oper() {
        return data_oper;
    }

    public void setData_oper(Date data_oper) {
        this.data_oper = data_oper;
    }

    public String getKart_id() {
        return kart_id;
    }

    public void setKart_id(String kart_id) {
        this.kart_id = kart_id;
    }

    @Override
    public String toString() {
        return "KartaAMT{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", teh_pasp='" + teh_pasp + '\'' +
                ", znak='" + znak + '\'' +
                ", family='" + family + '\'' +
                ", fname='" + fname + '\'' +
                ", sec_name='" + sec_name + '\'' +
                ", obl='" + obl + '\'' +
                ", rajon='" + rajon + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", kv='" + kv + '\'' +
                ", num_dv='" + num_dv + '\'' +
                ", num_cuz='" + num_cuz + '\'' +
                ", num_shas='" + num_shas + '\'' +
                ", data_v='" + data_v + '\'' +
                ", color='" + color + '\'' +
                ", data_oper=" + data_oper +
                ", kart_id='" + kart_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KartaAMT kartaAMT = (KartaAMT) o;
        return id == kartaAMT.id && Objects.equals(marka, kartaAMT.marka) && Objects.equals(model, kartaAMT.model) && Objects.equals(teh_pasp, kartaAMT.teh_pasp) && Objects.equals(znak, kartaAMT.znak) && Objects.equals(family, kartaAMT.family) && Objects.equals(fname, kartaAMT.fname) && Objects.equals(sec_name, kartaAMT.sec_name) && Objects.equals(obl, kartaAMT.obl) && Objects.equals(rajon, kartaAMT.rajon) && Objects.equals(city, kartaAMT.city) && Objects.equals(street, kartaAMT.street) && Objects.equals(house, kartaAMT.house) && Objects.equals(kv, kartaAMT.kv) && Objects.equals(num_dv, kartaAMT.num_dv) && Objects.equals(num_cuz, kartaAMT.num_cuz) && Objects.equals(num_shas, kartaAMT.num_shas) && Objects.equals(data_v, kartaAMT.data_v) && Objects.equals(color, kartaAMT.color) && Objects.equals(data_oper, kartaAMT.data_oper) && Objects.equals(kart_id, kartaAMT.kart_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marka, model, teh_pasp, znak, family, fname, sec_name, obl, rajon, city, street, house, kv, num_dv, num_cuz, num_shas, data_v, color, data_oper, kart_id);
    }


}


