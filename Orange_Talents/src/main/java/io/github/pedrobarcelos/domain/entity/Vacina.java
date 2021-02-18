package io.github.pedrobarcelos.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacina")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "email_vacinado")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_aplicacao() {
        return data_aplicacao;
    }

    public void setData_aplicacao(LocalDate data_aplicacao) {
        this.data_aplicacao = data_aplicacao;
    }

    @Column(name = "data_aplicacao")
    private LocalDate data_aplicacao;

    public String getEmail(){
        return email;
    }

    public void setEmail( String email){
        this.email = email;
    }

    public Vacina() {
    }

    @Override
    public String toString() {
        return "Vacina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email_vacinado=" + email +
                ", data_aplicacao=" + data_aplicacao +
                '}';
    }
}
