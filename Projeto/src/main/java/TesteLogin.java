import java.util.Locale;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

public class TesteLogin {
	WebDriver driver;
	WebDriverWait wait;
	static Faker faker = new Faker(new Locale("pt", "BR"));
	public static final String FAKER_APELIDO = (faker.code().asin());
	public static final String FAKER_EMAIL = (faker.internet().emailAddress());
	public static final String FAKER_NOME = (faker.name().firstName());
	public static final String FAKER_SOBRENOME = (faker.name().lastName());
	public static final String FAKER_CIDADE = faker.address().city();
	public static final String FAKER_ENDEREÇO = faker.address().streetAddress();
	public static final String FAKER_TELEFONE = faker.phoneNumber().phoneNumber();
	public static final String FAKER_ESTADO = faker.address().citySuffix();
	public static final String FAKER_CEP = faker.address().zipCode();
	public static final String FAKER_PASSWORD = faker.internet().password(11, 12, true, true, true);

	@Test
	public void teste() throws InterruptedException {

		TelaHomeTest.abriURL(TelaHomeTest.URL);
		TelaHomeTest.cadastra(TelaHomeTest.USER_LOGAR, TelaHomeTest.CREAT_NEW_ACCOUNT, TelaHomeTest.USER_NAME, TelaHomeTest.SENHA, TelaHomeTest.CONFIRMA_SENHA, TelaHomeTest.NOME,
				TelaHomeTest.SOBRE_NOME, TelaHomeTest.TELEFONE, TelaHomeTest.PAIS_DE_ORIGEM, TelaHomeTest.CIDADE, TelaHomeTest.ENDERECO, TelaHomeTest.ESTADO, TelaHomeTest.CEP,
				TelaHomeTest.CHECK_BOX_ACEITAR, TelaHomeTest.BOTAO_REGISTRAR, TelaHomeTest.CAMPO_EMAIL);
		TelaHomeTest.Desloga(TelaHomeTest.USER_DESLOGAR, TelaHomeTest.DESLOGAR);
		TelaHomeTest.Loga(TelaHomeTest.USER_LOGAR, TelaHomeTest.LOGAR_USERNAME, TelaHomeTest.LOGAR_SENHA, TelaHomeTest.SIGN_IN);
		TelaHomeTest.acessaConta(TelaHomeTest.USER_DESLOGAR, TelaHomeTest.MY_ACCOUNT);

	}

}
