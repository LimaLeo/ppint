
public class Ordenacao extends Probest
{
	public static void bolha(double vet[])
	{
		for (int i = 1; i <= vet.length - 1; i++)
			for (int j = 0; j < vet.length - 1; j++)
				if (vet[j] > vet[j + 1])
				{
					double aux = vet[j];
					vet[j] = vet[j + 1];
					vet[j + 1] = aux;
				}
	}

	public static void selecao(double vet[])
	{
		for (int i = 0; i < vet.length - 1; i++)
		{
			int indMenor = i;
			for (int j = i + 1; j < vet.length; j++)
			{
				if (vet[j] < vet[indMenor])
					indMenor = j;
			}
			double aux = vet[i];
			vet[i] = vet[indMenor];
			vet[indMenor] = aux;
		}
	}

	public static void insercao(double vet[])
	{
		for (int i = 1; i < vet.length; i++)
		{
			double aux = vet[i];
			int j = i - 1;
			while (j >= 0 && vet[j] > aux)
			{
				vet[j + 1] = vet[j];
				j--;
			}
			vet[j + 1] = aux;
		}
	}

	public static void mergeSort(double vet[])
	{
		double vetaux[] = new double[vet.length];
		mergeSort(vet, 0, vet.length - 1, vetaux);
	}

	public static void mergeSort(double vet[], int inicio, int fim, double vetaux[])
	{
		if (fim - inicio >= 1) // 2 ou mais elementos
		{
			int meio = (inicio + fim) / 2;
			mergeSort(vet, inicio, meio, vetaux);
			mergeSort(vet, meio + 1, fim, vetaux);
			mescla(vet, inicio, meio, fim, vetaux);
		}

		// não há nada que fazer com menos de 2 elementos
	}

	public static void mescla(double vet[], int inicio, int meio, int fim, double vetaux[])
	{
		int i = inicio;
		int j = meio + 1;
		int k = inicio;

		while (k <= fim) // organizando em vetaux
		{
			if (i <= meio && j <= fim)
			{
				if (vet[i] < vet[j])
				{
					vetaux[k] = vet[i];
					i++;
					k++;
				} else
				{
					vetaux[k] = vet[j];
					j++;
					k++;
				}
			} else if (i > meio)
			{
				vetaux[k] = vet[j];
				j++;
				k++;
			} else
			{
				vetaux[k] = vet[i];
				i++;
				k++;
			}
		}

		for (i = inicio; i <= fim; i++) // copiando de volta de vetaux para vet
			vet[i] = vetaux[i];
	}

	// http://www.algolist.net/Algorithms/Sorting/Quicksort
	public static void quickSort(double vet[])
	{
		quickSort(vet, 0, vet.length - 1);
	}

	private static void quickSort(double vet[], int esquerda, int direita)
	{
		int indice = particao(vet, esquerda, direita);
		if (esquerda < indice - 1)
			quickSort(vet, esquerda, indice - 1);
		if (indice < direita)
			quickSort(vet, indice, direita);
	}

	private static int particao(double vet[], int esquerda, int direita)
	{
		int i = esquerda, j = direita;
		double aux;
		double pivo = vet[(esquerda + direita) / 2];

		while (i <= j)
		{
			while (vet[i] < pivo)
				i++;
			while (vet[j] > pivo)
				j--;
			if (i <= j)
			{
				aux = vet[i];
				vet[i] = vet[j];
				vet[j] = aux;
				i++;
				j--;
			}
		}

		return i;
	}

}
