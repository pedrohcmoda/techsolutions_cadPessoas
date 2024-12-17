package com.cp.data.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Data
public class Cidade implements Serializable {

    public Cidade() {}

    public Cidade(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;

    private String nome;

    @OneToMany(cascade = ALL, mappedBy = "cidade")
    private Set<Pessoa> pessoas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return id == cidade.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
