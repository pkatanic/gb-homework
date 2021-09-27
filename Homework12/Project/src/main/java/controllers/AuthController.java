package controllers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import configs.JwtRequest;
import configs.JwtResponse;
import configs.JwtTokenUtil;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {
   // private static final String LOGIN_USERNAME_ERROR = null;
	private  UserService userService;
    private  JwtTokenUtil jwtTokenUtil;
    private  AuthenticationManager authenticationManager;
	//private BadCredentialsException log;

    @PostMapping("/api/v1/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
        	//Object request;
        	throw new Exception(e.getMessage());
//            return new ResponseEntity<>( );
           // return null;
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
