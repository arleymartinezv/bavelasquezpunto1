package com.Velasquez1.BavmUsuarios.controller;

import com.Velasquez1.BavmUsuarios.model.User;
import com.Velasquez1.BavmUsuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<User> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public User registrarUsuario(@RequestBody User user) {
        return usuarioService.registrarUsuario(user);
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        boolean eliminado = usuarioService.eliminarUsuario(id);
        return eliminado ? "Usuario eliminado correctamente." : "Usuario no encontrado.";
    }
}
