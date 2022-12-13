package gai.data.springcourse.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Arest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
    private Long id;
    //    not null
    private LocalDate data_arest;
//    not null
    private String kart_id;
//    not null
    private String who_na;
    private String in_nom;
    private LocalDate data_in;

    private LocalDate data_sna ;

    private String who_sha;

    private String out_nom;

    private LocalDate data_out;

    private String oper_in;

    private String oper_out;

    private String vlad ;

    private int ish_answer1;
    private int ish_answer2;
    private String k_nom1;

    private LocalDate k_data1;

    private String k_nom2 ;

    private LocalDate k_data2;

    private String commenta;
//    not null
    private LocalDate time_fix;

    public Arest() {
    }
}
