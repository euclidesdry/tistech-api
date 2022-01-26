package api.tistech.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NumerosService {

	public static String uniao(String a, String b) {
		log.info("Unindo o terceiro(C)");
		String resultado = unir(a, b, 0);
		return Integer.parseInt(resultado) > 1_000_000 ? "-1" : resultado;
	}

	private static String unir(String a, String b, int cursor) {
		log.info("Unindo os caracters ...");

		if (cursor == a.length() && b.length() == a.length()) {
			return "";
		}

		if (cursor == a.length() - 1 && b.length() > a.length()) {
			return a.charAt(cursor) + b.substring(cursor);
		}

		if (cursor == b.length() - 1 && b.length() < a.length()) {
			return b.charAt(cursor) + a.substring(cursor);
		}

		String temp = "" + a.charAt(cursor) + b.charAt(cursor);
		return temp + unir(a, b, cursor + 1);
	}

}
