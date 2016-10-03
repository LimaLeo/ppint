import javax.swing.JOptionPane;

public class Vetor extends Busca
{
	private double[] v;

	public Vetor(int tam)
	{
		v = new double[tam];
	}

	public void inserir()
	{
		for (int i = 0; i < v.length; i++)
		{
			v[i] = Double.parseDouble(JOptionPane.showInputDialog("v[" + i + "]"));
		}
	}

	public void mostrar()
	{
		String lin = "\n\tVetor\n\n\t";
		for (int i = 0; i < v.length; i++)
		{
			lin += v[i] + " ";
		}
		JOptionPane.showMessageDialog(null, lin);
	}
	
	public double[] getVetor()
	{
		return v;
	}

}
