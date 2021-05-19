import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class TelaHomeTest {
	static WebDriver driver;
	static WebDriverWait wait;
	static Faker faker = new Faker(new Locale("pt", "BR"));

	public static final String URL = ("https://www.advantageonlineshopping.com/#/");
	public static final String USER_LOGAR = ("menuUser");
	public static final String CREAT_NEW_ACCOUNT = ("create-new-account");
	public static final String USER_NAME = ("usernameRegisterPage");
	public static final String SENHA = ("passwordRegisterPage");
	public static final String CONFIRMA_SENHA = ("confirm_passwordRegisterPage");
	public static final String NOME = ("first_nameRegisterPage");
	public static final String SOBRE_NOME = ("last_nameRegisterPage");
	public static final String TELEFONE = ("phone_numberRegisterPage");
	public static final String PAIS_DE_ORIGEM = ("countryListboxRegisterPage");
	public static final String CIDADE = ("cityRegisterPage");
	public static final String ENDERECO = ("addressRegisterPage");
	public static final String ESTADO = ("state_/_province_/_regionRegisterPage");
	public static final String CEP = ("postal_codeRegisterPage");
	public static final String CHECK_BOX_ACEITAR = ("i_agree");
	public static final String BOTAO_REGISTRAR = ("register_btnundefined");
	public static final String CAMPO_EMAIL = ("emailRegisterPage");
	public static final String USER_DESLOGAR = ("menuUserLink");
	public static final String DESLOGAR = ("#loginMiniTitle > label:nth-child(3)");
	public static final String MY_ACCOUNT = ("#loginMiniTitle > label:nth-child(1)");
	public static final String USERNAME_LOGIN = ("username");
	public static final String SENHA_LOGIN = ("password");
	public static final String SIGN_IN = ("sign_in_btnundefined");
	public static final String LOGAR_USERNAME = ("username");
	public static final String LOGAR_SENHA = ("password");

	public static void abriURL(String URL) {
		System.setProperty("webdriver.chrome.driver", "\\Users\\Fernando.Bandeira\\Desktop\\pastachromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
		driver.get(URL);
	}

	public static void cadastra(String user_logar, String creat_new_account, String user_name, String senha, String confirma_senha, String nome, String sobre_nome, String telefone,
			String pais_de_origem, String cidade, String endereco, String estado, String cep, String check_box_aceitar, String botao_registrar, String campo_email) {

		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(user_logar)));
		user.click();
		WebElement createaccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(creat_new_account)));
		createaccount.click();
		WebElement campousername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(user_name)));
		campousername.sendKeys(TesteLogin.FAKER_APELIDO);
		driver.findElement(By.name(campo_email)).sendKeys(TesteLogin.FAKER_EMAIL);
		driver.findElement(By.name(senha)).sendKeys(TesteLogin.FAKER_PASSWORD);
		driver.findElement(By.name(confirma_senha)).sendKeys(TesteLogin.FAKER_PASSWORD);
		driver.findElement(By.name(nome)).sendKeys(TesteLogin.FAKER_NOME);
		driver.findElement(By.name(sobre_nome)).sendKeys(TesteLogin.FAKER_SOBRENOME);
		driver.findElement(By.name(telefone)).sendKeys(TesteLogin.FAKER_TELEFONE);
		WebElement element = driver.findElement(By.name(pais_de_origem));
		Select combo = new Select(element);
		combo.selectByIndex(3);
		driver.findElement(By.name(cidade)).sendKeys(TesteLogin.FAKER_CIDADE);
		driver.findElement(By.name(endereco)).sendKeys(TesteLogin.FAKER_ENDEREÇO);
		driver.findElement(By.name(estado)).sendKeys(TesteLogin.FAKER_ESTADO);
		driver.findElement(By.name(cep)).sendKeys(TesteLogin.FAKER_CEP);
		driver.findElement(By.name(check_box_aceitar)).click();
		driver.findElement(By.id(botao_registrar)).click();

	}

	public static void Desloga(String user_deslogar, String deslogar) throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id(user_deslogar)).click();
		driver.findElement(By.cssSelector(deslogar)).click();

	}

	public static void Loga(String user_logar, String logar_username, String logar_senha, String sign_in) throws InterruptedException {

		Thread.sleep(1000);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(user_logar)));
		user.click();
		Thread.sleep(1000);
		driver.findElement(By.name(logar_username)).sendKeys(TesteLogin.FAKER_APELIDO);
		driver.findElement(By.name(logar_senha)).sendKeys(TesteLogin.FAKER_PASSWORD);
		driver.findElement(By.id(sign_in)).click();
	}

	public static void acessaConta(String user_desloga, String my_account) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id(user_desloga)).click();
		driver.findElement(By.cssSelector(my_account)).click();
//		driver.quit();
	}

}