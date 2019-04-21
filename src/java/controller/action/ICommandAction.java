
package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public interface ICommandAction {
    
   public void execute(HttpServletRequest request, HttpServletResponse response) 
           throws Exception;
    
}
