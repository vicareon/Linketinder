package grailsmicroservice

import grails.rest.*

@Resource(uri = '/vaga')
class Vagas{
    String nome, estado, descricao, empresa

    static mapping = {
        table 'vagas'
        version false
        nome column: 'nome'
        estado column: 'estado'
        descricao column: 'descricao'
        empresa column: 'empresa'
    }

    static constraints = {
    }

    def beforeValidate() {
        KafkaSender kafkaSender = new KafkaSender()
        kafkaSender.send("vaga criada: " + nome)
    }
}