package zgheroproject.linketinder.service

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import zgheroproject.linketinder.repository.VagaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import zgheroproject.linketinder.model.Vaga

@Service
@ComponentScan(basePackages = "zgheroproject.linketinder.repository")
class VagaService {
    @Autowired
    private VagaRepository vagaRepository

    @Bean
    VagaService initVagaService(){
        return new VagaService()
    }

    Vaga inserirVaga(Vaga vaga){
        return vagaRepository.inserirVaga(vaga)
    }

    List<Vaga[]> listarVagas(){
        return vagaRepository.listarVagas()
    }
}