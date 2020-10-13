package br.com.insuranceadvisor.usecases;

import br.com.insuranceadvisor.model.RiskProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RiskAnalysisUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(RiskAnalysisUseCase.class);

    public RiskProfile calculateRisk() {

        return new RiskProfile();
    }

}
