package pro.bolshakov.geekbrains.springleveltwo.shop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pro.bolshakov.geekbrains.springleveltwo.shop.domain.User;
import pro.bolshakov.geekbrains.springleveltwo.shop.dto.UserDto;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDto userDto);

    List<UserDto> getAll();

    User findByName(String name);

    void updateProfile(UserDto dto);

    void save(User user);

    boolean activateUser(String activateCode);
}
