package in.upcode.eshop.service;

import in.upcode.eshop.model.Customer;
import in.upcode.eshop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final List<Customer> customers = customerRepository.findByUserName(username);
        if (customers.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username: " + username);
        }

        Customer customer = customers.get(0);

        return new User(customer.getUserName(), new BCryptPasswordEncoder().encode(customer.getPassword()), List.of(new SimpleGrantedAuthority(customer.getRole())));
    }
}
