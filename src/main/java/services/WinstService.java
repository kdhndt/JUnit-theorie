package services;

import repositories.KostRepository;
import repositories.OpbrengstRepository;

import java.math.BigDecimal;

public class WinstService {
    private final OpbrengstRepository opbrengstRepository;
    private final KostRepository kostRepository;

    public WinstService(OpbrengstRepository opbrengstRepository, KostRepository kostRepository) {
        this.opbrengstRepository = opbrengstRepository;
        this.kostRepository = kostRepository;
    }

    public BigDecimal getWinst() {
        return opbrengstRepository.findTotaleOpbrengst().subtract(kostRepository.findTotaleKost());
    }

}
