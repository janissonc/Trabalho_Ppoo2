package com.exemplo.biblioteca.servlet;

import com.exemplo.biblioteca.dao.LivrosDao;
import com.exemplo.biblioteca.entidades.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CriarLivroServlet", urlPatterns = {"/CriarLivroServlet"})
public class CriarLivroServlet extends HttpServlet {

    @Inject
    private LivrosDao dao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            
            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");
            String paginas = request.getParameter("paginas");
            
            try{
            Livro novolivro = new Livro();
            novolivro.setTitulo(titulo);
            novolivro.setAutor(autor);
            novolivro.setNumPaginas(Integer.valueOf(paginas));
            dao.adicionaLivro(novolivro);
            out.println("<h1>Livro adicionado com sucesso!</h1>");
            }
            
            catch(Exception ex){
                out.println("<h1>Erro ao adicionar um novo livro.</h1>");
            }
            
            out.println("<a href='index.html'>Biblioteca</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

