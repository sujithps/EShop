package in.upcode.eshop.config;

import in.upcode.eshop.model.Customer;
import in.upcode.eshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EShopUserService implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final List<Customer> customersList = customerRepository.findByEmail(username);
        if (!customersList.isEmpty()) {
            Customer customer = customersList.get(0);

            final SimpleGrantedAuthority authority = new SimpleGrantedAuthority(customer.getRole());

            return new User(username, customer.getPassword(), List.of(authority));
        }

        throw new UsernameNotFoundException("Invalid username : " + username);
    }
}
