
public class Busca extends Ordenacao 
{

	public static double buscaLinear(double vet[], double procurado)
	{
		for (int i = 0; i < vet.length; i++)
		{
			if (vet[i] == procurado)
				return i;
		}
		return -1;
	}

	public static double buscaLinearRecursiva(double vet[], double procurado)
	{
		return buscaLinearRecursiva(vet, 0, procurado);
	}

	public static int buscaLinearRecursiva(double vet[], int i, double procurado)
	{
		if (i <= vet.length)
		{
			if (vet[i] == procurado)
				return i;
			else
				return buscaLinearRecursiva(vet, i + 1, procurado);
		}
		return -1;
	}

	public static int buscaBinaria(double vet[], double valor)
	{
		int inicio = 0, meio, fim = vet.length - 1;
		while (inicio <= fim)
		{
			meio = (inicio + fim) / 2;
			if (vet[meio] == valor)
			{
				return meio;
			} else if (vet[meio] > valor)
			{
				fim = meio - 1;
			} else
			{
				inicio = meio + 1;
			}
		}
		return -1;
	}
	
	public static int buscaBinariaRecursica(double vet[], double valor)
	{
		return buscaBinariaRecursica(vet, 0, (vet.length -1), valor );
	}
	
	public static int buscaBinariaRecursica(double vet[],int inicio, int fim, double valor)
	{
		int meio;
		if(inicio <= fim)
		{
			meio = (inicio + fim) / 2;
			if (vet[meio] == valor)
			{
				return meio;
			} else if (vet[meio] > valor)
			{
				return buscaBinariaRecursica( vet, inicio, meio - 1, valor);
			} else
			{
				 return buscaBinariaRecursica( vet, meio + 1, fim , valor);
			}
		}
		return -1;
	}
}
