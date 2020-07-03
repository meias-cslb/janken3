package model.janken3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Result
 */
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String jsp = null;
//		保持するためのセッションを生成
		HttpSession session=request.getSession();

//		保持しているじゃんけんデータがなかったら新しく作る
		Janken janken = (Janken)session.getAttribute("janken");
		 if(janken == null){
		    janken = new Janken();
		 }


	//		プレイヤーの出したものを取得
			String select = request.getParameter("hand");

			int player = -1;
			String[] hand = {"グー", "チョキ", "パー"};

//			選ばれず送信されたらもう一度トップに戻り選んでもらう
			if(select == null || select.isEmpty()) {
				request.setAttribute("message", "選んで！");
				//		top.jspに転送準備
				jsp = "/WEB-INF/jsp/top.jsp";
			} else {

//				選ばれた手の数字を取得しセット
				try {
					player = Integer.parseInt(select);
					janken.setPlayerHand(hand[player]);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}


		//		コンピューターの出すものをランダムで選び、セット
				int computer = (int)(Math.random() * 3);
				janken.setComputerHand(hand[computer]);

//				勝敗のジャッジ
				Judgment judgment = new Judgment();
				judgment.jadg(player, computer, janken);

//				じゃんけんデータをセット
				session.setAttribute("janken", janken);

		//		result.jspに転送準備
				jsp = "/WEB-INF/jsp/result.jsp";
			}

//		jspに転送し、表示
		RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

}
