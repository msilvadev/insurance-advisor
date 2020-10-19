package br.com.insuranceadvisor.usecases;

import br.com.insuranceadvisor.models.Analysis;
import br.com.insuranceadvisor.models.RiskProfile;
import br.com.insuranceadvisor.models.RiskProfileStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RiskAnalysisUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(RiskAnalysisUseCase.class);

    @Autowired
    private ScoreRulesProfile scoreRulesProfile;

    public RiskProfile calculateRisk(Analysis toAnalysis) {
        LOGGER.info("Called calculateRisk({})", toAnalysis);

        RiskProfile riskProfile = new RiskProfile();
        Score score = new Score();

        calculateScore(toAnalysis, riskProfile, score);

        return riskProfile;
    }

    private void calculateScore(Analysis toAnalysis, RiskProfile riskProfile, Score score){
        LOGGER.info("Calculating score...");

        scoreRulesProfile.evaluate(toAnalysis, riskProfile, score);

        riskProfile.setAuto(insuranceResult(score.getAuto()));
        riskProfile.setDisability(insuranceResult(score.getDisability()));
        riskProfile.setHome(insuranceResult(score.getHome()));
        riskProfile.setLife(insuranceResult(score.getLife()));

        scoreRulesProfile.checkIneligibleRule(toAnalysis, riskProfile, score);

        LOGGER.info("Score calculated!");
    }

    private RiskProfileStatus insuranceResult(int score){
        LOGGER.info("Called insuranceResult({})", score);

        if (score <= 0){
            return RiskProfileStatus.ECONOMIC;
        } else if (score == 1 || score == 2){
            return RiskProfileStatus.REGULAR;
        } else if (score >= 3){
            return RiskProfileStatus.RESPONSIBLE;
        }

        return null;
    }
}
