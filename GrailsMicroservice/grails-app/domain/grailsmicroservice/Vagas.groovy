package grailsmicroservice

import grails.rest.*

@Resource(uri = '/vaga')
class Vagas{
    String nome, estado, descricao, empresa
    String[] lista_competencias

    static mapping = {
        table 'vagas'
        version false
        nome column: 'nome'
        estado column: 'estado'
        descricao column: 'descricao'
        empresa column: 'empresa'
        lista_competencias column: 'lista_competencias'
    }

    static constraints = {
    }
}
