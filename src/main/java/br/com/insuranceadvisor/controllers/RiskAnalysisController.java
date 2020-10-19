package br.com.insuranceadvisor.controllers;

import br.com.insuranceadvisor.models.Analysis;
import br.com.insuranceadvisor.models.RiskProfile;
import br.com.insuranceadvisor.usecases.RiskAnalysisUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
    @RequestMapping(value = "${api.version}/risk-analysis", produces = MediaType.APPLICATION_JSON_VALUE)
public class RiskAnalysisController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RiskAnalysisController.class);

    @Autowired
    private RiskAnalysisUseCase useCase;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<RiskProfile> analyse(@Valid @RequestBody Analysis toAnalysis) {
        LOGGER.info("Called RiskAnalysisController method analyse ({})", toAnalysis.toString());

        return ResponseEntity.ok(useCase.calculateRisk(toAnalysis));
    }
}
