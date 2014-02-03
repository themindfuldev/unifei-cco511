import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Controle
{
	// Atributos
	private boolean conectado;
	private Statement stmt;

	// Construtor
	public Controle()
	{
		// Estabelece a conexão com o BD.
		try
		{
			Class.forName("org.firebirdsql.jdbc.FBDriver");

			Connection c = DriverManager
					.getConnection(
							"jdbc:firebirdsql:localhost/3050:F:/Java/CCO511/lab6/bd/ESCOLA.FDB",
							"SYSDBA", "adm");
			stmt = c.createStatement();
			conectado = true;
		}
		catch (Exception e)
		{
			conectado = false;
		}
	}

	// Retorna se está conectado
	public boolean getConectado()
	{
		return conectado;
	}

	// Retorna uma consulta a todos os alunos com a consulta especificada, ou null para todos os registros.
	public ArrayList<ArrayList<Object>> consultaAlunos(String consulta) throws SQLException
	{
		ResultSet rs;
		ArrayList<ArrayList<Object>> lista = new ArrayList<ArrayList<Object>>();

		if (consulta != null) rs = stmt.executeQuery("SELECT * FROM Aluno" + consulta + ";");			
		else rs = stmt.executeQuery("SELECT * FROM Aluno;");
		
		while (rs.next())
		{
			ArrayList<Object> tupla = new ArrayList<Object>();
			tupla.add(rs.getInt(1));
			tupla.add(rs.getString(2));
			tupla.add(rs.getString(3));
			tupla.add(rs.getDate(4));
			tupla.add(rs.getString(5));
			lista.add(tupla);			
		}
		
		return lista;
	}
	
	// Retorna uma consulta a todas as disciplinas com a consulta especificada, ou null para todos os registros.
	public ArrayList<ArrayList<Object>> consultaDisciplinas(String consulta) throws SQLException
	{
		ResultSet rs;
		ArrayList<ArrayList<Object>> lista = new ArrayList<ArrayList<Object>>();

		if (consulta != null) rs = stmt.executeQuery("SELECT * FROM Discip" + consulta + ";");			
		else rs = stmt.executeQuery("SELECT * FROM Discip;");
		while (rs.next())
		{
			ArrayList<Object> tupla = new ArrayList<Object>();
			tupla.add(rs.getInt(1));
			tupla.add(rs.getString(2));
			tupla.add(rs.getInt(3));
			lista.add(tupla);			
		}
		
		return lista;
	}	

	// Insere uma disciplina no BD.
	public void inserirDisciplina(String nome, int creditos) throws SQLException
	{
		stmt.executeUpdate("INSERT INTO Discip VALUES (0, '" + nome + "', " + creditos + ");");
	}	
	
	// Insere um aluno no BD.
	public void inserirAluno(String nome, String rg, Calendar data, String fone) throws SQLException
	{
		Date dataSQL = new Date(data.getTimeInMillis());
		stmt.executeUpdate("INSERT INTO Aluno VALUES (0, '" + nome + "', '" + rg + "', '" + dataSQL + "', '" + fone + "');");
	}

	// Remove uma disciplina do BD.
	public void removerDisciplina(int codigo) throws SQLException
	{
		stmt.executeUpdate("DELETE FROM Discip WHERE CODIGO = " + codigo + ";");
	}	
	
	// Remove um aluno do BD.
	public void removerAluno(int codigo) throws SQLException
	{
		stmt.executeUpdate("DELETE FROM Aluno WHERE CODIGO = " + codigo + ";");
	}

	// Altera uma disciplina no BD.
	public void alterarDisciplina(int codigo, String nome, int creditos) throws SQLException
	{
		stmt.executeUpdate("UPDATE Discip SET NOME = '" + nome + "', CREDITOS = " + creditos + " WHERE CODIGO = " + codigo + ";");
	}	
	
	// Altera um aluno no BD.
	public void alterarAluno(int codigo, String nome, String rg, Calendar data, String fone) throws SQLException
	{
		Date dataSQL = new Date(data.getTimeInMillis());		
		stmt.executeUpdate("UPDATE Aluno SET NOME = '" + nome + "', RG = '" + rg + "', DT_NASC = '" + dataSQL + "', FONE = '" + fone + "' WHERE CODIGO = " + codigo + ";");
	}	
	
}
