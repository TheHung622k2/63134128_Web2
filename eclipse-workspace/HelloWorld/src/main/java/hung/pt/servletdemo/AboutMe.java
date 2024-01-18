package hung.pt.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AboutMe")
public class AboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		// Tạo đối tượng PrintWriter để gửi dữ liệu về Client
		PrintWriter traVe = response.getWriter();
		
		// Bắt đầu gửi dữ liệu HTML
		traVe.println("<html>");
		traVe.println("<head>");
		traVe.println("<title>Thông tin cá nhân</title>");
		traVe.println("<style>");
		traVe.println("body { font-family: Arial, sans-serif; text-align: center; margin: 50px; background-color: #f4f4f4;}");
		traVe.println("h2 { color: #333; font-size: 28px;}");
		traVe.println("p { margin-bottom: 10px; font-size: 18px;}");
		traVe.println("</style>");
		traVe.println("</head>");
		traVe.println("<body>");
		traVe.println("<div style='width: 50%; margin: auto; background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);'>");
		traVe.println("<h2>Thông tin cá nhân của Phạm Thế Hùng</h2>");
		traVe.println("<p><strong>Họ và tên:</strong> Phạm Thế Hùng</p>");
		traVe.println("<p><strong>Lớp:</strong> 63.CNTT-CLC</p>");
		traVe.println("<p><strong>MSSV:</strong> 63134128</p>");
		traVe.println("</div>");
		traVe.println("</body>");
		traVe.println("</html>");
	}
}
