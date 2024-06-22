package tech.patricknicezi.Spring.Store.bootstrap.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tech.patricknicezi.Spring.Store.internal.interactors.auth.FindUserUseCase;
import tech.patricknicezi.Spring.Store.internal.interactors.auth.ValidateTokenUseCase;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final ValidateTokenUseCase validateTokenUseCase;
    private final FindUserUseCase findUserUseCase;


    public SecurityFilter(ValidateTokenUseCase validateTokenUseCase, FindUserUseCase findUserUseCase) {
        this.validateTokenUseCase = validateTokenUseCase;
        this.findUserUseCase = findUserUseCase;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if(!token.isEmpty()){
            filterChain.doFilter(request, response);
            var email = validateTokenUseCase.execute(token);
            UserDetails user = findUserUseCase.loadUserByUsername(email);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return "";
        }
        return token.replace("Bearer ", "");
    }
}
