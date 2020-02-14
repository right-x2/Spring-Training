package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		process(request,response);
	}
	
	private void process (HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2. Ŭ���̾�Ʈ�� ��û path�� ���� ������ �б�ó�� �Ѵ�.
		if(path.equals("/login.do")) {
			System.out.println("�α��� ó��");
		} else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			
			// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
			HttpSession session = request.getSession();
			session.invalidate();
			
			// 2. ���� ������, ���� ȭ������ ���ư���.
			response.sendRedirect("login.jsp");
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
			
			// 1. ����� �Է� ���� ����
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			//3. ȭ�� �׺���̼�
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			BoardVO vo = new BoardVO();
			vo.setContent(content);
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
			
			// 1. ����� �Է� ���� ����
			String seq = request.getParameter("seq");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/getBoard.do")) {
			// 1. �˻��� �Խñ� ��ȣ ����
			String seq = request.getParameter("sep");
			
			// 2. DB���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
			
			System.out.println("�� �� ��ȸ ó��");
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ó��");
			// 1. ����� �Է� ���� ����
			// 2. DB���� ó��
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			// 3. �˻������ session�� �����ϰ� ��� ȭ������ �̵��Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
	}

}
