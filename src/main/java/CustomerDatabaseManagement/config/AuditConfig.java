//package CustomerDatabaseManagement.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import java.util.Optional;
//
//@EnableJpaAuditing
//@Configuration
//public class AuditConfig {
//
//    @Bean
//    public AuditorAware<String> auditorProvider() {
//        return new AuditorAwareImpl();
//    }
//
//    private static class AuditorAwareImpl implements AuditorAware<String> {
//        @Override
//        public Optional<String> getCurrentAuditor() {
//            // Get the current HTTP request
//            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            if (attributes != null) {
//                String username = attributes.getRequest().getHeader("X-Username"); // Change "X-Username" to the header name you expect
//                return Optional.ofNullable(username); // Return the username if present
//            }
//            return Optional.empty();
//        }
//    }
//}
