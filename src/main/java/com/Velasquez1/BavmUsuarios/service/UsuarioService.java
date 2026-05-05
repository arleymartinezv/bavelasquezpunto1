package com.Velasquez1.BavmUsuarios.service;

import com.Velasquez1.BavmUsuarios.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioService {

    private final List<User> usuarios = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public List<User> listarUsuarios() {
        return usuarios;
    }

    public User registrarUsuario(User user) {
        user.setId(contador.getAndIncrement());
        usuarios.add(user);
        return user;
    }

    public boolean eliminarUsuario(Long id) {
        return usuarios.removeIf(u -> u.getId().equals(id));
    }
}
