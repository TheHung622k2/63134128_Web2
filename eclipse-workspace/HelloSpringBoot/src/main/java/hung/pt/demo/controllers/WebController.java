package hung.pt.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Đánh dấu đây là một Controller
// Nơi tiếp nhận các request từ phía người dùng
@Controller
public class WebController {

	// Đón nhận request GET
	@GetMapping("/") // Nếu người dùng request tới địa chỉ "/"
	public String index()
	{
		return "index"; // Trả về file index.html
	}
}
