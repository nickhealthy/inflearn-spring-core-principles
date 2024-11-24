package hello.embed;

import hello.servlet.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * 강의: 3. 내장 톰캣2 - 서블릿
 * 내장 톰캣(라이브러리)을 사용해서 main 함수로 웹 서버를 실행한다.
 */
public class EmbedTomcatServletMain {

    public static void main(String[] args) throws LifecycleException {
        System.out.println("EmbedTomcatServletMain.main");

        // 톰캣 설정
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);

        // 서블릿 등록
        Context context = tomcat.addContext("", "/");
        tomcat.addServlet("", "helloServlet", new HelloServlet());  // 서블릿 등록
        context.addServletMappingDecoded("/", "helloServlet");              // 등록한 서블릿의 경로를 매핑
        tomcat.start();
    }
}
