import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mail")
public class MailServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String mail = req.getParameter("mail");
		String message = req.getParameter("msg");
		
		PrintWriter out = res.getWriter();
		
		try {
			SendMail.sendMail(mail,message);
			out.println("Mail sent successfully...  :)");
		}
		catch(Exception e) {
			e.printStackTrace();
			out.println("Mail process failed...  :(");
		}
	}
}
