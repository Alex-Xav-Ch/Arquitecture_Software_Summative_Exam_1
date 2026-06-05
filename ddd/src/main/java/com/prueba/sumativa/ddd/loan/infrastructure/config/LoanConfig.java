package com.prueba.sumativa.ddd.loan.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prueba.sumativa.ddd.loan.application.port.in.RegistrarDevolucionUseCase;
import com.prueba.sumativa.ddd.loan.application.port.in.RegistrarPrestamoUseCase;
import com.prueba.sumativa.ddd.loan.application.port.out.CatalogPort;
import com.prueba.sumativa.ddd.loan.application.port.out.UserPort;
import com.prueba.sumativa.ddd.loan.application.useCaseImp.RegistrarDevolucionService;
import com.prueba.sumativa.ddd.loan.application.useCaseImp.RegistrarPrestamoService;
import com.prueba.sumativa.ddd.loan.domain.repository.PrestamoRepository;
import com.prueba.sumativa.ddd.loan.domain.service.PrestamoDomainService;

@Configuration
public class LoanConfig {

    @Bean
    public PrestamoDomainService prestamoDomainService() {
        return new PrestamoDomainService();
    }

    @Bean
    public RegistrarPrestamoUseCase registrarPrestamoUseCase(
            PrestamoRepository prestamoRepository,
            CatalogPort catalogPort,
            UserPort userPort,
            PrestamoDomainService prestamoDomainService) {

        return new RegistrarPrestamoService(
                prestamoRepository,
                catalogPort,
                userPort,
                prestamoDomainService
        );
    }

    @Bean
    public RegistrarDevolucionUseCase registrarDevolucionUseCase(
            PrestamoRepository prestamoRepository,
            CatalogPort catalogPort) {

        return new RegistrarDevolucionService(
                prestamoRepository,
                catalogPort
        );
    }
}
