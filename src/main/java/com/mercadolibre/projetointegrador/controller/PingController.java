package com.mercadolibre.projetointegrador.controller;

import com.newrelic.api.agent.NewRelic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class PingController {

	@GetMapping("/ping")
	public String ping() {
		NewRelic.ignoreTransaction();
		return "pong";
	}
}
