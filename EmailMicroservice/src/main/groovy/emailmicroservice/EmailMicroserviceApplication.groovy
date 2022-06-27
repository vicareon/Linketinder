package emailmicroservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class EmailMicroserviceApplication{
    static void main(String[] args) {
        SpringApplication.run(EmailMicroserviceApplication, args)
        EmailSubscriber emailSubscriber = new EmailSubscriber()
        emailSubscriber.escutarTopico()
    }
}
