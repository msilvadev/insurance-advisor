package br.com.insuranceadvisor.models;

public class RiskProfile {
    private RiskProfileStatus auto;
    private RiskProfileStatus disability;
    private RiskProfileStatus home;
    private RiskProfileStatus life;

    public RiskProfile() { }

    public RiskProfile(RiskProfileStatus auto, RiskProfileStatus disability,
                       RiskProfileStatus home, RiskProfileStatus life) {
        this.auto = auto;
        this.disability = disability;
        this.home = home;
        this.life = life;
    }

    public RiskProfileStatus getAuto() {
        return auto;
    }

    public void setAuto(RiskProfileStatus auto) {
        this.auto = auto;
    }

    public RiskProfileStatus getDisability() {
        return disability;
    }

    public void setDisability(RiskProfileStatus disability) {
        this.disability = disability;
    }

    public RiskProfileStatus getHome() {
        return home;
    }

    public void setHome(RiskProfileStatus home) {
        this.home = home;
    }

    public RiskProfileStatus getLife() {
        return life;
    }

    public void setLife(RiskProfileStatus life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return "RiskProfile{" +
                "auto=" + auto +
                ", disability=" + disability +
                ", home=" + home +
                ", life=" + life +
                '}';
    }
}
