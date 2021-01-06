package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import pro.bolshakov.geekbrains.springleveltwo.shop.domain.User;

public interface MailSenderService {
    void sendActivateCode(User user);
}
