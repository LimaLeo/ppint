import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		Connection conn = null;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Cliente cl;
		Pedido pd;
		try {
			// obtem conexao com o banco
			AcessoBD bd = new AcessoBD();
			conn = bd.obtemConexao();
			// *** IMPORTANTE ***: For�a o uso de transa��o.
			conn.setAutoCommit(false);
			// *** Inclusao do Primeiro Cliente ***
			cl = new Cliente(1001, "Z� das Couves", "1127991999");
			pd = new Pedido(10001, (Date) formatter.parse("29/01/2009"), 150.00);
			cl.adicionaPedido(pd);
			pd = new Pedido(10002, (Date) formatter.parse("15/03/2009"), 100.00);
			cl.adicionaPedido(pd);
			pd = new Pedido(10003, (Date) formatter.parse("18/06/2009"), 75.00);
			cl.adicionaPedido(pd);
			cl.incluir(conn);
			// *** Inclusao do Segundo Cliente ***
			cl = new Cliente();
			cl.setIdCliente(1002);
			cl.setNome("Jo�o das Couves");
			cl.setFone("1160606161");
			pd = new Pedido(10004, (Date) formatter.parse("01/03/2009"), 250.00);
			cl.adicionaPedido(pd);
			pd = new Pedido(10005, (Date) formatter.parse("15/08/2009"), 400.00);
			cl.adicionaPedido(pd);
			cl.incluir(conn);
			// *** Inclusao do Terceiro Cliente ***
			cl = new Cliente(1003, "Maria das Couves", "1121212121");
			pd = new Pedido(10006, (Date) formatter.parse("20/09/2009"), 650.00);
			cl.adicionaPedido(pd);
			cl.incluir(conn);
			// *** IMPORTANTE ***: Efetiva inclus�es
			conn.commit();
			// *** Carregar o cliente 1002 a partir do bd ***
			cl = new Cliente(1002);
			cl.carregar(conn);
			// *** Excluir o cliente 1002 (carregado em cl) do bd
			cl.excluir(conn);
			// *** IMPORTANTE ***: Efetiva exclus�o
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
}