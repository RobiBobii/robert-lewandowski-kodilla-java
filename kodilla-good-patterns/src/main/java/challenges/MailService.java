package challenges;

public class MailService implements InformationService {

    @Override
    public void sendConfirmation(User user) {
        System.out.println("Message has been sent.");
    }
}