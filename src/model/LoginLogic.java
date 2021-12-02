package model;
import dao.AccountDAO;

public class LoginLogic {
	//login情報でログインできればtrueを返す
	public boolean execute(Login login) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(login);
		return account != null;
	}
}
