package uploadFileServlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadFileServlet extends HttpServlet {

	public static final String SAVE_DIRECTORY = "UploadFolder";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 try {
		
	   
	           // Đường dẫn tuyệt đối tới thư mục gốc của web app.
	           String webappPath = request.getServletContext().getRealPath("");
	           webappPath = webappPath.replace('\\', '/');
	           System.out.println(webappPath);
	         
	           // Thư mục để save file tải lên.
	           String fullSavePath = null;
	           if (webappPath.endsWith("/")) {
	               fullSavePath = webappPath + SAVE_DIRECTORY;
	               getServletContext().setAttribute("webappPath",fullSavePath);
	   	       	
	               System.out.println(fullSavePath);
	           } else {
	               fullSavePath = webappPath + "/" + SAVE_DIRECTORY;
	               getServletContext().setAttribute("webappPath",fullSavePath);
	   	       	
	               
	           }
	       
	  
	           // Tạo thư mục nếu nó không tồn tại.
	           File fileSaveDir = new File(fullSavePath);
	           if (!fileSaveDir.exists()) {
	               fileSaveDir.mkdir();
	           }
	  
	           // Danh mục các phần đã upload lên (Có thể là nhiều file).
	           for (Part part : request.getParts()) {
	               String fileName = extractFileName(part);
	               if (fileName != null && fileName.length() > 0) {
	                   String filePath = fullSavePath + File.separator + fileName;
	                 
	                   // Ghi vào file.
	                   part.write(filePath);
	               }
	           }
	           // Upload thành công.
	           response.sendRedirect(request.getContextPath() + "/ListBookServlet");
	       } catch (Exception e) {
	         
	           request.setAttribute("errorMessage", "Error: " + e.getMessage());
	           RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/fileupload/uploadfile.jsp");
	           dispatcher.forward(request, response);
	       }
	   }
	 
	   private String extractFileName(Part part) {
	     
	       String contentDisp = part.getHeader("content-disposition");
	       String[] items = contentDisp.split(";");
	       for (String s : items) {
	           if (s.trim().startsWith("filename")) {
	             
	               String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
	               clientFileName = clientFileName.replace("\\", "/");
	               int i = clientFileName.lastIndexOf('/');
	            
	               return clientFileName.substring(i + 1);
	           }
	       }
	       return null;
	   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
