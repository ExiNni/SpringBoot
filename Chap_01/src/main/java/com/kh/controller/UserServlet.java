package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.DAO;
import com.kh.model.vo.DTO;

@WebServlet("/selectUser")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userId = request.getParameter("userId").toLowerCase(); // 입력된 아이디를 소문자로 변환
            List<DTO> userList = DAO.selectUserById(userId);

            if (userList != null && !userList.isEmpty()) {
                request.setAttribute("userList", userList);
                request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/searchError.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}