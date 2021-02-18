package io.github.pedrobarcelos.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table( name = "cliente" )
public class Cliente {

    @Id
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "nome", length = 100)
    private String nome;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Vacina> vacinas;

    @Column(name = "nascimento")
    private LocalDate nascimento;

    @Column(name = "vacinado")
    private boolean vacinado = false;

    public Cliente() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", nascimento=" + nascimento +
                ", vacinado=" + vacinado +
                '}';
    }
}
