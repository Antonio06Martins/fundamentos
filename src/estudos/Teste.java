package estudos;

import java.util.Objects;

public class Teste {
    public static void main(String[] args) {
        //String nome = null;
        String nome = "Antonio";
        var verificaSeEhNulo = Objects.nonNull(nome);
        System.out.println(verificaSeEhNulo);
        System.out.println(nome);

    }
}


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMACValidator {
    private static final String HMAC_ALGORITHM = "HmacSHA256"; // Usando o algoritmo SHA-256 por exemplo
    private static final String SECRET_KEY = "your_secret_key"; // Chave secreta compartilhada

    public static boolean isValidHMAC(String data, String hmacToValidate) {
        try {
            // Inicialize a instância da classe Mac com o algoritmo HMAC
            Mac hmac = Mac.getInstance(HMAC_ALGORITHM);
            // Crie uma chave secreta para o HMAC com base na chave secreta compartilhada
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), HMAC_ALGORITHM);
            // Inicialize o objeto Mac com a chave secreta
            hmac.init(secretKey);
            // Calcule a HMAC dos dados fornecidos
            byte[] calculatedHMAC = hmac.doFinal(data.getBytes());
            // Converta a HMAC calculada em uma representação de string hexadecimal
            String calculatedHMACString = DatatypeConverter.printHexBinary(calculatedHMAC);
            // Compare a HMAC calculada com a HMAC fornecida na solicitação
            return calculatedHMACString.equals(hmacToValidate);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return false;
        }
    }
}



import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HMACValidationFilter extends RequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // Lógica para determinar se a solicitação é para a rota específica a ser validada com HMAC
        if (isRouteToValidateWithHMAC(httpServletRequest)) {
            // Lógica para validar HMAC
            if (!isValidHMAC(httpServletRequest)) {
                // Se o HMAC não for válido, você pode retornar uma resposta de erro aqui ou simplesmente encerrar a cadeia de filtro
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        // Se não for uma rota que requer validação HMAC ou se o HMAC for válido, chame o método original para colocar cabeçalhos no MDC e continue com a cadeia de filtro
        super.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
    }

    private boolean isRouteToValidateWithHMAC(HttpServletRequest httpServletRequest) {
        // Lógica para determinar se a solicitação é para a rota específica que requer validação HMAC
        // Você pode comparar a URI da solicitação ou usar outra lógica para isso
        return httpServletRequest.getRequestURI().equals("/rota-a-validar-com-hmac");
    }

    private boolean isValidHMAC(HttpServletRequest httpServletRequest) {
        // Lógica para validar HMAC
        // Implemente sua lógica de validação HMAC aqui
        // Por exemplo, você pode acessar o cabeçalho HMAC da solicitação e verificar se corresponde a um HMAC esperado
        String hmacHeader = httpServletRequest.getHeader("X-HMAC");
        String expectedHMAC = "your_expected_hmac_value";

        return hmacHeader != null && hmacHeader.equals(expectedHMAC);
    }
}



public class HMACValidationFilter extends RequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // Lógica para determinar se a solicitação é para a rota específica a ser validada com HMAC
        if (isRouteToValidateWithHMAC(httpServletRequest)) {
            // Lógica para validar HMAC
            if (!isValidHMAC(httpServletRequest)) {
                // Se o HMAC não for válido, você pode retornar uma resposta de erro aqui ou simplesmente encerrar a cadeia de filtro
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        // Se não for uma rota que requer validação HMAC ou se o HMAC for válido, chame o método original para colocar cabeçalhos no MDC e continue com a cadeia de filtro
        super.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
    }

    private boolean isRouteToValidateWithHMAC(HttpServletRequest httpServletRequest) {
        // Lógica para determinar se a solicitação é para a rota específica que requer validação HMAC
        // Você pode comparar a URI da solicitação ou usar outra lógica para isso
        return httpServletRequest.getRequestURI().equals("/rota-a-validar-com-hmac");
    }

    private boolean isValidHMAC(HttpServletRequest httpServletRequest) {
        // Lógica para validar HMAC
        // Implemente sua lógica de validação HMAC aqui
        return true; // Retorne true se o HMAC for válido, caso contrário, false
    }
}




@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<HMACValidationFilter> loggingFilter() {
        FilterRegistrationBean<HMACValidationFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new HMACValidationFilter());
        registrationBean.addUrlPatterns("/rota-a-validar/*"); // Defina aqui a rota específica a ser validada

        return registrationBean;
    }
}




public class HMACValidationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Lógica de validação HMAC para a rota específica
        if (isRouteToValidate(request)) {
            if (!isValidHMAC(request)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        // Passa para o próximo filtro na cadeia
        filterChain.doFilter(request, response);
    }

    private boolean isRouteToValidate(HttpServletRequest request) {
        // Lógica para determinar se a rota atual precisa de validação HMAC
        // Você pode comparar a URI da solicitação ou usar outra lógica para isso
        return request.getRequestURI().equals("/rota-a-validar");
    }

    private boolean isValidHMAC(HttpServletRequest request) {
        // Lógica para validar o HMAC da solicitação
        // Implemente sua lógica de validação HMAC aqui
        return true; // Retorne true se o HMAC for válido, caso contrário, false
    }
}




import org.springframework.stereotype.Component;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class HmacValidator {

    // Chave secreta para o HMAC (substitua pela sua chave real)
    private static final String SECRET_KEY = "suaChaveSecreta";

    // Algoritmo de hash para o HMAC
    private static final String HMAC_ALGORITHM = "HmacSHA256";

    // Método para validar o HMAC
    public boolean validateHmac(HttpServletRequest request, String receivedHmac) {
        try {
            // Recupera o corpo da requisição
            String requestBody = getRequestBody(request);

            // Constrói a mensagem a ser usada para calcular o HMAC
            String message = request.getMethod() + request.getRequestURI() + requestBody;

            // Calcula o HMAC
            String calculatedHmac = calculateHmac(message);

            // Verifica se os HMACs são iguais
            if (!receivedHmac.equals(calculatedHmac)) {
                return false;
            }
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            // Lidar com exceções
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Método para calcular o HMAC de uma mensagem
    private String calculateHmac(String message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM);
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hmacBytes);
    }

    // Método para obter o corpo da requisição como uma string
    private String getRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder requestBodyBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBodyBuilder.append(line);
            }
        }
        return requestBodyBuilder.toString();
    }
}



import org.springframework.stereotype.Component;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class HmacValidator {

    // Chave secreta para o HMAC (substitua pela sua chave real)
    private static final String SECRET_KEY = "suaChaveSecreta";

    // Algoritmo de hash para o HMAC
    private static final String HMAC_ALGORITHM = "HmacSHA256";

    // Método para validar o HMAC
    public boolean validateHmac(HttpServletRequest request, String receivedHmac) {
        try {
            // Recupera o corpo da requisição
            String requestBody = getRequestBody(request);

            // Constrói a mensagem a ser usada para calcular o HMAC
            String message = request.getMethod() + request.getRequestURI() + requestBody;

            // Calcula o HMAC
            String calculatedHmac = calculateHmac(message);

            // Verifica se os HMACs são iguais
            return receivedHmac.equals(calculatedHmac);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            // Lidar com exceções
            e.printStackTrace();
            return false;
        }
    }

    // Método para calcular o HMAC de uma mensagem
    private String calculateHmac(String message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM);
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hmacBytes);
    }

    // Método para obter o corpo da requisição como uma string
    private String getRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder requestBodyBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBodyBuilder.append(line);
            }
        }
        return requestBodyBuilder.toString();
    }
}



import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean<HmacValidationFilter> filterRegistrationBean() {
        FilterRegistrationBean<HmacValidationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new HmacValidationFilter());
        registrationBean.addUrlPatterns("/sua-rota-especifica/*"); // Defina as URLs que devem ser filtradas
        return registrationBean;
    }
}



import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class HmacValidationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialização do filtro (opcional)
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Verifica se a requisição é para a rota específica que requer validação HMAC
        if ("/sua-rota-especifica".equals(request.getRequestURI())) {
            // Recupera o HMAC recebido na requisição
            String receivedHmac = request.getHeader("X-Hmac-Digest");

            // Constrói a mensagem a ser usada para calcular o HMAC
            String message = request.getMethod() + request.getRequestURI() + getRequestBody(request);

            // Calcula o HMAC (substitua este método pelo cálculo real do HMAC)
            String calculatedHmac = calculateHmac(message);

            // Verifica se os HMACs são iguais
            if (!receivedHmac.equals(calculatedHmac)) {
                // Se os HMACs não são iguais, retorna um erro 401 (Unauthorized)
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Erro de autenticação: HMAC inválido");
                return;
            }
        }

        // Continua com o processamento da requisição
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Liberação de recursos (opcional)
    }

    // Método para calcular o HMAC de uma mensagem (substitua por sua lógica real)
    private String calculateHmac(String message) {
        // Implemente a lógica para calcular o HMAC com base na sua chave secreta
        // Este é apenas um exemplo simplificado
        return "HMAC_CALCULADO";
    }

    // Método para obter o corpo da requisição como uma string
    private String getRequestBody(HttpServletRequest request) throws IOException {
        // Implemente a lógica para obter o corpo da requisição como uma string
        // Aqui está apenas um exemplo
        // Você pode usar uma biblioteca como Apache Commons IO para isso
        // Ou implementar manualmente lendo o InputStream
        return "Corpo da requisição";
    }
}



import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1) // Definindo a ordem do filtro
public class HmacValidationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Verifica se a requisição é para a rota específica que requer validação HMAC
        if ("/sua-rota-especifica".equals(request.getRequestURI())) {
            // Recupera o HMAC recebido na requisição
            String receivedHmac = request.getHeader("X-Hmac-Digest");

            // Constrói a mensagem a ser usada para calcular o HMAC
            String message = request.getMethod() + request.getRequestURI() + getRequestBody(request);

            // Calcula o HMAC (substitua este método pelo cálculo real do HMAC)
            String calculatedHmac = calculateHmac(message);

            // Verifica se os HMACs são iguais
            if (!receivedHmac.equals(calculatedHmac)) {
                // Se os HMACs não são iguais, retorna um erro 401 (Unauthorized)
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Erro de autenticação: HMAC inválido");
                return;
            }
        }

        // Continua com o processamento da requisição
        filterChain.doFilter(request, response);
    }

    // Método para calcular o HMAC de uma mensagem (substitua por sua lógica real)
    private String calculateHmac(String message) {
        // Implemente a lógica para calcular o HMAC com base na sua chave secreta
        // Este é apenas um exemplo simplificado
        return "HMAC_CALCULADO";
    }

    // Método para obter o corpo da requisição como uma string
    private String getRequestBody(HttpServletRequest request) throws IOException {
        // Implemente a lógica para obter o corpo da requisição como uma string
        // Aqui está apenas um exemplo
        // Você pode usar uma biblioteca como Apache Commons IO para isso
        // Ou implementar manualmente lendo o InputStream
        return "Corpo da requisição";
    }
}




import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class HmacValidationInterceptor implements HandlerInterceptor {

    // Chave secreta para o HMAC (substitua pela sua chave real)
    private static final String SECRET_KEY = "suaChaveSecreta";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Verifica se a requisição é para a rota específica que requer validação HMAC
        if ("/sua-rota-especifica".equals(request.getRequestURI())) {
            // Recupera o HMAC recebido na requisição
            String receivedHmac = request.getHeader("X-Hmac-Digest");

            // Constrói a mensagem a ser usada para calcular o HMAC
            String message = request.getMethod() + request.getRequestURI() + getRequestBody(request);

            // Calcula o HMAC
            String calculatedHmac = calculateHmac(message);

            // Verifica se os HMACs são iguais
            if (!receivedHmac.equals(calculatedHmac)) {
                // Se os HMACs não são iguais, retorna um erro 401 (Unauthorized)
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("Erro de autenticação: HMAC inválido");
                return false;
            }
        }
        return true;
    }

    // Método para calcular o HMAC de uma mensagem usando a chave secreta
    private String calculateHmac(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest((message + SECRET_KEY).getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            // Lidar com exceção
            e.printStackTrace();
            return null;
        }
    }

    // Método para obter o corpo da requisição como uma string
    private String getRequestBody(HttpServletRequest request) {
        // Implemente a lógica para obter o corpo da requisição como uma string
        // Aqui está apenas um exemplo
        // Você pode usar uma biblioteca como Apache Commons IO para isso
        // Ou implementar manualmente lendo o InputStream
        return "Corpo da requisição";
    }
}




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final HmacValidationInterceptor hmacValidationInterceptor;

    @Autowired
    public WebMvcConfig(HmacValidationInterceptor hmacValidationInterceptor) {
        this.hmacValidationInterceptor = hmacValidationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(hmacValidationInterceptor);
    }
}




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HmacValidationInterceptor implements HandlerInterceptor {

    private final HmacValidationService hmacValidationService;

    @Autowired
    public HmacValidationInterceptor(HmacValidationService hmacValidationService) {
        this.hmacValidationService = hmacValidationService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Verifica se a requisição é para a rota específica que requer validação HMAC
        if ("/sua-rota-especifica".equals(request.getRequestURI())) {
            // Recupera o HMAC recebido na requisição
            String receivedHmac = request.getHeader("X-Hmac-Digest");

            // Valida o HMAC usando a classe HmacValidationService
            boolean hmacValido = hmacValidationService.validateHmac(request, receivedHmac);

            if (!hmacValido) {
                // Se o HMAC não é válido, retorna um erro 401 (Unauthorized)
                response.sendError(HttpStatus.UNAUTHORIZED.value(), "Erro de autenticação: HMAC inválido");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Nada a ser feito após o processamento do handler
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Nada a ser feito após a conclusão do processamento
    }
}





import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    private final HmacValidationService hmacValidationService;

    public PessoaController(HmacValidationService hmacValidationService) {
        this.hmacValidationService = hmacValidationService;
    }

    @PostMapping("/pessoas")
    public ResponseEntity<String> criarPessoa(
            @RequestBody Pessoa pessoa,
            @RequestHeader("X-Hmac-Digest") String hmacHeader) {
        
        // Valida o HMAC usando a classe HmacValidationService
        boolean hmacValido = hmacValidationService.validateHmac(pessoa, hmacHeader);
        
        if (hmacValido) {
            // O HMAC é válido, continue com o processamento da requisição
            // Aqui você pode adicionar a lógica para criar a pessoa no banco de dados, por exemplo
            return ResponseEntity.ok("Pessoa criada com sucesso!");
        } else {
            // O HMAC não é válido, retorne um erro 401 (Unauthorized)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro de autenticação: HMAC inválido");
        }
    }
}




public class HmacValidationService {

    // Método para validar o HMAC de uma requisição com base no objeto Pessoa e no header HMAC
    public boolean validateHmac(Pessoa pessoa, String hmacHeader) {
        // Verifica se a pessoa e o HMAC estão presentes
        if (pessoa == null || StringUtils.isEmpty(hmacHeader)) {
            return false;
        }

        // Cria a string a ser usada para calcular o HMAC
        String dataToHash = pessoa.getNome() + pessoa.getId();

        // Calcula o HMAC usando a chave secreta (substitua "suaChaveSecreta" pela sua chave real)
        String calculatedHmac = calculateHmac(dataToHash, "suaChaveSecreta");

        // Verifica se o HMAC calculado é igual ao HMAC recebido no header
        return hmacHeader.equals(calculatedHmac);
    }

    // Método para calcular o HMAC de uma string usando uma chave secreta
    private String calculateHmac(String data, String secretKey) {
        // Implemente aqui a lógica para calcular o HMAC com base na sua chave secreta
        // Este é apenas um exemplo simplificado
        // Consulte a documentação do algoritmo de HMAC que você está usando para obter detalhes sobre como calcular o HMAC corretamente
        return "HMAC_CALCULADO";
    }
}



import org.apache.commons.codec.binary.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class HmacValidator {

    private static final String HMAC_ALGORITHM = "HmacSHA256";

    public static <T> boolean validateHmac(T message, String receivedHmac, String secretKey) {
        try {
            byte[] messageBytes = serializeObject(message);

            Mac hmac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), HMAC_ALGORITHM);
            hmac.init(secretKeySpec);

            byte[] calculatedHmacBytes = hmac.doFinal(messageBytes);
            String calculatedHmac = Base64.encodeBase64String(calculatedHmacBytes);

            return calculatedHmac.equals(receivedHmac);
        } catch (NoSuchAlgorithmException | InvalidKeyException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static <T> byte[] serializeObject(T obj) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return outputStream.toByteArray();
    }

    public static void main(String[] args) {
        // Exemplo de objeto de mensagem
        YourObject message = new YourObject();
        String secretKey = "ChaveSecreta";
        String receivedHmac = "HMAC recebido";

        // Validação do HMAC
        boolean isValid = HmacValidator.validateHmac(message, receivedHmac, secretKey);
        System.out.println("O HMAC é válido? " + isValid);
    }

    // Defina a classe do seu objeto aqui
    static class YourObject implements java.io.Serializable {
        // Defina os campos e métodos relevantes para o seu objeto aqui
    }
}



import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HmacValidator {

    private static final String HMAC_ALGORITHM = "HmacSHA256";

    public static boolean validateHmac(String message, String receivedHmac, String secretKey) {
        try {
            // Criação de uma instância do algoritmo HMAC
            Mac hmac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), HMAC_ALGORITHM);
            hmac.init(secretKeySpec);

            // Calcula o HMAC para a mensagem
            byte[] calculatedHmacBytes = hmac.doFinal(message.getBytes());
            String calculatedHmac = Base64.getEncoder().encodeToString(calculatedHmacBytes);

            // Compara o HMAC calculado com o HMAC recebido
            return calculatedHmac.equals(receivedHmac);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String message = "Mensagem a ser autenticada";
        String secretKey = "ChaveSecreta";
        String receivedHmac = "HMAC recebido";

        // Validação do HMAC
        boolean isValid = HmacValidator.validateHmac(message, receivedHmac, secretKey);
        System.out.println("O HMAC é válido? " + isValid);
    }
}





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter extends OncePerRequestFilter {

    private final HmacValidator hmacValidator;

    @Autowired
    public RequestFilter(HmacValidator hmacValidator) {
        this.hmacValidator = hmacValidator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        putHeadersInMDC(httpServletRequest);

        // Verifica se a requisição é para a rota específica que requer validação HMAC
        if ("/sua-rota-especifica".equals(httpServletRequest.getRequestURI())) {
            // Recupera o HMAC recebido na requisição
            String receivedHmac = httpServletRequest.getHeader("X-Hmac-Digest");

            // Valida o HMAC usando o HmacValidator
            if (!hmacValidator.validateHmac(httpServletRequest, receivedHmac)) {
                // Se a validação falhar, retorna um código de status HTTP 401
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        // Continua com o processamento da requisição
        filterChain.doFilter(httpServletRequest, httpServletResponse);

        MDC.clear();
    }

    private void putHeadersInMDC(HttpServletRequest httpServletRequest) {
        MDC.put(LogKey.HTTP_REQUEST, String.format("%s %s", httpServletRequest.getMethod(), httpServletRequest.getRequestURI()));
        Optional.ofNullable(httpServletRequest.getHeaderNames()).ifPresent(
                ignored -> HEADERS_FOR_LOGGING.forEach(header -> MDC.put(header, httpServletRequest.getHeader(header))));
    }
}


import org.springframework.stereotype.Component;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class HmacValidator {

    // Chave secreta para o HMAC (substitua pela sua chave real)
    private static final String SECRET_KEY = "suaChaveSecreta";

    // Algoritmo de hash para o HMAC
    private static final String HMAC_ALGORITHM = "HmacSHA256";

    // Método para validar o HMAC
    public boolean validateHmac(HttpServletRequest request, String receivedHmac) {
        try {
            // Recupera o corpo da requisição
            String requestBody = getRequestBody(request);

            // Constrói a mensagem a ser usada para calcular o HMAC
            String message = request.getMethod() + request.getRequestURI() + requestBody;

            // Calcula o HMAC
            String calculatedHmac = calculateHmac(message);

            // Verifica se os HMACs são iguais
            if (!receivedHmac.equals(calculatedHmac)) {
                return false;
            }
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            // Lidar com exceções
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Método para calcular o HMAC de uma mensagem
    private String calculateHmac(String message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM);
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hmacBytes);
    }

    // Método para obter o corpo da requisição como uma string
    private String getRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder requestBodyBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBodyBuilder.append(line);
            }
        }
        return requestBodyBuilder.toString();
    }
}



