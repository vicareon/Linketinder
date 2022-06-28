package emailmicroservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl implements EmailService{
    @Autowired private JavaMailSender javaMailSender

    private String sender

    @Override
    String sendSimpleMail(EmailDetails details) {
        SimpleMailMessage mailMessage = new SimpleMailMessage()

        mailMessage.setFrom("vagas@linketinder.com")
        mailMessage.setTo(details.getRecipient())
        mailMessage.setText(details.getMsgBody())
        mailMessage.setSubject(details.getSubject())

        javaMailSender.send(mailMessage)
        return "Email enviado com sucesso!"
    }
}
