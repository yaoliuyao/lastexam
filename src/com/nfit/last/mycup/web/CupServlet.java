package com.nfit.last.mycup.web;

import com.nfit.last.mycup.bean.Cup;
import com.nfit.last.mycup.dao.CupDAO;
import com.nfit.last.mycup.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getAll")
public class CupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Cup> cups = new CupDAO().listAll();
            resp.getWriter().write(ResultVO.ok(cups).toJSON());
        } catch (Exception exception) {
            exception.printStackTrace();
            resp.getWriter().write(ResultVO.err(222, exception.getMessage()).toJSON());
        }
    }
}
