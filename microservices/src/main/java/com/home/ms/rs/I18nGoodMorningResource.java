package com.home.ms.rs;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/i18n")
public class I18nGoodMorningResource {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
	public String getGoodMorning(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		
		return messageSource.getMessage("message", null, locale);
	}
	
	@GetMapping(path = "/v2", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getGoodMorning2() {
		
		return messageSource.getMessage("message", null, LocaleContextHolder.getLocale());
	}
}
