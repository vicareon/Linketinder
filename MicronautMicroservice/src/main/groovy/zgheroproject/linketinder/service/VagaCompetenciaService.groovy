package zgheroproject.linketinder.service

import jakarta.inject.Inject
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.VagaCompetencia
import zgheroproject.linketinder.repository.VagaCompetenciaRepository

@Service
class VagaCompetenciaService {
    @Inject
    private VagaCompetenciaRepository vagaCompetenciaRepository

    void salvarVagaCompetencia(VagaCompetencia vagaCompetencia){
        vagaCompetenciaRepository.save(vagaCompetencia)
    }

    List<VagaCompetencia> listarTodasVagasCompetencias(){
        return vagaCompetenciaRepository.findAll()
    }

    void excluirVagaCompetencia(int id){
        vagaCompetenciaRepository.deleteById(id)
    }
}
