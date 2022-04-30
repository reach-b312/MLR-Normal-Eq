//Autor: Ricardo Avalos
package mlr.normalequation;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import javax.swing.JOptionPane;

public class MLRAgent extends Agent {
  @Override
  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new SLRBehaviour());
  } 

  private class SLRBehaviour extends Behaviour {
    int cont=0;
    @Override
    public void action() {
        String userInput = JOptionPane.showInputDialog("Valor de x1 y x2 separados por un espacio: ");
        String [] mlrX = userInput.split(" ");
        double mlrX1 = Double.parseDouble(mlrX[0]);
        double mlrX2 = Double.parseDouble(mlrX[1]);
        System.out.println("Agent's action method is executed");
        DataSet ds = new DataSet();
        HelperArithmetic ha = new HelperArithmetic(ds);
        MultipleLinearRegression mlr = new MultipleLinearRegression(ha);
        mlr.imprimir(mlrX1,mlrX2);
        cont+=1;
    } 
    @Override
    public boolean done() {
      if (cont == 1)
        return true;
      else
	return false;
    }
   @Override
    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}