package zgheroproject.linketinder.service


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.Competencia
import zgheroproject.linketinder.repository.CompetenciaRepository

@Service
@ComponentScan(basePackages = "zgheroproject.linketinder.repository")
class CompetenciaService {
    @Autowired
    private CompetenciaRepository competenciaRepository

    @Bean
    CompetenciaService initCompetenciaService(){
        return new CompetenciaService()
    }

    Competencia inserirCompetencia(Competencia competencia){
        return competenciaRepository.inserirCompetencia(competencia)
    }

    List<Competencia> buscarCompetencia(String nomeBuscaCompetencia){
        return competenciaRepository.buscarCompetencia(nomeBuscaCompetencia)
    }
}