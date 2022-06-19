package zgheroproject.linketinder.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import zgheroproject.linketinder.model.Candidato
import org.springframework.stereotype.Repository

import javax.transaction.Transactional

@Repository
interface CandidatoRepository extends CrudRepository<Candidato, String>{
    Candidato save(Candidato candidato)
    List<Candidato> findAll()
    void deleteById(String cpf)
    Candidato getReferenceById(String cpf)

    @Transactional
    @Modifying
    @Query("update Candidato c set c.nome = :nome where c.cpf = :cpf")
    void atualizarNome(@Param(value = "cpf") String cpf, @Param(value = "nome") String nome)

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Candidato c set c.email = :email where c.cpf = :cpf")
    void atualizarEmail(@Param(value = "cpf") String cpf, @Param(value = "email") String email)

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Candidato c set c.cep = :cep where c.cpf = :cpf")
    void atualizarCep(@Param(value = "cpf") String cpf, @Param(value = "cep") String cep)

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Candidato c set c.estado = :estado where c.cpf = :cpf")
    void atualizarEstado(@Param(value = "cpf") String cpf, @Param(value = "estado") String estado)

    @Modifying(clearAutomatically = true)
    @Query("update Candidato c set c.pais = :pais where c.cpf = :cpf")
    void atualizarPais(@Param(value = "cpf") String cpf, @Param(value = "pais") String pais)

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Candidato c set c.descricao = :descricao where c.cpf = :cpf")
    void atualizarDescricao(@Param(value = "cpf") String cpf, @Param(value = "descricao") String descricao)

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Candidato c set c.formacao = :formacao where c.cpf = :cpf")
    void atualizarFormacao(@Param(value = "cpf") String cpf, @Param(value = "formacao") String formacao)

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Candidato c set c.idade = :idade where c.cpf = :cpf")
    void atualizarIdade(@Param(value = "cpf") String cpf, @Param(value = "idade") String idade)

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Candidato c set c.senha = :senha where c.cpf = :cpf")
    void atualizarSenha(@Param(value = "cpf") String cpf, @Param(value = "senha") String senha)
}