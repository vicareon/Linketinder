package emailmicroservice

interface EmailService {
    String sendSimpleMail(EmailDetails details)
}