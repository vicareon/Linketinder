package zgheroproject.linketinder.service


import zgheroproject.linketinder.repository.VagaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.Vaga

@Service
class VagaService {
    @Autowired
    private VagaRepository vagaRepository

    Vaga inserirVaga(Vaga vaga){
        return vagaRepository.inserirVaga(vaga)
    }
}