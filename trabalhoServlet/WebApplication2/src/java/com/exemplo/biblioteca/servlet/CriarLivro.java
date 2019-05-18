package com.exemplo.biblioteca.servlet;
import com.exemplo.biblioteca.entidades.Livro;
import com.exemplo.biblioteca.dao.LivrosDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/criar-livro-servlet"})

public class CriarLivro extends HttpServlet {
    
   private LivrosDao dao;

    public CriarLivro() {
        this.dao = new LivrosDao();
    }
   
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Biblioteca</title>");            
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
                        "</head>");
            out.println("<body><div class='container'>");
            out.println("<h1>Servlet criar livro</h1>");
            out.println("</div><script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" +
                        "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n" +
                        "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n" +
                        "    </body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<ul>");
        
        String titulo = " ";
        titulo = req.getParameter("titulo");
        
        List<Livro> livros = null;
        
        if(titulo == null || titulo.isEmpty()){
            titulo = dao.buscaTodosLivros();
        }else{
            titulo = dao.buscaLivroPorTitulo(titulo);
        }
        for(Livro livro : livros){
        out.println("<li>"+ livro.getTitulo()+"</li>");
        }
        out.println("</ul></body></html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
