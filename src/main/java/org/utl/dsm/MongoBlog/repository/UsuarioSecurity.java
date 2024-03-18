package org.utl.dsm.MongoBlog.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.utl.dsm.MongoBlog.entity.Usuario;

import java.util.Optional;

@Service
public class UsuarioSecurity implements UserDetailsService {
    private UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioSecurity(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = Optional.ofNullable(usuarioRepository.findByUsuario(username));
        return (UserDetails) usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }
}
