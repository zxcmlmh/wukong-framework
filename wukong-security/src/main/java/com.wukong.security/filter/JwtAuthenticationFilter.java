//package com.wukong.security.filter;
//
//import com.wukong.security.util.JwtUtil;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.util.PathMatcher;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
//
//import static com.wukong.security.util.JwtUtil.USERID;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private static final PathMatcher pathMatcher = new AntPathMatcher();
//
//
//
//    private String protectUrlPattern = "/hello/**";
//    public JwtAuthenticationFilter() {
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        try {
//            if(isProtectedUrl(request)) {
//                Map<String, Object> claims = JwtUtil.validateTokenAndGetClaims(request);
//
//                Integer userid= (Integer)claims.get(USERID);
//
//
//                //最关键的部分就是这里, 我们直接注入了
////                SecurityContextHolder.getContext().setAuthentication(
////                        new UsernamePasswordAuthenticationToken(
////                                null,
////                                null,
////                                         listAuthority
////                                ));
//
//            }
//        } catch (Exception e) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
//            return;
//        }
//        //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
//        filterChain.doFilter(request, response);
//    }
//
//    //我们只对地址 /api 开头的api检查jwt. 不然的话登录/login也需要jwt
//    private boolean isProtectedUrl(HttpServletRequest request) {
//        return pathMatcher.match(protectUrlPattern, request.getServletPath());
//    }
//}
