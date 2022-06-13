package acelerazg.linketinder

import io.micronaut.core.annotation.Introspected
import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic
import jakarta.persistence.Entity

@CompileStatic
class Application {
    static void main(String[] args) {
        Micronaut.run(Application, args)
    }
}
