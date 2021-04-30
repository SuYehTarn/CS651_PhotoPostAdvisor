package servlet.gcs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tools.gcs.Photo;
import tools.gcs.PhotoSet;
import tools.gcs.Word2VecDict;

/**
 * Servlet implementation class GetLabels2
 */
@WebServlet("/GetLabels")
public class GetLabels extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String projectId = "test-eclipse-tools";
	private Word2VecDict dict;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLabels() {
        super();
        // TODO Auto-generated constructor stub
        this.dict = new Word2VecDict();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Photo> samples = Sample.getPhotoSamples();
		for (Photo photo : samples) {
			photo.completeLabelsByDict(projectId, this.dict);
		}
		
		HttpSession session = request.getSession();
		PhotoSet photoSet = new PhotoSet(samples);
		session.setAttribute("photoSet", photoSet);
		
		ArrayList<String> suggested = photoSet.suggestedLabels();
		request.setAttribute("suggested", suggested);
		getServletContext().getRequestDispatcher("/choose_labels.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}