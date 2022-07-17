package zgheroproject.linketinder.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import zgheroproject.linketinder.model.Empresa

import javax.transaction.Transactional

@Repository
interface EmpresaRepository extends CrudRepository<Empresa, String>{
    Empresa save(Empresa empresa)
    List<Empresa> findAll()
    List<Empresa> findByCnpj(String cnpj)
    void deleteByCnpj(String cnpj)

    @Transactional
    @Modifying
    @Query("update Empresa e set e.nomeEmpresa = :nome where e.cnpj = :cnpj")
    void atualizarNome(@Param(value = "cnpj") String cnpj, @Param(value = "nome") String nome)

    @Transactional
    @Modifying
    @Query("update Empresa e set e.emailEmpresa = :email where e.cnpj = :cnpj")
    void atualizarEmail(@Param(value = "cnpj") String cnpj, @Param(value = "email") String email)

    @Transactional
    @Modifying
    @Query("update Empresa e set e.cepEmpresa = :cep where e.cnpj = :cnpj")
    void atualizarCep(@Param(value = "cnpj") String cnpj, @Param(value = "cep") String cep)

    @Transactional
    @Modifying
    @Query("update Empresa e set e.estadoEmpresa = :estado where e.cnpj = :cnpj")
    void atualizarEstado(@Param(value = "cnpj") String cnpj, @Param(value = "estado") String estado)

    @Transactional
    @Modifying
    @Query("update Empresa e set e.paisEmpresa = :pais where e.cnpj = :cnpj")
    void atualizarPais(@Param(value = "cnpj") String cnpj, @Param(value = "pais") String pais)

    @Transactional
    @Modifying
    @Query("update Empresa e set e.descricaoEmpresa = :descricao where e.cnpj = :cnpj")
    void atualizarDescricao(@Param(value = "cnpj") String cnpj, @Param(value = "descricao") String descricao)

    @Transactional
    @Modifying
    @Query("update Empresa e set e.senhaEmpresa = :senha where e.cnpj = :cnpj")
    void atualizarSenha(@Param(value = "cnpj") String cnpj, @Param(value = "senha") String senha)
}