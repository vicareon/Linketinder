package zgheroproject.linketinder.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.CandidatoCompetencia
import zgheroproject.linketinder.repository.CandidatoCompetenciaRepository

@Service
@ComponentScan(basePackages = "zgheroproject.linketinder.repository")
class CandidatoCompetenciaService {
    @Autowired
    private CandidatoCompetenciaRepository candidatoCompetenciaRepository

    @Bean
    CandidatoCompetenciaService initCandidatoCompetenciaService(){
        return new CandidatoCompetenciaService()
    }

    CandidatoCompetencia inserirCandidatoCompetencia(CandidatoCompetencia candidatoCompetencia){
        return candidatoCompetenciaRepository.inserirCandidatoCompetencia(candidatoCompetencia)
    }

    List<CandidatoCompetencia> buscarCandidatoCompetencia(String buscaCpf, String nomeBuscaCompetencia){
        return candidatoCompetenciaRepository.buscarCandidatoCompetencia(buscaCpf, nomeBuscaCompetencia)
    }
}