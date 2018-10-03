package net.daw.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.daw.bean.Celda;
import net.daw.bean.Fila;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gSon = new Gson();
        
        Integer ret = (int) Math.round(Math.random() * 5 + 1);

        try {
            

            String sJ = request.getParameter("ancho");
            String sI = request.getParameter("alto");

            if (sJ.equalsIgnoreCase("") || sI.equalsIgnoreCase("")) {
                System.out.println("vac�o");
                throw new ArithmeticException();

            }



                Integer jota = Integer.parseInt(sJ);
                Integer i = Integer.parseInt(sI);

                if (jota < 1 || i < 1 || jota > 100 || i > 100) {

                    throw new IllegalArgumentException();

                }

                Integer res = jota * i;

                String strJson = gSon.toJson(res);

                TimeUnit.SECONDS.sleep(ret);

                out.print(strJson);

            } catch (NumberFormatException e) {

                response.setStatus(500);
                String sError = "ERROR: Debe introducir un número entero válido";
                String errorJson = gSon.toJson(sError);
                out.print(errorJson);

            } catch (IllegalArgumentException e) {

                response.setStatus(500);
                String sError = "ERROR: Debe introducir números entre 1 y 100";
                String errorJson = gSon.toJson(sError);
                out.print(errorJson);

            } catch (ArithmeticException e) {

                response.setStatus(500);
                String sError = "ERROR: No puede dejar los campos vacíos";
                String errorJson = gSon.toJson(sError);
                out.print(errorJson);
            } catch(InterruptedException ex) {
            	
            }


        
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		processRequest(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
