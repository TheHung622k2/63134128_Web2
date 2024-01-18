package hung.pt.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BMI")
public class BMI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter traVe = response.getWriter();
		traVe.append("<html>");
		traVe.append("<head>");
		traVe.append("<title>Trang web tính BMI</title>");
		traVe.append("<style>");
		traVe.append("body { font-family: 'Arial', sans-serif; background-color: #f4f4f4; text-align: center; }");
		traVe.append("form { max-width: 400px; margin: 20px auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }");
		traVe.append("label { display: block; margin-bottom: 8px; }");
		traVe.append("input { width: 100%; padding: 10px; margin-bottom: 16px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }");
		traVe.append("input[type=\"submit\"] { background-color: #4caf50; color: #fff; cursor: pointer; }");
		traVe.append("</style>");
		traVe.append("</head>");
		traVe.append("<body>");

		traVe.append("<form method=\"POST\" action=\"/HelloWorld/BMI\">");
		traVe.append("<h2>Nhập thông tin BMI</h2>");
		traVe.append("<label for=\"height\">Nhập chiều cao:</label>");
		traVe.append("<input type=\"text\" id=\"height\" name=\"height\" required><br>");

		traVe.append("<label for=\"weight\">Nhập cân nặng:</label>");
		traVe.append("<input type=\"text\" id=\"weight\" name=\"weight\" required><br>");

		traVe.append("<input type=\"submit\" value=\"Tính BMI\">");
		traVe.append("</form>");

		traVe.append("</body>");
		traVe.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String heightStr = request.getParameter("height");
		String weightStr = request.getParameter("weight");
		
		// Ép kiểu
		double height = Double.parseDouble(heightStr);
		double weight = Double.parseDouble(weightStr);
		
		double bmi = weight / (height * height);
		
		response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        
        PrintWriter traVe = response.getWriter();
        traVe.append("<html>");
        traVe.append("<head>");
        traVe.append("<title>Kết quả BMI</title>");
        traVe.append("<style>");
        traVe.append("body { font-family: 'Arial', sans-serif; background-color: #f4f4f4; text-align: center; }");
        traVe.append(".result { max-width: 400px; margin: 20px auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }");
        traVe.append("</style>");
        traVe.append("</head>");
        traVe.append("<body>");

        traVe.append("<div class=\"result\">");
        traVe.append("<h2>Kết quả BMI</h2>");
        traVe.append("<p>Chỉ số BMI của bạn là: " + bmi + "</p>");
        traVe.append("</div>");

        traVe.append("</body>");
        traVe.append("</html>");
	}
}
