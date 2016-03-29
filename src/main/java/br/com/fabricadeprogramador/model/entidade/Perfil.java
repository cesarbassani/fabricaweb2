package br.com.fabricadeprogramador.model.entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Cesar on 26/03/2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Perfil.buscaTodos", query = "select p from Perfil p")
})
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id) &&
                Objects.equals(descricao, perfil.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
