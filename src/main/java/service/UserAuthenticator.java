package service;

import model.Usuario;

import java.util.List;

public class UserAuthenticator {

    public Usuario authenticate(Usuario usuario, List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(usuario.getEmail()) && u.getPassword().equals(usuario.getPassword())) {
                return u; // Retorna o usuário autenticado
            }
        }
        return null; // Retorna null se não encontrar o usuário
    }
}
    /*ublic Usuario authenticate(Usuario user, List<Usuario> userList) {
        if(userList.contains(user)) {
            user = userList.get(userList.indexOf(user));
            preturn user;
        }
        return null;
    }*/

