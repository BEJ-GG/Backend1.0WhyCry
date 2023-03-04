package enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum EnumException {

	NOT_FOUND("A consulta realizada não retornou nenhum resultado", HttpStatus.NOT_FOUND),
	BAD_REQUEST("A requisição está incorreta, por favor consultar a documentação do serviço", HttpStatus.BAD_REQUEST),
	INTERNAL_SERVER_ERROR("Ocorreu um erro inesperado, entre em contato com a equipe de TI Desenvolvimento", HttpStatus.INTERNAL_SERVER_ERROR),
	UNAUTHORIZED("As credencias estão incorretas ou inválidas, tente logar novamente", HttpStatus.UNAUTHORIZED);

	String message;
	HttpStatus status;

}
