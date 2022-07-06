package grailsmicroservice

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VagasServiceSpec extends Specification {

    /*VagasService vagasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vagas(...).save(flush: true, failOnError: true)
        //new Vagas(...).save(flush: true, failOnError: true)
        //Vagas vagas = new Vagas(...).save(flush: true, failOnError: true)
        //new Vagas(...).save(flush: true, failOnError: true)
        //new Vagas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vagas.id
    }

    void "test get"() {
        setupData()

        expect:
        vagasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vagas> vagasList = vagasService.list(max: 2, offset: 2)

        then:
        vagasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vagasService.count() == 5
    }

    void "test delete"() {
        Long vagasId = setupData()

        expect:
        vagasService.count() == 5

        when:
        vagasService.delete(vagasId)
        sessionFactory.currentSession.flush()

        then:
        vagasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vagas vagas = new Vagas()
        vagasService.save(vagas)

        then:
        vagas.id != null
    }*/
}