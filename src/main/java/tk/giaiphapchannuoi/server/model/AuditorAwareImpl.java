package tk.giaiphapchannuoi.server.model;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

class AuditorAwareImpl implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        return Optional.empty();
    }
}