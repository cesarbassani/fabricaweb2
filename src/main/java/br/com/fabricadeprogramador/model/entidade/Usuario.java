package br.com.fabricadeprogramador.model.entidade;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Usuario.buscaTodos", query = "select u from Usuario u")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Column(name = "email")
    private String email;

    @Column(name = "ativo")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn
    private Perfil perfil;

    //Getters and Setter


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(login, usuario.login) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(perfil, usuario.perfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, login, senha, email, perfil);
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login
                + ", senha=" + senha + "]";
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}