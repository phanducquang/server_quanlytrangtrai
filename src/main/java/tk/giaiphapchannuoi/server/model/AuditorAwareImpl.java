package tk.giaiphapchannuoi.server.model;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import tk.giaiphapchannuoi.server.security.UserPrincipal;

import java.util.Optional;

class AuditorAwareImpl implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        //Lay user_id cua user hien tai
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null ||
//                !authentication.isAuthenticated() ||
//                authentication instanceof AnonymousAuthenticationToken) {
//            return Optional.empty();
//        }
//
//        UserPrincipal loginedUser = (UserPrincipal) authentication.getPrincipal();
//
//        return Optional.ofNullable(loginedUser.getId());
        return Optional.empty();
    }
}