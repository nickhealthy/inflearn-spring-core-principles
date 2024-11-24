package hello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * http://localhost:8080/test
 *
 * - 웹 서버를(WAS) 통해 이 서블릿이 실행되어야 한다.
 * - /test로 요청이 오면 이 서블릿이 실행된다.
 * - TestServlet.service를 로그에 출력한다.
 * - test를 응답한다. 웹 브라우저로 요청하면 이 서블릿이 실행되고 화면에 test가 출력되어야 한다.
 *
 */
@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet.service");
        resp.getWriter().println("test");
    }
}
