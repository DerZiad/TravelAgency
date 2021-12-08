package ma.wiebatouta.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Order(1)
public class SessionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("ziad");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getServletPath();

		boolean test = false;

		List<String> list = Arrays.asList("/admin/login", "/home", "/signup", "/css", "/fonts", "/images", "/js",
				"/scss");

		for (String item : list) {
			if (path.startsWith(item))
				test = true;
		}

		if (test) {
			chain.doFilter(req, resp);
		} else {

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication instanceof AnonymousAuthenticationToken) {
				resp.sendRedirect("/admin/login");
			} else {
				chain.doFilter(request, response);
				
			}
		}
	}

}
