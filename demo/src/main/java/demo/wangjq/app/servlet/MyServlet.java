package demo.wangjq.app.servlet;

import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjq on 2018/12/4.
 */
public class MyServlet extends HttpServlet {


    UrlPathHelper urlPathHelper = new UrlPathHelper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = urlPathHelper.getLookupPathForRequest(req);

        String[] array = req.getParameterValues("array");

        for (String s : array) {
            System.out.println(s);
        }


        System.out.println(urlPathHelper.getPathWithinServletMapping(req));
        System.out.println(path);
        System.out.println("-----------doGet----------------");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------doPost----------------");

        Map<String, String> vars = new HashMap<>();
        resp.getWriter().print("<h1> urlPathHelper.decodePathVariables(req):" + urlPathHelper.decodePathVariables(req, vars) + "</h1>");
        resp.getWriter().print("<h1> urlPathHelper.getOriginatingQueryString(req):" + urlPathHelper.getOriginatingQueryString(req) + "</h1>");
        resp.getWriter().print("<h1> urlPathHelper.getContextPath(req):" + urlPathHelper.getContextPath(req) + "</h1>");
        resp.getWriter().print("<h1> urlPathHelper.getRequestUri(req):" + urlPathHelper.getRequestUri(req) + "</h1>");
        resp.getWriter().print("<h1> urlPathHelper.getPathWithinApplication(req):" + urlPathHelper.getPathWithinApplication(req) + "</h1>");
        resp.getWriter().print("<h1> urlPathHelper.getPathWithinServletMapping(req):" + urlPathHelper.getPathWithinServletMapping(req) + "</h1>");
        resp.getWriter().print("<h1> req.getServletPath():" + req.getServletPath() + "<br/></h1>");
        resp.getWriter().print("<h1> getLookupPathForRequest(HttpServletRequest request):" + urlPathHelper.getLookupPathForRequest(req) + "<br/></h1>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

}
