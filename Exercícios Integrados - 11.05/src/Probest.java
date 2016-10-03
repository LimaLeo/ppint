import java.util.HashMap;

public class Probest
{
	public static double somatoria(double v[])
	{
		double soma = 0.0;
		for (int i = 0; i < v.length; i++)
		{
			soma += v[i];
		}
		return soma;
	}

	public static double media(double v[])
	{
		double media = 0.0, soma = somatoria(v);

		media = (soma / v.length);
		return media;
	}

	public static double desvioPadao(double v[])
	{
		double media = media(v), somaXiXQ = 0;
		for (int i = 0; i < v.length; i++)
		{
			somaXiXQ += (v[i] - media) * (v[i] - media);
		}
		double desvPadao = Math.sqrt(somaXiXQ / (v.length - 1));
		return desvPadao;
	}

	public static double variancia(double v[])
	{
		double var = 0, desvPadao = desvioPadao(v);
		var = desvPadao * desvPadao;
		return var;
	}

	public static double mediana(double v[])
	{
		Ordenacao.selecao(v);
		int tipo = v.length % 2;

		if (tipo == 1)
		{
			return v[((v.length + 1) / 2) - 1];
		} else
		{
			int m = v.length / 2;
			return (v[m - 1] + v[m]) / 2;

		}
	}

	public static double moda(double v[])
	{

		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		Integer i;
		Double moda = 0.0;
		Integer numAtual, numMaior = 0;
		for (int count = 0; count < v.length; count++)
		{

			i = (Integer) map.get(new Double(v[count]));

			if (i == null)
			{

				map.put(new Double(v[count]), new Integer(1));

			} else
			{

				map.put(new Double(v[count]), new Integer(i.intValue() + 1));
				numAtual = i.intValue() + 1;

				if (numAtual > numMaior)
				{

					numMaior = numAtual;

					moda = new Double(v[count]);
				}
			}
		}
		return moda;
	}

	public static double coefAssimetria(double v[])
	{
		return (3*(media(v) - mediana(v))) / desvioPadao(v);
	}

	public static double coefVariacao(double v[])
	{
		return (desvioPadao(v) / media(v)) * 100;
	}
}
