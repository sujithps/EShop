package in.upcode.eshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain authenticateRequests(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().
                antMatchers("/health", "/register").permitAll()
                .anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();
        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(SecurityProperties properties,
//                                                                 ObjectProvider<PasswordEncoder> passwordEncoder) {
//        SecurityProperties.User user = new SecurityProperties.User();
//        user.setName("user1");
//        user.setPassword("pass1");
//        List<String> roles = List.of("ADMIN");
//
//        return new InMemoryUserDetailsManager(
//                User.withUsername(user.getName()).password(user.getPassword())
//                        .roles(StringUtils.toStringArray(roles)).build());
//    }


//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence rawPassword) {
//                return rawPassword.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return rawPassword.equals(encodedPassword);
//            }
//        };
//    }

}
