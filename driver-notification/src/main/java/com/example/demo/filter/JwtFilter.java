package com.example.demo.filter;

import com.example.demo.util.JwtUtils;

import io.jsonwebtoken.ExpiredJwtException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtility;

    
    @Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		
		String jwt = null;
		String userName = null;
		
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			jwt = authHeader.substring(7);
			userName = jwtUtility.extractUserName(jwt);
		}
		

		if(!request.getRequestURI().contains(".html")) {
            try {
                
                if(userName != null && jwtUtility.validateToken(jwt, userName)) {
                    //check if account blocked
                    
                    //In spring security this will happen by default
                    UsernamePasswordAuthenticationToken authenticationToken 
                                            = new UsernamePasswordAuthenticationToken(userName, null, null);
                        
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);                        
                    
                } 
                
            } catch (ExpiredJwtException e) {
                //returned to login page
//                request.getSession().invalidate();
//                response.sendRedirect("/DriverLogin.html");
//                return;
            }



}
		filterChain.doFilter(request, response);

	}
}