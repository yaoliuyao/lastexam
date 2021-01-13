package com.nfit.last.mycup.web;

import com.nfit.last.mycup.dao.CupDAO;
import com.nfit.last.mycup.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletes")
public class CupDelsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("ids");
        try {
            new CupDAO().deletes(ids.split(","));
            resp.getWriter().write(ResultVO.ok(1).toJSON());
        } catch (Exception exception) {
            exception.printStackTrace();
            resp.getWriter().write(ResultVO.err(2, exception.getMessage()).toJSON());
        }
    }
}
