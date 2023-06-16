package br.edu.atitus.pooavancado.CadUsuario.controllers;

import java.security.SecureRandom;

import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Registration.Signing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.CadUsuario.components.JwtUtils;
import br.edu.atitus.pooavancado.CadUsuario.controllers.payloads.SigninPayload;
import br.edu.atitus.pooavancado.CadUsuario.controllers.payloads.SignupPayload;
import br.edu.atitus.pooavancado.CadUsuario.entities.Usuario;
import br.edu.atitus.pooavancado.CadUsuario.services.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	private final UsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authManager;
	private final JwtUtils jwtUtils;
	public AuthController(UsuarioService usuarioService, PasswordEncoder passwordEncoder
			, AuthenticationManager authManager, JwtUtils jwtUtils) {
		super();
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
		this.authManager = authManager;
		this.jwtUtils = jwtUtils;
	}
	@PostMapping("/signin")
	public ResponseEntity<Object> login(@RequestBody SigninPayload signin) {
		try {
			Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(signin.getEmail(), signin.getSenha()));
			String jwt = jwtUtils.generateTokenFromEmail(signin.getEmail());
			return ResponseEntity.status(HttpStatus.OK).body(jwt);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	@PostMapping("/signup")
	public ResponseEntity<Object> autoCadastro(@RequestBody SignupPayload signup) {
		try {
			Usuario usuarioNovo = new Usuario();
			usuarioNovo.setNome(signup.getNome());
			usuarioNovo.setEmail(signup.getEmail());
			usuarioNovo.setDepartamento(signup.getDepartamento());
			usuarioNovo.setStatus(true);
			String senha = gerarSenhaAleatoria(10);
			usuarioNovo.setSenha(passwordEncoder.encode(senha));
			usuarioService.save(usuarioNovo);
			return ResponseEntity.status(HttpStatus.OK).body(senha);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	private String gerarSenhaAleatoria(int tamanho) {
		String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(CARACTERES_PERMITIDOS.length());
            senha.append(CARACTERES_PERMITIDOS.charAt(indice));
        }
        return senha.toString();
    }

}
