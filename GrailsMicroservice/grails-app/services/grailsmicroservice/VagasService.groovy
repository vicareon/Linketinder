package grailsmicroservice

import grails.gorm.services.Service

@Service(Vagas)
interface VagasService {

    Vagas get(Serializable id)

    List<Vagas> list(Map args)

    Long count()

    void delete(Serializable id)

    Vagas save(Vagas vagas)

}