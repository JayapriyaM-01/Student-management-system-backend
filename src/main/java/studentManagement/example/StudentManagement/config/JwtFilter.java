package studentManagement.example.StudentManagement.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response,
			FilterChain filterchain)
					throws ServletException, IOException, java.io.IOException{
		String authHeader = request.getHeader("Authorization");
		if(authHeader !=null && authHeader.startsWith("Bearer")) {
			String token =authHeader.substring(7);
			if(jwtUtil.validateToken(token)) {
				String username = jwtUtil.extractUsername(token);
				UsernamePasswordAuthenticationToken authentication =new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		filterchain.doFilter(request, response);
	}

}
